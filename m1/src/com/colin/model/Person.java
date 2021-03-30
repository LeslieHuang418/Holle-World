package com.colin.model;

import java.io.Serializable;

/**
 * @author FrancisGaozhu
 */
public class Person implements Serializable
{


    private static final long serialVersionUID = -5694026223107775770L;

    public Person(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }

    private String name;
    private transient String phone;

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
