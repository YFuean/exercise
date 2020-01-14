package com.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @ClassName RandomNumberOutput
 * @Description 随机生成100个0-99之间的随机整数存入数组，选取字节输出流写入本地文件
 * @Author yue_fan
 * @Date 2020/1/13
 **/
public class RandomNumberOutput {
    public static void main(String[] args) throws IOException{
        int[] num = new int[100];
        Random random = new Random();
        for (int i = 0;i<100;i++){
            num[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(num));
        File file = new File("D:/number.txt");
        Writer writer = new FileWriter(file,true);
        PrintWriter out = new PrintWriter(writer);
        out.print(Arrays.toString(num));
        out.flush();
        out.close();
        writer.close();
    }
}
