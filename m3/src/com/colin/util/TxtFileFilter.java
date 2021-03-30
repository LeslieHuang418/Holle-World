package com.colin.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author FrancisGaozhu
 */
public class TxtFileFilter implements FilenameFilter
{
    @Override
    public boolean accept(File dir, String name)
    {
        File current = new File(dir, name);
        return current.isFile() && current.getName().endsWith(".txt");
    }
}
