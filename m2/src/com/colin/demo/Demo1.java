package com.colin.demo;

import com.colin.model.Person;

import java.io.*;

/**
 * @author FrancisGaozhu
 */
public class Demo1
{
    public static void main(String[] args)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("m1/a.bin"))))
        {
            Object o = ois.readObject();
            if(o instanceof Person)
            {
                Person per = (Person)o;
                System.out.println(per);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
