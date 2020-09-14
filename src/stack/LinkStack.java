package stack;

import linkedlist.Node;

/**
 * @author: peiyilin
 * @description:
 * @date: 2020/9/14 18:23
 */
public class LinkStack<T> {

    private Node<T> top = new Node<>();

    private int size;

    /**
     * 入栈
     * @param t
     * @return
     */
    public boolean push(T t){
        Node<T> node = new Node<>(t);
        node.next = top;
        top = node;
        size++;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public T pop(){
        Node<T> oldNode = top;
        top = top.next;
        size--;
        return oldNode.val;
    }
}
