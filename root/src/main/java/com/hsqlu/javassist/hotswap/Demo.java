package com.hsqlu.javassist.hotswap;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.LoaderClassPath;
import javassist.util.HotSwapper;

import java.io.File;
import java.io.FileInputStream;

public class Demo {
    public static void main(String[] args) throws Exception {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.print();
//        ClassPool pool = new ClassPool();;
//        pool.appendSystemPath();
//        ClassClassPath classPath = new ClassClassPath(Demo.class);
//        pool.appendClassPath(new LoaderClassPath(Demo.class.getClassLoader()));
//        pool.insertClassPath(classPath);
//        pool.getClassLoader();

//        CtClass clazz = pool.get("com.hsqlu.javassist.hotswap.HelloWorld");
//        hs.reload("HelloWorld", clazz.toBytecode());
        File newfile = new File("C:\\workspace\\java-workspace\\root\\target\\HelloWorld.class");
        byte[] bytes = new byte[(int)newfile.length()];
        new FileInputStream(newfile).read(bytes);
        System.out.println("** reload a logging version");
        HotSwapper hs = new HotSwapper(8000);

        hs.reload("com.hsqlu.javassist.hotswap.HelloWorld", bytes);
        new HelloWorld().print();
//
        newfile = new File("C:\\workspace\\java-workspace\\root\\target\\classes\\com\\hsqlu\\javassist\\hotswap\\HelloWorld.class");
        bytes = new byte[(int)newfile.length()];
        new FileInputStream(newfile).read(bytes);
        System.out.println("** reload the original version");

        hs.reload("com.hsqlu.javassist.hotswap.HelloWorld", bytes);
        new HelloWorld().print();
    }
}