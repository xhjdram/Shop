package shop.util;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    private static JedisPool pool = null;
    static{
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties ps= new Properties();
        try {
            ps.load(is );
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig jpc = new  JedisPoolConfig();
        jpc.setMaxIdle(Integer.parseInt(ps.getProperty("redis.maxIdle").toString()));
        jpc.setMinIdle(Integer.parseInt(ps.getProperty("redis.minIdle").toString()));
        jpc.setMaxTotal(Integer.parseInt(ps.getProperty("redis.maxTotal").toString()));
        pool = new JedisPool(jpc,ps.getProperty("redis.url"),Integer.parseInt(ps.get("redis.port").toString()));
    }
    public static Jedis getJedis(){
        return pool.getResource();
    }

}
