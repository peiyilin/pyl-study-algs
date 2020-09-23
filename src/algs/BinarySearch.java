package algs;

/**
 * @author: peiyilin
 * @description: 二分查找
 * @date: 2020/9/23 17:02
 */
public class BinarySearch {

    /**
     * 循环实现
     * @param sortedArray
     * @param target
     * @return
     */
    public int binarySearch1(int[] sortedArray,int target){
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high){
            int mid = low + ((high-low) >> 1);
            if (sortedArray[mid] == target){
                return -1;
            }else if (sortedArray[mid] < target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     * @param sortedArray
     * @param target
     * @return
     */
    public int binarySearch2(int[] sortedArray,int target){
        return this.binarySearchRecursive(sortedArray,0,sortedArray.length-1,target);
    }

    /**
     *
     * @param sortedArray 有序数组
     * @param low 低位索引
     * @param high 高位索引
     * @param target 检索目标
     * @return
     */
    private int binarySearchRecursive(int[] sortedArray, int low, int high, int target) {
        if (low > high){
            return  -1;
        }
        int mid = low + ((high-low) >> 1);
        if (sortedArray[mid] == target){
            return mid;
        }else if (sortedArray[mid] < target){
            return binarySearchRecursive(sortedArray,mid+1,high,target);
        }else {
            return binarySearchRecursive(sortedArray,low,mid-1,target);
        }
    }
}
