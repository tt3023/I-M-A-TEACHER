package org.teacher.test;

import org.myteacher.util.SetSystemProperty;

/**
 * Created by yh on 17-2-9.
 */
public class Test2 {
    public static void main(String[] args) {

//        System.out.println(ParseProperties.getProperties("login"));
//        System.out.println(ReadProperties.getKeyValue("login"));
//        String json = "{\"name\":\"aa\",\"flag\":\"login\",\"methods\":\"getKeys\"}";
//        Map<String,Object> param = JsonUtil.strToMap(json);
//        String name = JsonUtil.pojoToJson(param.get("name"));
//        name = name.toString().substring(1,name.length()-1);
//        String flag = JsonUtil.pojoToJson(param.get("flag"));
//        flag = flag.toString().substring(1,flag.length()-1);
//        System.out.println(ParseProperties.getProperties(flag));
//        String method = JsonUtil.pojoToJson(param.get("methods"));
//        method = method.substring(1,method.length()-1);
//        System.out.printf(name +" "+flag+" "+method);
//        Room room = new Room("AAA","123","19:56");
//        System.out.println(JsonUtil.pojoToJson(room.toString()));

//        String jsonString = "{\"name\":\"aa\",\"flag\":\"login\",\"methods\":\"getKeys\"}";
//        System.out.println(JsonUtil.toJson(jsonString));
//        System.out.println(JsonUtil.getData(jsonString,"flag"));
//        System.out.println(JsonUtil.strToMap(jsonString).get("name"));
//        System.out.println(JsonUtil.strToMap(jsonString).get("flag"));
//        System.out.println(JsonUtil.strToMap(jsonString).get("methods"));

//        System.out.println(JsonUtil.pojoToJson(JsonUtil.strToMap(jsonString).get("name")));
//        System.out.println(JsonUtil.pojoToJson(JsonUtil.strToMap(jsonString).get("flag")));
//        System.out.println(JsonUtil.pojoToJson(JsonUtil.strToMap(jsonString).get("methods")));

//        String txt = JsonUtil.pojoToJson(room.toString());
//        System.out.println(txt);
//        System.out.println(JsonUtil.isJson(txt));
//        System.out.println(JsonUtil.isJson(jsonString));


//        String value = (String) JsonUtil.strToMap(jsonString).get("name");
//        System.out.println(value);

//         Room room = new Room("AAA","123","19:56");
//         System.out.println(JsonUtil.pojoToJson(room));
//         String json = JsonUtil.pojoToJson(room);
//         Map<String,Object> map = JsonUtil.strToMap(json);
//         String json1 = JsonUtil.pojoToJson(map);
//        System.out.println(json1);


//         Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
//         while (it.hasNext()) {
//            Map.Entry<String, Object> entry = it.next();
//            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//         }
//

//         Map<String,Object> map1 = new HashMap<>();
//
//        map1.put("name","aa");
//        map1.put("age","23");
//
//        Iterator<Map.Entry<String, Object>> its = map1.entrySet().iterator();
//        while (its.hasNext()) {
//            Map.Entry<String, Object> entry1 = its.next();
//            System.out.println("key= " + entry1.getKey() + " and value= " + entry1.getValue());
//        }

//        String jsonString = "{\"name\":\"aa\",\"flag\":\"login\",\"methods\":\"getKeys\"}";
//        Map<String,Object> map2 = JsonUtil.strToMap(jsonString);
//        Iterator<Map.Entry<String, Object>> it3 = map2.entrySet().iterator();
//        while (it3.hasNext()) {
//            Map.Entry<String, Object> entry3 = it3.next();
//            System.out.println("key= " + entry3.getKey() + " and value= " + entry3.getValue());
//        }
//
//        JsonUtil.pojoToJson(map2);


//        String test = "org.myteacher.process.RoomOutProess|getRoominfo";
//        String t1 = test.substring(0,test.indexOf("|"));
//        String t2 = test.substring(test.indexOf("|")+1,test.length());
//        System.out.println(t1);
//        System.out.println(t2);

//        String jsonString = "{\"date\":{\"name\":\"aa\",\"age\":\"bb\"},\"flag\":\"login\"}";
//        Map<String,Object> map = JsonUtil.strToMap(jsonString);
//        String ttt = (String) map.get("flag");
//        String flag = JsonUtil.pojoToJson(map.get("flag"));
//        System.out.println(flag.substring(1,flag.length()-1));
//        System.out.println(flag);
//        System.out.println(ttt);
//
//        System.out.println(ParseProperties.getProperties(ttt));
//        System.out.println(ParseProperties.getProperties(flag.substring(1,flag.length()-1)));
//          String test = "org.myteacher.process.test.Login|AccountIsExits";
//        System.out.println(test.substring(test.indexOf("|")+1,test.length()));
//
//          String txt = "AAAAAbbbbb";
//          /*
//            10
//            AAAAbbbbb
//           */
//        System.out.println(txt.length());
//        System.out.println(txt.substring(0,txt.length()-1));

//        Room room = new Room("AA","123","1995.11.45");
//        MyRoom room1 = new MyRoom("AA","123","计算机",
//                "1955.11.22","http://www.baidu.com","skdlfj;lads","456");
//        String json = JsonUtil.pojoToJson(room);
//        String json1 = JsonUtil.pojoToJson(room1);
//        System.out.println(json1);
//        System.out.println(json);

//public User(String userId,String photoUrl,String phoneNumber,String password,String userName){
//        User user = new User("123","http:www.bai.com","135465465","****","adf");
//
//
//        String json = JsonUtil.pojoToJson(user);
//        System.out.println(json);


        String txt = SetSystemProperty.getKeyValue("login");
        System.out.println(txt);


//        JedisUtil jedisUtil = new JedisUtil();
//        System.out.println(jedisUtil.getMemoryUsed());

    }

}
