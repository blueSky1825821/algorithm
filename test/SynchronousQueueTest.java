package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/7/28 09:46
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);
        Thread thread1 = new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("put1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        Thread.sleep(2000);
        Thread thread2 = new Thread(() -> {
            try {
                queue.put(2);
                System.out.println("put2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        Thread.sleep(10000);

        Thread thread3 = new Thread(() -> {
            try {
                System.out.println("take" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread3.start();

        Thread.sleep(1000);

    }
}
