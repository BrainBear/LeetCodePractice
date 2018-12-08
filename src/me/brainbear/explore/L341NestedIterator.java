package me.brainbear.explore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class L341NestedIterator implements Iterator<Integer> {

    private Stack<Iterator<NestedInteger>> stack = new Stack<>();

    public L341NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return mNext;
    }

    private Integer mNext;

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().hasNext()) {
                NestedInteger next = stack.peek().next();
                if (next.isInteger()) {
                    mNext = next.getInteger();
                    return true;
                } else {
                    if (!next.getList().isEmpty()) {
                        stack.push(next.getList().iterator());
                    }
                    continue;
                }
            }
            stack.pop();
        }
        return false;
    }


    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();

        list.add(new ANestedInteger(1));
        list.add(new ANestedInteger(2));
        list.add(new ANestedInteger(3));

        List<NestedInteger> list1 = new ArrayList<>();

        list1.add(new ANestedInteger(11));
        list1.add(new ANestedInteger(12));
        list1.add(new ANestedInteger(13));

        List<NestedInteger> list2 = new ArrayList<>();

        list2.add(new ANestedInteger(21));
        list2.add(new ANestedInteger(22));
        list2.add(new ANestedInteger(23));

        List<NestedInteger> list3 = new ArrayList<>();

        list3.add(new ANestedInteger(31));
        list3.add(new ANestedInteger(32));
        list3.add(new ANestedInteger(33));

        list1.add(new ANestedInteger(list3));
        list.add(new ANestedInteger(list1));
        list.add(new ANestedInteger(list2));

        L341NestedIterator i = new L341NestedIterator(list);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    public static class ANestedInteger implements NestedInteger {

        private final Integer i;
        private final List<NestedInteger> nestedIntegers;
        private final boolean isInteger;

        public ANestedInteger(Integer i) {
            this.i = i;
            nestedIntegers = null;
            isInteger = true;
        }

        public ANestedInteger(List<NestedInteger> nestedIntegers) {
            this.nestedIntegers = nestedIntegers;
            this.i = null;
            isInteger = false;
        }

        @Override
        public boolean isInteger() {
            return isInteger;
        }

        @Override
        public Integer getInteger() {
            return i;
        }

        @Override
        public List<NestedInteger> getList() {
            return nestedIntegers;
        }

        @Override
        public String toString() {
            return "ANestedInteger{" +
                    "i=" + i +
                    ", nestedIntegers=" + nestedIntegers +
                    '}';
        }
    }
}