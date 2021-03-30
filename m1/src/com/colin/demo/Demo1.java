package com.colin.demo;

import com.colin.model.Person;

import java.io.*;

/**
 * 序列化的展示
 * @author FrancisGaozhu
 */
public class Demo1
{
    public static void main(String[] args)
    {
        Person per1 = new Person("小高", "18846457728");

        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("m1/a.bin"))))
        {
            oos.writeObject(per1);
            oos.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
