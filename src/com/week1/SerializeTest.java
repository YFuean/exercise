package com.week1;

import com.week1.util.Student;

import java.io.*;

/**
 * @ClassName SerializeTest
 * @Description student的序列化和反序列化
 * @Author yue_fan
 * @Date 2020/1/19
 **/
public class SerializeTest {
    public static void main(String[] args) throws IOException {
        serialize();
        Student s = (Student) deserialize();
        System.out.println("姓名：" + s.getName() + "\n年龄：" + s.getAge() + "\n性别：" + s.getSex() + "\n地址：" + s.getAddress() + "\n手机：" + s.getPhone());
    }

    public static Object deserialize() throws IOException {
        Student s = new Student();
        File f = new File("D:/dev/JavaReview/student.out");
        InputStream is = new FileInputStream(f);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s = (Student) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        is.close();
        ois.close();
        return s;
    }

    public static void serialize() {
        Student s = new Student();
        s.setName("岳凡");
        s.setAge(20);
        s.setSex("girl");
        s.setAddress("南京");
        s.setPhone("16651100323");
        OutputStream os = null;
        ObjectOutputStream oos = null;
        File f = new File("D:/dev/JavaReview/student.out");
        try {
            os = new FileOutputStream(f);
            oos = new ObjectOutputStream(os);
            oos.writeObject(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
