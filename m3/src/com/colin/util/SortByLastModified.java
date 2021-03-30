package com.colin.util;

import java.io.File;
import java.util.Comparator;

/**
 * @author FrancisGaozhu
 */
public class SortByLastModified implements Comparator
{
    @Override
    public int compare(Object o1, Object o2)
    {
        //判断入参是否是File类型
        if (!(o1 instanceof File && o2 instanceof File))
        {
            throw new IllegalArgumentException("传入对象类型不是File");
        }
        //类型转换
        File f1 = (File)o1, f2 = (File)o2;
        //比较规则
        if(f1.lastModified() > f2.lastModified())
            return 1;
        else if(f1.lastModified() < f2.lastModified())
            return -1;
        else
            return 0;
    }
}
