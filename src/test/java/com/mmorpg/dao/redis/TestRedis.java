package com.mmorpg.dao.redis;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestRedis {
     private static final Logger logger = LoggerFactory.getLogger(TestRedis.class);

    @Test
    public void test1(){
        Jedis jedis = new Jedis("127.0.0.1");
        logger.info("连接成功。。。");
        logger.info("检查服务是否正在运行:"+jedis.ping());

        // 测试字符串
        jedis.set("name","tomcat");
        logger.info("name:"+jedis.get("name"));
        logger.info("key1:"+jedis.get("mykey"));

        // 测试list
        jedis.lpush("list1","taobao");
        jedis.lpush("list1","sina");
        jedis.lpush("list1","baidu");
        List<String> list =  jedis.lrange("list1",0,2);
        for(int i=0;i<list.size();i++){
            logger.info("info:"+list.get(i));
        }
        logger.info("=====================================");
        // 打印redis中所有的key
        Set<String> keys = jedis.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            logger.info("key:"+iterator.next());
        }

        logger.info("=====================================");
        // 进行hash设置
        jedis.hset("hashname","hashkey","hvalue1");
        jedis.hset("hashname","hashkey","hvalue2");
        jedis.hset("hashname","hashkey2","hvalue2");
        jedis.hset("hashname","hashkey3","hvalue3");
        Map<String, String> hashname = jedis.hgetAll("hashname");
        String hashKey = hashname.get("hashkey");
        String hashkey2 = hashname.get("hashkey2");
        String hashkey3 = hashname.get("hashkey3");
        logger.info("hhhhh"+hashKey+","+hashkey2+","+hashkey3);

    }
}
