import com.datastax.driver.core.Session;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

public class CassandraRedisConnection {
    private Session session;
    private Jedis redisConnect;

    public void connectCassandra() {
        CassandraConnector client = new CassandraConnector();
        client.connect("127.0.0.1", 9042);
        this.session = client.getSession();
    }
    public void insertbook() {
        for(int i=0; i<=10 ; i++) {
            StringBuilder sb = new StringBuilder("INSERT INTO ")
                    .append("library.Book").append("(id, title) ")
                    .append("VALUES (").append((int) (new Date().getTime()))
                    .append(", '").append("bookName").append("');");

            String query = sb.toString();
            session.execute(query);
        }

    }

    public void connectRedis(){
        RedisConnector redis = new RedisConnector();
        this.redisConnect = redis.conectRedis();
    }

    public void insertRedis(){
        this.redisConnect.lpush("tutorial-list", "Redis "+": "+(int) (new Date().getTime()));
        this.redisConnect.lpush("tutorial-list", "Mongodb "+": "+(int) (new Date().getTime()));
        this.redisConnect.lpush("tutorial-list", "Mysql "+": "+(int) (new Date().getTime()));
        // Get the stored data and print it
        List<String> list = this.redisConnect.lrange("tutorial-list", 0 ,5);

        for(int i = 0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
    }

}
