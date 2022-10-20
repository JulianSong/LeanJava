package lean.io;

import lean2.ClassTest;
import lean2.ClassTest2;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

public class LeanIO {
    public static void inputStreamRead()  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char c = 0;
        try{
            do {
                c = (char) bf.read();
                System.out.println("char:" + c);
            } while (c != 'q');
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void vector() {
        Vector<Integer> int_v = new Vector(5,3);
        int_v.add(1);
        int_v.add(2);
        int_v.add(3);
        int_v.add(4);
        int_v.add(5);
        int_v.add(6);
        System.out.println(int_v.get(2));
        int_v.insertElementAt(30,2);
        System.out.println(int_v.get(2));
        int_v.setSize(10);
        System.out.println(int_v.size());
        System.out.println(int_v.capacity());
    }

    public static void classTest() {
        ClassTest ct = new ClassTest();
        System.out.println(ct.publicInnerData);
        System.out.println(ClassTest2.publicInnerData);
    }

    public static void createFile() {
        File f = new File("/Users/songjunliang/Downloads/LeanJava/");
        if (f.isDirectory()) {
            System.out.println("LeanJava exits");
            return;

        }

        if (f.mkdirs()) {
            System.out.println("LeanJava is created");
        }
    }

    public static void listProjectItems(File f,int level) {
        File file = f;
        if(f == null ) {
            file = new File("/Users/songjunliang/Downloads/JavaLean/");
        }
        if (file.getName().startsWith(".")) {
//            return;
        }
        String blank = "|";
        for (int i = 0; i < level; i++) {
            blank = blank.concat("--");
        }
        System.out.println(blank + file.getName());
        if (file.isDirectory()) {
            File[] items = file.listFiles();
            for (int i = 0;i < items.length ; i ++){
                listProjectItems(items[i],level + 1);
            }
        }
    }

    public static void fileReader()  {
        try {
            File file = new File("/Users/songjunliang/Downloads/JavaLean/src/lean/basic/LeanString.java");
            FileReader fileReader = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fileReader);
            StringBuilder sbf = new StringBuilder();
            while (bfr.ready())  {
                sbf.append((char) bfr.read());
            }
            System.out.print(sbf.toString());
            fileReader.close();
            bfr.close();
        }catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void fileSteam()  {
        try {
            File file = new File("/Users/songjunliang/Downloads/JavaLean/src/lean/basic/LeanString.java");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
            BufferedReader bfr = new BufferedReader(isr);
            String buff = "";
            while ((buff = bfr.readLine()) != null)  {
                System.out.println(buff);
            }
            fis.close();
            bfr.close();
        }catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void fileCopy()  {
        try {
            File file = new File("/Users/songjunliang/Downloads/JavaLean/src/lean/basic/LeanString.java");
            FileReader fileReader = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fileReader);
            StringBuilder sbf = new StringBuilder();
            while (bfr.ready())  {
                sbf.append((char) bfr.read());
            }
            bfr.close();
            fileReader.close();

            File toFile = new File("/Users/songjunliang/Downloads/LeanJava/backup.java");
            FileOutputStream fos = new FileOutputStream(toFile);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.append(sbf);
            osw.close();
            fos.close();
            System.out.println("file is copy to" + toFile.getPath());
        }catch (IOException e) {
            System.out.println(e);
        }
    }
}
