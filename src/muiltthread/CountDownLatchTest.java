package muiltthread;

import java.util.concurrent.*;

/**
 * @author: peiyilin
 * @description: 举个例子，早上部门开会，有人在上厕所，这时候需要等待所有人从厕所回来之后才能开始会议
 * @date: 2021/3/25 16:56
 */
public class CountDownLatchTest {

    private int num = 3;

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static ExecutorService executorService = new ThreadPoolExecutor(
            3,3,60,TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));

    public static void main(String[] args) throws InterruptedException {
        System.err.println("开会时间到了");
        executorService.execute(() -> {
            System.err.println("A在上厕所");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
                System.err.println("A上完了");
            }
        });
        executorService.execute(() -> {
            System.err.println("B在上厕所");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
                System.err.println("B上完了");
            }
        });
        executorService.execute(() -> {
            System.err.println("C在上厕所");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
                System.err.println("C上完了");
            }
        });
        System.err.println("等待所有人上完厕所后再开会");
        countDownLatch.await();
        System.err.println("所有人都上完厕所了，开会");
        executorService.shutdownNow();
    }
}
