package test;

import com.sun.tools.javac.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test1 {

    public  void writeToFile(List<Student>list){
        try {
            FileWriter fw =new FileWriter("data.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            for (Student o:list) {
                bw.write(o.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Student> read() {
        List<Student> list = new ArrayList<>();
        try {
            FileReader rd = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(rd);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt=line.split("\\s+");
                String name =txt[0];
                int age=Integer.parseInt(txt[1]);
                int mark=Integer.parseInt(txt[2]);
                list.add(new Student(name,age,mark));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public static void main(String[] args) {
       Main m=new Main();
        List<Student> list = m.read;


        }


}
