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
}
