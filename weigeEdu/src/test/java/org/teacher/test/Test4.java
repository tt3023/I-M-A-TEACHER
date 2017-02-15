package org.teacher.test;


import redis.clients.jedis.Jedis;

/**
 * Created by yh on 17-2-11.
 */
public class Test4 {
    private static final String SERVER_ADDRESS = "127.0.0.1"; // 服务器地址
    private static final Integer SERVER_PORT = 6379; // 端口

    private static Jedis jedis;

    /**
     * 直接链接
     */
    public static void init() {
        System.out.println("===========================init=================================");
        jedis = new Jedis(SERVER_ADDRESS, SERVER_PORT);
    }
    public static void main(String[] args) {
        init();
        System.out.println(jedis.hget("room1","classroomname"));
    }
}
