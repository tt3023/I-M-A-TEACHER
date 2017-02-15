package org.myteacher.hanndler;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;
import org.myteacher.util.JsonUtil;
import org.myteacher.util.RefMethodTool;
import org.myteacher.util.SetSystemProperty;

import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by yh on 17-2-7.
 */
public class HttpServerHanndler extends ChannelInboundHandlerAdapter {

    private static final Logger Log = Logger.getLogger(HttpServerHanndler.class);

    private HttpRequest request;
    private String uri;
    private static  String data ;
    private static String flag;
    private static String classinfo;
    private static String methodname ;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if(msg instanceof HttpRequest){
            request = (HttpRequest)msg;
            uri = request.uri();
            String quenue = uri.substring(1,uri.length());
            System.out.println("the uri is "+quenue);
            Log.debug("Quenue is"+quenue);
        }

        if(msg instanceof HttpContent){
            HttpContent content = (HttpContent)msg;
            ByteBuf buf = content.content();
            String message = buf.toString(CharsetUtil.UTF_8);
            System.out.println(message);
            Log.debug("message is"+message);
            buf.release();
            //解析json串,找对应的反射类
            System.out.println(JsonUtil.isJson(message));
            Log.debug("boolean is "+ JsonUtil.isJson(message));
            Map<String,Object> param = JsonUtil.strToMap(message);
            Log.debug("param is "+param.toString());


            //前台数据的格式：{"data":{"动态拼接的内容"},"flag":"resource.properties文件的key",}
            //ex:判断用户是否注册过  {"data":{"key":"usernumber"},"flag":"login"}

            /*
               获取教室信息的json串
               {"data":{"room|老师ID":"room|001"},"flag":"roomOut"}
               {"data":{"room|001":"room1"},"flag":"roomOut"}

               身份验证的json串
               {“data”：{"userId":"1213",“phoneNumber”：“13545640028”,"idNumber":"421087199511225014","code":"123",},"flag":“useridentified”}

             */

            // {"date":{"name":"aa","age":"bb"},"flag":"login"}
            //处理类需要的前台的数据 以json的形式发送
            data = param.get("data").toString();
            Log.debug("is true or flase "+ JsonUtil.isJson(param.get("data").toString()));
            Log.debug("data is "+data);
            //反射类的映射
            String flag1 = JsonUtil.pojoToJson(param.get("flag"));
            Log.debug("flag1 is "+flag1);
            flag = flag1.substring(1,flag1.length()-1);
            Log.debug("flag is "+flag);
            //读取配置文件得到相应的处理类及方法
            String originalClassinfo = SetSystemProperty.getKeyValue(flag);
            Log.debug("origin classinfo is "+originalClassinfo);
            classinfo =originalClassinfo.substring(0,originalClassinfo.indexOf("|"));
            Log.debug("classinfo is "+classinfo);
            //反射的方法
            methodname = originalClassinfo.substring(originalClassinfo.indexOf("|")+1,originalClassinfo.length());
            Log.debug("methodname is "+methodname);
            //核心业务的处理
            String result = RefMethodTool.methodIvoke(data,classinfo,methodname);
            Log.debug("the result is "+result);
//            String result = "aaaa";
            FullHttpResponse response =
                    new DefaultFullHttpResponse(HTTP_1_1,OK,
                            Unpooled.wrappedBuffer(result.getBytes("UTF-8")));
            response.headers().set(CONTENT_TYPE,"text/plain");
            response.headers().setInt(CONTENT_LENGTH,response.content().readableBytes());
            if(HttpHeaderUtil.isKeepAlive(request)){
                response.headers().set(CONNECTION,KEEP_ALIVE);
            }
            ctx.writeAndFlush(response);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
        ctx.close();
        Log.debug("=============================================");
    }
}
