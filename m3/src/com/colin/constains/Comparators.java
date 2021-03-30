package com.colin.constains;

import com.colin.util.SortByLastModified;

import java.util.Comparator;

/**
 * @author FrancisGaozhu
 */
public class Comparators
{
    /**
     * 根据最终修改时间的排序外部比较器
     */
    public static final Comparator SORT_BY_LAST_MODIFIED = new SortByLastModified();
}
