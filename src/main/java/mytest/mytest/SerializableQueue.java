package mytest;

import java.io.Serializable;
import java.util.LinkedList;

class MyQueue extends LinkedList<MyItem> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2792486566921636867L;
	private String name;	
	private int size;
	public MyQueue(String name, int size) {
		this.setName(name);
		this.setSize(size);
	}
//	Queue<MyItem> que = new LinkedList<MyItem>();
	
	
	@Override
	public MyItem poll() {
		// TODO Auto-generated method stub
		return super.poll();
	}
	
	public boolean add(MyItem e) {
		// TODO Auto-generated method stub
		return super.add(e);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	
}	
