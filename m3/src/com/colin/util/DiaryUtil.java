package com.colin.util;

import com.colin.constains.Comparators;
import com.colin.constains.Filters;
import com.colin.constains.Path;

import java.io.File;
import java.util.Arrays;

/**
 * @author FrancisGaozhu
 */
public class DiaryUtil
{

    /**
     * 展示所有当前文件夹中存在的日记
     */
    public File[] showFiles()
    {
        File[] elements = Path.ROOT_DIR.listFiles(Filters.TXT_FILE_FILTER);
        if (elements.length > 0)
        {
            System.out.println("当前已有的日记信息为：");
            Arrays.sort(elements, Comparators.SORT_BY_LAST_MODIFIED);
            for (int i = 0; i < elements.length; i++)
            {
                File current = elements[i];
                StringBuilder sbStr = new StringBuilder();
                sbStr.append(i + 1).append(' ').append(current.getName());
                System.out.println(sbStr);
            }
        }
        else
        {
            System.out.println("当前并不存在任何日记信息");
        }
        return elements;
    }

}
