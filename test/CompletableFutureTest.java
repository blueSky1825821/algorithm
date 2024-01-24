package test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/8/8 15:13
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> false);
        future.thenApply(f -> {
            System.out.println(f);
            return f;
        });
        future.get();
        test1();
    }

    public static void test1() throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            System.out.println("====");
            future.complete("完成");
        }).start();
        System.out.println(future.get());

        TimeUnit.SECONDS.sleep(5);

    }
}
