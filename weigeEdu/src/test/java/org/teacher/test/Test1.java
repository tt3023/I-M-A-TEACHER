package org.teacher.test;

import org.myteacher.client.HttpClients;

/**
 * Created by yh on 17-2-7.
 */
public class Test1 {
    public static void main(String[] args) {

        String url = "http://127.0.0.1:30000";
        String jsonString = "{\"data\":{\"roominfo\":\"room|001\"},\"flag\":\"roomOut\"}";
        String encoding ="utf-8";
        try {
            String text = HttpClients.send(url,jsonString,encoding);
            System.out.println("the result is "+text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
