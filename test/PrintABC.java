package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author wangmin
 * @since 2023/8/8 10:42
 */
public class PrintABC {
    private static int count = 0;

    public void method1() throws InterruptedException {
        ReentrantLock l1 = new ReentrantLock();
        Condition c1 = l1.newCondition();
        Condition c2 = l1.newCondition();
        Condition c3 = l1.newCondition();
        Thread a = new Thread(() -> {
            while (true) {
                l1.lock();
                try {
                    while (count % 3 != 0) {
                        c1.await();
                    }
                    System.out.println("A");
                    count++;
                    c2.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    l1.unlock();
                }

            }
        });
        a.start();

        Thread b = new Thread(() -> {
            while (true) {
                l1.lock();
                try {
                    while (count % 3 != 1) {
                        c2.await();
                    }
                    System.out.println("B");
                    count++;
                    c3.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    l1.unlock();
                }
            }
        });
        b.start();

        Thread c = new Thread(() -> {
            while (true) {
                l1.lock();
                try {
                    while (count % 3 != 2) {
                        c3.await();
                    }
                    System.out.println("C");
                    count++;
                    c1.signalAll();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    l1.unlock();
                }
            }
        });
        c.start();

        new CountDownLatch(1).await();

    }

    public void method2() throws InterruptedException {
        Object o = new Object();
        Thread a = new Thread(() -> {
            while (true) {
                synchronized (o) {
                    while (count % 3 != 0) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("A");
                    count++;
                    o.notifyAll();
                }
            }
        });
        a.start();

        Thread b = new Thread(() -> {
            while (true) {
                synchronized (o) {
                    while (count % 3 != 1) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("B");
                    count++;
                    o.notifyAll();
                }
            }
        });
        b.start();

        Thread c = new Thread(() -> {
            while (true) {
                synchronized (o) {
                    while (count % 3 != 2) {
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("C");
                    count++;
                    o.notifyAll();
                }
            }
        });
        c.start();

        new CountDownLatch(1).await();

    }

    public void method3() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Thread a = new Thread(() -> {
            while (true) {
                while (count % 3 != 0) {
                    Thread.yield();
                }
                System.out.println("A");
                count++;
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        a.start();

        Thread b = new Thread(() -> {
            while (true) {
                while (count % 3 != 1) {
                    Thread.yield();
                }

                System.out.println("B");
                count++;
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b.start();

        Thread c = new Thread(() -> {
            while (true) {
                while (count % 3 != 2) {
                    Thread.yield();
                }

                System.out.println("C");
                count++;
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.start();

        new CountDownLatch(1).await();
    }

    public void method4() throws InterruptedException {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        Thread a = new Thread(() -> {
            while (true) {
                try {
                    s1.acquire();
                    System.out.println("A");
                    count++;
                    s2.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        a.start();

        Thread b = new Thread(() -> {
            while (true) {
                try {
                    s2.acquire();
                    System.out.println("B");
                    count++;
                    s3.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b.start();

        Thread c = new Thread(() -> {
            while (true) {
                try {
                    s3.acquire();
                    System.out.println("C");
                    count++;
                    s1.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.start();

        new CountDownLatch(1).await();
    }

    public void method5() throws InterruptedException {
        BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);
        BlockingQueue<String> q3 = new ArrayBlockingQueue<>(1);
        q1.put("A");
        Thread a = new Thread(() -> {
            while (true) {
                try {
                    q1.take();
                    System.out.println("A");
                    count++;
                    q2.put("B");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        a.start();

        Thread b = new Thread(() -> {
            while (true) {
                try {
                    q2.take();
                    System.out.println("B");
                    count++;
                    q3.put("C");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        b.start();

        Thread c = new Thread(() -> {
            while (true) {
                try {
                    q3.take();
                    System.out.println("C");
                    count++;
                    q1.put("A");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        c.start();

        new CountDownLatch(1).await();
    }




    public static void main(String[] args) throws InterruptedException {
        System.out.println("1");
        AtomicInteger a = new AtomicInteger(1);
        a.get();
        a.compareAndSet(1, 2);
        System.out.println(a);
//        new PrintABC().method5();
    }
}
