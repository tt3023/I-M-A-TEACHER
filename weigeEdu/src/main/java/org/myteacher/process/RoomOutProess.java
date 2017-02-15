package org.myteacher.process;

import com.alibaba.fastjson.JSONArray;
import org.apache.log4j.Logger;
import org.myteacher.pojo.MyRoom;
import org.myteacher.util.JsonUtil;
import org.myteacher.util.JedisUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yh on 17-2-10.
 */
public class RoomOutProess {
    private static Logger Log = Logger.getLogger(RoomOutProess.class);

    private JedisUtil jedisUtil = new JedisUtil();

    //存放结果的json数组
    private JSONArray results =new JSONArray();
    //教室对应的json
    private String result ;
    //教室的名字
    private String classroomname;
    //教室的id
    private String roomId;
    //教室类型
    private String roomType;
    //教室创建的时间
    private String roomTime;
    //教室图片的url
    private String roomPhoto;
    //教室的简介
    private String roomInfo;
    //教室的主人
    private String ownerId;

    public String getRoominfo(String data){
            Log.debug("the method RoomOutProcess.getRoomeinfo pararm is "+data);
        if(JsonUtil.isJson(data)){
            //通过room|老师id 找到 教室类型|roomID  通过roomID找到最终的value
            //{"roominfo":"room|001"}
            //将含有请求信息的json串转为map
            Map<String,Object> map = JsonUtil.strToMap(data);
            Log.debug("RoomOutProess map is "+map.toString());
            //得到map中的key
            Set<String> keys = map.keySet();
            Log.debug("RoomOutProess keys is "+keys.toString());
            for(String key:keys){
                //得到roomList的key
                String roomlistKey = map.get(key).toString();
                Log.debug("RoomOutProcess roomlist key is "+roomlistKey);
                //遍历roomlist
                List<String> roomLists = jedisUtil.getList(roomlistKey);
                Log.debug("PoomOutProcess list is "+roomLists.toString());

                for(int i =0;i<roomLists.size();i++){
                    String value = roomLists.get(i);
                    Log.debug("the 第"+i+" value is "+value);
                    //教室的名字
                    classroomname = jedisUtil.hget(value,"classroomname");
                    Log.debug("classroomname is "+classroomname);
                    //教室的ID
                    roomId = jedisUtil.hget(value,"roomId");
                    Log.debug("roomId is "+roomId);
                    //教室类型
                    roomType = jedisUtil.hget(value,"roomType");
                    Log.debug("roomType is "+roomType);
                    //教室创建的时间
                    roomTime = jedisUtil.hget(value,"roomTime");
                    Log.debug("roomTime is "+roomTime);
                    //教室图片的url
                    roomPhoto = jedisUtil.hget(value,"roomPhoto");
                    Log.debug("roomPhoto is "+roomPhoto);
                    //教室的简介
                    roomInfo = jedisUtil.hget(value,"roomInfo");
                    Log.debug("roomInfo is "+roomInfo);
                    //教室的主人
                    ownerId = jedisUtil.hget(value,"ownerId");
                    Log.debug("ownerId is "+ownerId);
                    //将取到的数据封装成pojo
                    MyRoom room = new MyRoom(classroomname,roomId,roomType,roomTime,roomPhoto,roomInfo,ownerId);
                    //将得到的room信息转为json数组
                    String temp = JsonUtil.pojoToJson(room);
                    Log.debug("temp is "+temp);
                    result = JsonUtil.pojoToJson(room);
                    Log.debug("getRoominfo result "+result);
                    results.add(i,result);
                }
            }
            Log.debug("getRoominfo results is "+results.toString());
            return results.toString();
        }else {
            Log.error("system error"+"data error.....");
            result = "system error.....";
            return result;
        }
    }
}
