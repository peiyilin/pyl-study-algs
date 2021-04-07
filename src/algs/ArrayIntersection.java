package algs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: peiyilin
 * @description:
 * @date: 2021/4/7 18:35
 */
public class ArrayIntersection {

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int m = nums2.length;
        int[] res = new int[Math.min(n,m)];
        int indexN = 0,indexM=0,indexRes =0;
        while(indexN<n && indexM<m){
            if(nums1[indexN]==nums2[indexM]){
                res[indexRes++] = nums2[indexM];
                indexM++;
                indexN++;
            }else if(nums1[indexN]>nums2[indexM]){
                indexM++;
            }else{
                indexN++;
            }
        }
        return Arrays.copyOfRange(res, 0, indexRes);
    }

    /**
     * hash映射
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2){
        int length1 = nums1.length;
        int length2 = nums2.length;
        //映射较小的数组可节省空间
        if (length1 > length2){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int num : nums1) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int[] res = new int[Math.min(length1,length2)];
        int indexRes = 0;
        for (int num : nums2) {
            int count = map.get(num);
            if (count>0){
                res[indexRes++] = num;
                count--;
            }
            if (count==0){
                map.remove(num);
            }
        }
        return Arrays.copyOfRange(res,0,indexRes);
    }

    public static void main(String[] args) {
        ArrayIntersection intersection = new ArrayIntersection();
        int[] nums1 = new int[]{4,5,9,4};
        int[] nums2 = new int[]{9,4,9,8,4};
        Arrays.stream(intersection.intersect(nums2, nums1)).forEach(System.err::println);
    }
}
