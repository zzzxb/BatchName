package xyz.zzzxb.fun;

import xyz.zzzxb.entity.FileInfo;

import java.io.File;
import java.util.Scanner;

/**
 * @author Zzzxb
 * @date 2020/5/10 19:41
 */
public class SecReplace {
    private static int star = 0;
    private static int end = 0;
    private static String newStr = "";
    private static String status = "";

    public static void secReplace(FileInfo fileInfo) {
        Scanner scanner = new Scanner(System.in);
        File[] files = fileInfo.getFiles();
        for (File file : files) {
            if (!file.getName().startsWith(".")) {
                String ap = file.getAbsoluteFile().getAbsolutePath();
                System.out.println("old: " + ap);
                if (star < 0 || end < 0) {
                    new Exception("star and end not is 0");
                }


                String first = file.getName().substring(0, star);
                String last = file.getName().substring(end);
                String newPath =
                        fileInfo.getDirPath().concat("/").concat(first).concat(newStr).concat(last);


                String flag = "";
                if (!status.equalsIgnoreCase("all")) {
                    System.out.print(file.getName() + " -replace- " + first+newStr+last
                            + " ? n/y/a: ");
                    flag = scanner.next().toLowerCase();
                    if (flag.substring(0, 1).equalsIgnoreCase("a")) {
                        status = "all";
                    } else if (flag.substring(0, 1).equalsIgnoreCase("y")) {
                    }
                }

                if (status.equalsIgnoreCase("all") || flag.equalsIgnoreCase("y")) {
                    file.renameTo(new File(newPath));
                    System.out.println("new: " + newPath);
                }
            }
        }
    }

    public static int getStar() {
        return star;
    }

    public static void setStar(int star) {
        SecReplace.star = star;
    }

    public static int getEnd() {
        return end;
    }

    public static void setEnd(int end) {
        SecReplace.end = end;
    }

    public static String getNewStr() {
        return newStr;
    }

    public static void setNewStr(String newStr) {
        SecReplace.newStr = newStr;
    }

    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        SecReplace.status = status;
    }
}
