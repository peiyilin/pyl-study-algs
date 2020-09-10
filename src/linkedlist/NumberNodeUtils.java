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

}
