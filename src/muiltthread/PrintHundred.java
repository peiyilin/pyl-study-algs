package muiltthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintHundred {

    public static void main(String[] args) {
        Resource resource = new Resource();
        List<Runnable> runList = new ArrayList<>();
        resource.maxVal=100;
        runList.add(() -> {
            resource.printNnm(resource.firstCondition, resource.secondCondition);
        });
        runList.add(() -> {
            resource.printNnm(resource.secondCondition, resource.thridCondition);
        });
        runList.add(() -> {
            resource.printNnm(resource.thridCondition, resource.fourthCondition);
        });
        runList.add(() -> {
            resource.printNnm(resource.fourthCondition, resource.firstCondition);
        });
        for (int i = 1; i <= runList.size(); i++) {
            new Thread(runList.get(i - 1), "" + i).start();
        }
    }

    static class Resource {
        // 初始值
        int num = 0;
        //最大值
        int maxVal = 0;
        Lock lock = new ReentrantLock();
        Condition firstCondition = lock.newCondition();
        Condition secondCondition = lock.newCondition();
        Condition thridCondition = lock.newCondition();
        Condition fourthCondition = lock.newCondition();

        public void printNnm(Condition self, Condition next) {
            lock.lock();
            try {
                // 打印到99
                while (num < maxVal) {
                    num += 1;
                    System.out.println("线程" + Thread.currentThread().getName() + "打印num当前值" + num);
                    next.signal();
                    self.await();
                }
                // 最后一个打印99结束也要唤醒下一个线程，保证下一个线程不在阻塞状态
                next.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}