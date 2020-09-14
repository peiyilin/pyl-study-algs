package stack;

/**
 * @author: peiyilin
 * @description:
 * @date: 2020/9/14 18:00
 */
public class ArrayStack<T> {

    /**
     * 元素
     */
    private Object[] items;

    /**
     * 栈中的元素个数
     */
    private int count;

    /**
     * 栈的容量
     */
    private int capacity;

    public ArrayStack(int capacity) {
        this.items = new Object[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * 入栈
     * @param t
     * @return
     */
    public boolean push(T t){
        if (count == capacity){
            throw new RuntimeException("栈已满");
        }
        items[count] = t;
        count++;
        return true;
    }

    public T pop(){
        if (count == 0){
            return null;
        }
        //返回最后一个元素
        Object item = items[count - 1];
        count--;
        return (T) item;
    }
}
