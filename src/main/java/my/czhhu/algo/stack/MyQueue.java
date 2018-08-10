package my.czhhu.algo.stack;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

/*
 * my queue is backedWithTwoStacks
 * */
public class MyQueue<T> implements Queue<T> {

	private int capacity = 100;

	private int size;

	private Stack<T> stackNew = new Stack<T>();

	private Stack<T> stackOld = new Stack<T>();

	public static void main(String[] args) {
		MyQueue<String> q = new MyQueue<String>();
		System.out.println(q.size());
		q.offer("1");
		q.offer("2");

		System.out.println("peek: " + q.peek());
		System.out.println(q.size());
		System.out.println("poll: " + q.poll());
		System.out.println(q.size());
		System.out.println("poll: " + q.poll());
		System.out.println(q.size());
		System.out.println("poll: " + q.poll());
		System.out.println(q.size());

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stackNew.size() + stackOld.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stackNew.isEmpty() && stackOld.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(T e) {
		if (size() == capacity)
			return false;
		stackNew.push(e);
		size++;
		return true;
	}

	@Override
	public boolean offer(T e) {
		// TODO Auto-generated method stub
		return add(e);
	}

	@Override
	public T remove() {
		if (size == 0) {
			return null;
		}
		if (stackOld.isEmpty()) {
			shiftStack();
		}
		size--;
		return stackOld.pop();
	}

	private void shiftStack() {
		while (!stackNew.isEmpty()) {
			stackOld.push(stackNew.pop());
		}

	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return remove();
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return peek();
	}

	@Override
	public T peek() {
		if (stackOld.isEmpty()) {
			shiftStack();
		}
		return stackOld.peek();
	}

}
