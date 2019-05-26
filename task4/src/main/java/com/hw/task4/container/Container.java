package com.hw.task4.container;

import com.hw.task4.Entity.Product;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Container {
    private int count = 0;
    private int threshold = 50;
    private long timeLimit = 5;
    private Queue<Product> queue = new LinkedList<Product>();
    private Stack<Product> stack = new Stack<Product>();
    private Boolean overflow = false;

    public Container() {
    }

    public Container(int t) {
        if (t <= 0)
            System.out.println("threshold cannot <= 0");
        else
            threshold = t;
    }

    public synchronized Product pop() {
        if (count == 0) return null;

        while (overflow) {
            Product tmp = null;
            tmp = stack.peek();
            if (timeLimit < (System.currentTimeMillis() - tmp.getSetTime()) / 1000) {
                stack.pop();
                count--;
                if (count <= threshold) overflow = false;
            } else {
                count--;
                if (count <= threshold) overflow = false;
                System.out.println("**[CONTAINER]\tpop from stack**");
                return stack.pop();
            }
        }

        while (count > 0) {
            Product tmp = null;
            tmp = queue.element();
            if (timeLimit < (System.currentTimeMillis() - tmp.getSetTime()) / 1000) {
                queue.remove();
                count--;
            } else {
                count--;
                System.out.println("**[CONTAINER]\tpop from queue**");
                return queue.remove();
            }
        }

        return null;
    }

    public synchronized void push(Product product) {
        count++;
        if (count > 50) overflow = true;
        if (!overflow) {
            product.setSetTime(System.currentTimeMillis());
            queue.add(product);
            System.out.println("**[CONTAINER]\tpush into queue**");
        } else {
            product.setSetTime(System.currentTimeMillis());
            stack.push(product);
            System.out.println("**[CONTAINER]\tpush into stack**");
        }
    }
}
