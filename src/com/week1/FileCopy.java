package com.week1;

import java.io.*;

/**
 * @ClassName FileCopy
 * @Description 用缓冲流实现文件拷贝
 * @Author yue_fan
 * @Date 2020/1/14
 **/
public class FileCopy {
    public static void main(String[] args) {
        String choose = "txt";
        File originalFile = new File("D:/tt/我的.txt");
        String startFileName = originalFile.getName();
        String start = originalFile.getPath();
        int position = startFileName.indexOf(".");
        System.out.println(start);
        //取得文件扩展名
        String suffixName = startFileName.substring(position+1);
        try {
            if (suffixName.equals(choose)){
                BufferedReader br = new BufferedReader(new FileReader(start));
                BufferedWriter bw = new BufferedWriter(new FileWriter("D:/TextCopy"+"."+suffixName));
                String line;
                while ((line = br.readLine())!=null){
                    bw.write(line);
                }
                bw.close();
                br.close();
            } else{
                BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(start));
                BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream("D:/pic"+"."+suffixName));
                int len;
                while ((len = fileInputStream.read())!=-1){
                    fileOutputStream.write(len);
                }
                fileOutputStream.close();
                fileInputStream.close();
            }
            System.out.println("拷贝成功");
        } catch (IOException e){
//            System.out.println("拷贝失败");
            e.printStackTrace();
        }
    }
}
