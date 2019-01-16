package com.example.autoconfigure.redis;

import java.util.Random;

/**
 * Created by sunlichuan on 18-6-5
 */
public class RedisConstant {
    public static final String UNLOCK_LUA;
    public static final String LOCK_SUCCESS = "OK";
    public static final String SET_IF_NOT_EXIST = "NX";
    public static final String SET_WITH_EXPIRE_TIME = "PX";
    static {
        StringBuilder buffer = new StringBuilder();
        buffer.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        buffer.append("then ");
        buffer.append("    return redis.call(\"del\",KEYS[1]) ");
        buffer.append("else ");
        buffer.append("    return 0 ");
        buffer.append("end ");
        UNLOCK_LUA = buffer.toString();
    }

}
