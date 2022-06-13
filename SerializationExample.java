package com.lgcns.test;

import java.io.*;
import java.util.LinkedList;

public class SerializationExample {

	
	
    public static void main(String[] args) throws Exception {
		MyTest t = new MyTest();
		t.h = "test String2";
		try(FileOutputStream fout = new FileOutputStream("tmp2.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout)){
			
			out.writeObject(t);			
		}
		
		try(FileInputStream fin = new FileInputStream("tmp2.txt");
		ObjectInputStream in = new ObjectInputStream(fin)){
			MyTest tt = (MyTest) in.readObject();
			System.out.println(tt.h);
		}
		
        Student student = new Student("JS", 123);

        // serialization
        File file = new File("./student.file");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(student);
            oos.flush();
        }

        // deserialization
        Student result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Student) ois.readObject();
        }

        System.out.println(result.name+","+result.id);
    }

	
    public static class Student implements Serializable {
        private String name;
        private int id;

        Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

//        @Override
//        public String toString() {
//            return "name : " + name + ", id : " + id;
//        }
    }
}
