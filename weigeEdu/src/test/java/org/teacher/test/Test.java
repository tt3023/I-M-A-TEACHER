package org.teacher.test;

import org.myteacher.contants.Params;
import org.myteacher.server.HttpServer;

/**
 * Created by yh on 17-2-7.
 */
public class Test {

    public static void main(String[] args) {

//        RedisUtil redisUtil = RedisUtil.getRedisUtil();
//        Boolean b = redisUtil.exists("aa");
//        System.out.println(b);
//
        HttpServer httpServer = new HttpServer();
        System.out.println("开始启动整个后台服务。。。");

        httpServer.lunch(Params.NETTY_PORT);
    }


}
