import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] arg){
        System.out.println("Multithreading Example");
        IncrementOperation incrementOperation = new IncrementOperation();
        for(int i=1; i<=5 ; i++){
            new Thread(incrementOperation, "Thread-"+i).start();
        }
        System.out.println("Multithreading Concurrent Example");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=1; i<=5; i++){
            executorService.submit(new IncrementOperationWithConcurrent()) ;
        }
        executorService.shutdownNow();

        System.out.println("Cassandra Redis Example");
        CassandraRedisConnection cr = new CassandraRedisConnection();
        cr.connectCassandra();
        cr.insertbook();
        cr.connectRedis();
        cr.insertRedis();
        System.out.println("Cassandra Redis concurrent Example ");
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(new CassandraRedisConcurrentConnection()) ;
        executorService2.submit(new RadisConcurrentConnection());
    }
}
