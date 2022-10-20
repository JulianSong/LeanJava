package lean.basic;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import lean.io.LeanIO;
import lean2.ClassTest;
import lean2.ClassTest2;

import javax.imageio.IIOException;

abstract class A {
    abstract void showName();
    void showName(String name) {

    };

    void showName(Float name) {

    }

    void showName(String name,int type) {

    }
}

interface C {
    void c();
}

class B extends A implements C {
    @Override
    void showName() {

    }

    @Override
    public void c() {

    }
}

/*java 学习*/
public class LeanString {

    public static void stringArray() {
        ArrayList<String> ls = new ArrayList<String >();
        ls.add("1");
        ls.add("3");
//        String[] sts = new String[]{"1","2","3"};
//        String sts2[] = new String[];
        System.out.println(ls.size());
    }

    public static void subString() {
        System.out.println("1234".substring(1,3));
    }
}