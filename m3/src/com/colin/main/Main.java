package com.colin.main;

import com.colin.constains.Path;
import com.colin.util.DiaryUtil;

import java.io.*;
import java.util.Scanner;

/**
 * @author FrancisGaozhu
 */
public class Main
{
    public static void main(String[] args)
    {
        DiaryUtil util = new DiaryUtil();
        try(Scanner input = new Scanner(System.in))
        {
            System.out.println("                欢迎使用马大师日记本");
            loop:while (true)
            {
                System.out.println("-----------------------------------------------------");
                System.out.println("1.记录一个新的日记 2.查看日记信息 3.删除 其他：退出");
                System.out.println("-----------------------------------------------------");
                System.out.print("请输入-->");
                int inputNum = input.nextInt();
                switch(inputNum)
                {
                    case 1:
                    {
                        //执行新建日记
                        System.out.print("请输入日记标题：");
                        input.nextLine();
                        String title = input.nextLine();
                        File f = new File(Path.ROOT_DIR, title + ".txt");
                        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f)))
                        {
                            System.out.println("请在后面输入日记的内容，每输入一行敲回车。如果希望结束编写，那么输入end;");
                            while(true)
                            {
                                String str = input.nextLine();
                                if("end;".equals(str))
                                {
                                    break;
                                }
                                bw.write(str);
                                bw.newLine();
                                bw.flush();
                            }
                            System.out.println("保存成功！");
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 2:
                    {
                        //执行查看日记
                        File[] list = util.showFiles();
                        if (list.length > 0)
                        {
                            System.out.print("请输入您要查看的日记编号：");
                            File targetFile = list[input.nextInt() - 1];
                            try(BufferedReader br = new BufferedReader(new FileReader(targetFile)))
                            {
                                char[] chars = new char[20];
                                int count;
                                StringBuilder sbShow = new StringBuilder();
                                while((count = br.read(chars)) != -1)
                                {
                                    sbShow.append(chars, 0, count);
                                }
                                System.out.println(sbShow);
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
                        break;
                    }

                    case 3:
                    {
                        //执行删除日记
                        File[] list = util.showFiles();
                        if (list.length > 0)
                        {
                            System.out.print("请输入您需要删除的日记编号：");
                            if(list[input.nextInt() - 1].delete())
                                System.out.println("删除成功！");
                            else
                                System.out.println("删除失败!");
                        }
                        break;
                    }

                    default:
                    {
                        //执行程序退出
                        break loop;
                    }
                }
            }
            System.out.println("感谢使用，么么哒！");
        }
    }
}
