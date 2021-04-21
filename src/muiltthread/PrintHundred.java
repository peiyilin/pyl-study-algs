package muiltthread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintHundred {

    public static void main(String[] args) {
        /*Resource resource = new Resource();
        List<Runnable> runList = new ArrayList<>();
        resource.maxVal=100;
        runList.add(() -> {
            resource.printNnm(resource.firstCondition, resource.secondCondition);
        });
        runList.add(() -> {
            resource.printNnm(resource.secondCondition, resource.thirdCondition);
        });
        runList.add(() -> {
            resource.printNnm(resource.thirdCondition, resource.fourthCondition);
        });
        runList.add(() -> {
            resource.printNnm(resource.fourthCondition, resource.firstCondition);
        });
        for (int i = 1; i <= runList.size(); i++) {
            new Thread(runList.get(i - 1), "" + i).start();
        }*/

        ABCPrint abcPrint = new ABCPrint();
        List<Runnable> runList = new ArrayList<>();
        runList.add(() -> {
            abcPrint.printABC(abcPrint.firstCondition,abcPrint.secondCondition);
        });
        runList.add(() -> {
            abcPrint.printABC(abcPrint.secondCondition,abcPrint.thirdCondition);
        });
        runList.add(() -> {
            abcPrint.printABC(abcPrint.thirdCondition,abcPrint.firstCondition);
        });

        for (int i = 1; i <= runList.size(); i++) {
            new Thread(runList.get(i - 1)).start();
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
        Condition thirdCondition = lock.newCondition();
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

     static class ABCPrint{
        String[] abc = new String[]{"A","B","C"};
        int num = 0;
        int count = 5*abc.length;
        Lock lock = new ReentrantLock();
        Condition firstCondition = lock.newCondition();
        Condition secondCondition = lock.newCondition();
        Condition thirdCondition = lock.newCondition();

        void printABC(Condition self,Condition next) {
            lock.lock();
            try {
                while (count>0){
                    System.err.println(abc[num%abc.length]);
                    num++;
                    count--;
                    next.signal();
                    self.await();
                }
                next.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}