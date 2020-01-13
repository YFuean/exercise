package com.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RandomNumberOutput
 * @Description 随机生成100个0-99之间的随机整数存入数组，选取字节输出流写入本地文件
 * @Author yue_fan
 * @Date 2020/1/13
 **/
public class RandomNumberOutput {
    public static void main(String[] args) throws IOException {
        //List<Integer> list = new ArrayList<>();
        StringBuffer values = new StringBuffer();
        for (int i = 1; i <= 100; i++) {
            int number = (int) (Math.random() * 100);
            //list.add(number);
            values.append(" "+number);
        }
        File file = new File("D:/number.txt");
        if (!file.exists()) {
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(String.valueOf(values));
                fw.close();
                System.out.println("写入成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("文件已存在！");
        }
    }
}
