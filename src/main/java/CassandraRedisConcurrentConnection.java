import com.datastax.driver.core.Session;

import java.util.Date;

public class CassandraRedisConcurrentConnection implements Runnable{
    private Session session;

    public void run() {
        CassandraConnector client = new CassandraConnector();
        client.connect("127.0.0.1", 9042);
        this.session = client.getSession();
        for(int i=0; i<=10 ; i++) {
            StringBuilder sb = new StringBuilder("INSERT INTO ")
                    .append("library.Book").append("(id, title) ")
                    .append("VALUES (").append((int) (new Date().getTime()))
                    .append(", '").append("bookName-2").append("');");

            String query = sb.toString();
            session.execute(query);
        }

    }
}
