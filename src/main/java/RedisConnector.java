import redis.clients.jedis.Jedis;

public class RedisConnector {
    public Jedis conectRedis(){
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to redis server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());
        return jedis;
    }
}
