package org.teacher.test;

import org.myteacher.util.JsonUtil;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by yh on 17-2-10.
 */
public class Test3 {
    public static void main(String[] args) {
        String json = "{\"date\":{\"name\":\"aa\",\"age\":\"bb\"},\"flag\":\"login\"}";
        Map<String, Object> map = JsonUtil.strToMap(json);
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        Map<String,Object> map1 = JsonUtil.strToMap(map.get("date").toString());
        Iterator<Map.Entry<String, Object>> iterator = map1.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Object> entry = iterator.next();
            System.out.println("key = "+entry.getKey()+" and value= "+entry.getValue());
        }
    }
}
