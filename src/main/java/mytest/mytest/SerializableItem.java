package mytest;

import java.io.Serializable;

class MyItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6448515048655498125L;
	private String message;
	private int id;

	public MyItem(String message, int i) {
		this.setMessage(message);
		this.setId(i);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%s,%s,%d", message, " ", id);
	}
}
