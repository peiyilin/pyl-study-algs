package linkedlist;

/**
 * @author: peiyilin
 * @description: 链表相关算法
 * @date: 2020/9/10 15:57
 */
public class NumberNodeUtils {

    /**
     * 链表反转
     * @param node
     * @return
     */
    public static NumberNode reverseNode(NumberNode node){
        if (node == null || node.next == null) {
            return node;
        }
        NumberNode res = null;
        NumberNode next;
        while (node != null){
            next = node.next;
            node.next = res;
            res = node;
            node = next;
        }
        return res;
    }

    /**
     * 合并两个有序链表（递归）
     * @param node1
     * @param node2
     * @return
     */
    public static NumberNode mergeSortedNode(NumberNode node1,NumberNode node2){
        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }
        NumberNode res;
        if (node1.val > node2.val){
            res = node2;
            res.next = mergeSortedNode(node1,node2.next);
        }else {
            res = node1;
            res.next = mergeSortedNode(node1.next,node2);
        }
        return res;
    }

    /**
     * 删除倒数第n个节点
     * @param node
     * @param countBack
     * @return
     */
    public static NumberNode deleteBack(NumberNode node,int countBack){
        if (node == null || countBack <= 0) {
            return node;
        }
        //链表总节点个数
        int countTotal = 0;
        //临时节点
        NumberNode tempNode = node;
        while (tempNode != null){
            countTotal++;
            tempNode = tempNode.next;
        }
        if (countBack>countTotal){
            return node;
        }
        tempNode = node;
        //找到被删除节点的前一个节点
        int k = countTotal-countBack-1;
        while (k > 0){
            k--;
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        return node;
    }

    /**
     * 检测链表是否回环（快慢指针法）
     * @param node
     * @return
     */
    public static boolean isLoopback(NumberNode node){
        if (node == null) {
            return false;
        }
        NumberNode fast = node;
        NumberNode slow = node;
        //快指针每次走两步，慢指针每次走一步，如果相遇则说明链表回环
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 求链表的中间节点
     * @param node
     * @return
     */
    public static NumberNode getMiddle(NumberNode node){
        if (node == null){
            return node;
        }
        NumberNode fast = node;
        NumberNode slow = node;
        //快指针每次走两步，慢指针每次走一步，快指针走到末尾，慢指针即走到中间
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
