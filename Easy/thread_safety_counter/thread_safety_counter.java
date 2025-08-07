package thread_safety_counter;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private final AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

    public boolean setNewCountVal(int newCountValue) {
        return count.compareAndSet(this.getCount(), newCountValue);
    }
}

class Counter_2 {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

class Test {
    public void test_atomic() throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join(); // wait for all threads to finish
        }

        System.out.println("Final count (AtomicInteger): " + counter.getCount());
    }

    public void test_sync() throws InterruptedException {
        Counter_2 counter = new Counter_2();

        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final count (synchronized): " + counter.getCount());
    }
}

public class thread_safety_counter {
    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        test.test_atomic();
        test.test_sync();
    }
}
