package com.lgcns.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class MyService {
	static MyService instance = null;

	LinkedList<MyQueue> ques = new LinkedList<MyQueue>();
	int msgid = 1;

	public static MyService getInstace() {
		if (instance == null)
			instance = new MyService();
		return instance;
	}

	private MyService() {
//		ques.add(new MyQueue("default",0));
	}

	public Result create(String name, int len) throws IOException, ClassNotFoundException {
		Result ret = new Result();
		ret.setResult("OK");
		for (int i = 0; i < ques.size(); i++) {
			if (ques.get(i).getName().equals(name)) {
				ret.setResult("Queue Exist");
				return ret;
			}
		}
		ques.add(new MyQueue(name, len));

		return ret;
	}

	private MyQueue getQue(String name) {
		for (int i = 0; i < ques.size(); i++) {
			if (ques.get(i).getName().equals(name)) {
				MyQueue q = ques.get(i);
				return q;
			}
		}
		return null;
	}

	public Result enque(String name, String msg) {
		Result ret = new Result();
		ret.setResult("OK");
		MyQueue q = getQue(name);
		if (q == null)
			return ret;

		if (q.size() >= q.getSize()) {
			ret.setResult("Queue Full");
			return ret;
		}
		q.add(new MyItem(msg, msgid++));
		return ret;
	}

	public Result deque(String name) {
		Result ret = new Result();
		ret.setResult("OK");
		MyQueue q = getQue(name);
		if (q == null)
			return ret;
		MyItem item = (MyItem) q.poll();
		ret.setMessage(item.getMessage());
		ret.setMessageID("" + item.getId());
		return ret;
	}

//	public String doCommand(String cmd) {
//		String[] words = cmd.split(" ");
//		if(cmd.startsWith("SEND ")) {
//			//enque(cmd.substring("SEND ".length()));
//			return enque(words[1], words[2]);
//		}
//		else if(cmd.startsWith("RECEIVE ")) {
////			return deque();
//			return deque(words[1]);
//		}
//		else if(cmd.startsWith("CREATE ")) {			
//			return create(words[1], Integer.parseInt(words[2]));
//		}
//		return "unknown command error";
//	}
	public void print(String line) {
		System.out.println(line);
		for (int i = 0; i < ques.size(); i++) {
			MyQueue q = ques.get(i);
			for (int j = 0; j < q.size(); j++) {
				System.out.println(i + "," + j + "," + q.get(i).toString());
			}
		}
		System.out.println(line);
	}

	public void save() throws IOException, ClassNotFoundException {
		System.out.println(ques.size());
		System.out.println(ques.get(0).size());
		try (FileOutputStream fout = new FileOutputStream("tmp.txt");
				ObjectOutputStream out = new ObjectOutputStream(fout)) {

			out.writeObject(ques);
			out.flush();
		}
	}

	public void load() throws IOException, ClassNotFoundException {
		try (FileInputStream fin = new FileInputStream("tmp.txt"); ObjectInputStream in = new ObjectInputStream(fin)) {
			ques = (LinkedList<MyQueue>) in.readObject();
		}

	}
}
