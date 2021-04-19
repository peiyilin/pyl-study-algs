package algs;

/**
 * @author: peiyilin
 * @description:
 * @date: 2020/9/25 17:36
 */
public class SortedUtil {

    /**
     * 冒泡排序
     *
     * @param a
     */
    public static void bubbleSort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("排序数组不可为空");
        }
        int length = a.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length; i++) {
            //表示是否有数据交换
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     * @param a
     */
    public static void insertionSort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("排序数组不可为空");
        }
        int length = a.length;
        if (length <= 1) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            int val = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > val) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //插入数据
            a[j + 1] = val;
        }
    }

    /**
     * 选择排序
     * @param a
     */
    public static void selectionSort(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("排序数组不可为空");
        }
        int length = a.length;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            int mixValIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[mixValIndex]) {
                    mixValIndex = j;
                }
            }
            //最小值的索引下标不是已排序的区间数组的末尾，交换
            if (mixValIndex != i){
                int temp = a[i];
                a[i] = a[mixValIndex];
                a[mixValIndex] = temp;
            }
        }
    }

    public static void quickSort(int[] a,int start,int end){
        if (start>= end){
            return;
        }
        int position = partition(a,start,end);
        quickSort(a,start,position-1);
        quickSort(a,position+1,end);
    }

    private static int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int left = start;
        for (int i=start;i<end;i++){
            if (a[i] < pivot){
                int temp = a[left];
                a[left++] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[left];
        a[left] = pivot;
        a[end] = temp;
        return left;
    }
}
