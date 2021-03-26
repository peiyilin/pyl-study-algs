package muiltthread;

import java.util.concurrent.*;

/**
 * @author: peiyilin
 * @description:
 * @date: 2021/3/25 17:15
 */
public class CyclicBarrierTest {

    private static int num = 3;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(num,() -> {
        System.err.println("所有人都上完厕所了，开会");
    });

    private static ExecutorService executorService = new ThreadPoolExecutor(
            3,3,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10));

    public static void main(String[] args) {
        executorService.execute(() -> {
            System.err.println("A在上厕所");
            try {
                TimeUnit.SECONDS.sleep(2);
                System.err.println("A上完了");
                cyclicBarrier.await();
                System.err.println("会议结束，A退出");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            System.err.println("B在上厕所");
            try {
                TimeUnit.SECONDS.sleep(3);
                System.err.println("B上完了");
                cyclicBarrier.await();
                System.err.println("会议结束，B退出");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            System.err.println("C在上厕所");
            try {
                TimeUnit.SECONDS.sleep(4);
                System.err.println("C上完了");
                cyclicBarrier.await();
                System.err.println("会议结束，C退出");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
