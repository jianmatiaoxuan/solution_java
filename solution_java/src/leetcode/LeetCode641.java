package leetcode;

/**
 * @author: sunmengjin
 * @create: LeetCode641.class 2022-08-15-17 17:18
 **/
public class LeetCode641 {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        circularDeque.insertFront(1);
        circularDeque.insertFront(2);
        circularDeque.insertLast(3);
        circularDeque.deleteFront();
        circularDeque.deleteLast();
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.insertFront(9));
//        System.out.println(circularDeque.deleteFront());
//        System.out.println(circularDeque.getRear());
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.deleteFront());
//        System.out.println(circularDeque.insertFront(6));
//        System.out.println(circularDeque.insertLast(5));
//        System.out.println(circularDeque.insertFront(4));
//        System.out.println(circularDeque.getFront());
//        System.out.println(circularDeque.insertFront(6));
    }
}

class MyCircularDeque {
    private int[] elements;
    private int rear, front;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k + 1;
        rear = front = 0;
        elements = new int[k + 1];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}