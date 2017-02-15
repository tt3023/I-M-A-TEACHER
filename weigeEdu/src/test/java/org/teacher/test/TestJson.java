package org.teacher.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.myteacher.util.JsonUtil;

/**
 * Created by yh on 17-2-10.
 */
public class TestJson {
    public static  String jsons = "{\n" +
            "\t\"classroomname\":\"我的专用教室\",\n" +
            "\t\"ownerId\":\"2123\",\n" +
            "\t\"roomId\":\"002\",\n" +
            "\t\"roomInfo\":\"hset\",\n" +
            "\t\"roomPhoto\":\"http:www.baidu.com\",\n" +
            "\t\"roomType\":\"相声\"\n" +
            "}";
    public static void main(String[] args) {
        test();

    }
    public static  void test(){
        JSONArray jsonArray = JsonUtil.getArrayFromJSON("classroomname", JSON.parseObject(jsons));
        System.out.println(jsonArray.toString());
    }
}
