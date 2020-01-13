package com.week1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName RandomNumberOutput
 * @Description 随机生成100个0-99之间的随机整数存入数组，选取字符输出流写入本地文件
 * @Author yue_fan
 * @Date 2020/1/13
 **/
public class RandomNumberOutput {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=100;i++){
            int num = new Random().nextInt(100);
            list.add(num);
        }
        try {
            File file = new File("D:\\number.txt");
            FileOutputStream os = new FileOutputStream(file);
            for (Integer integer:list){
                os.write(integer);
            }
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
