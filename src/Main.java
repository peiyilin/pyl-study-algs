import linkedlist.NumberNode;
import linkedlist.NumberNodeUtils;

public class Main {

    public static void main(String[] args) {
        NumberNode node1 = new NumberNode(1);
        node1.next = new NumberNode(2);
        node1.next.next = new NumberNode(3);
        node1.next.next.next = new NumberNode(4);
        node1.next.next.next.next = new NumberNode(5);
        NumberNode node2 = new NumberNode(5);
        node2.next = new NumberNode(6);
        node2.next.next = new NumberNode(7);
        node2.next.next.next = new NumberNode(8);
//        NumberNode res = NumberNodeUtils.reverseNode(node1);
        NumberNode res = NumberNodeUtils.mergeSortedNode1(node1,node2);
//        NumberNode res = NumberNodeUtils.deleteBack(node1,5);
        boolean loopback = NumberNodeUtils.isLoopback(node1);
//        NumberNode res = NumberNodeUtils.getMiddle(node1);
        System.err.println(loopback);
        while (res != null){
            System.err.println(res.val);
            res = res.next;
        }
    }
}
