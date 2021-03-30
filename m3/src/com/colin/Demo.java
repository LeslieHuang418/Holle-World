package com.colin;

public class Demo
{
    public static void main(String[] args)
    {
        A a=new A();
        boolean c=a.b();
        System.out.println(a.b());
    }
}
class A
{
    public void a()
    {
        if (b())
        System.out.println("hhhh");
    }
    public boolean b()
    {
        System.out.println("dddd");
        return true;
    }
}