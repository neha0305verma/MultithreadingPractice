import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

public class RadisConcurrentConnection implements Runnable {
    private Jedis redisConnect;
    public void run(){
        RedisConnector redis = new RedisConnector();
        this.redisConnect = redis.conectRedis();
        this.redisConnect.lpush("tutorial-list-2", "Redis-2 "+": "+(int) (new Date().getTime()));
        this.redisConnect.lpush("tutorial-list-2", "Mongodb-2 "+": "+(int) (new Date().getTime()));
        this.redisConnect.lpush("tutorial-list-2", "Mysql-2 "+": "+(int) (new Date().getTime()));
        // Get the stored data and print it
        List<String> list = this.redisConnect.lrange("tutorial-list-2", 0 ,5);

        for(int i = 0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
    }
}
