package com.weichao.exercise.redis;

import redis.clients.jedis.Jedis;

import java.util.Map;

public class HgetTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.hset("Person","name","weichao");
        jedis.hset("Person","age","25");
        jedis.hset("Person","id","1");

        Map<String,String> map = jedis.hgetAll("Person");

        System.out.println(map.toString());
    }
}
