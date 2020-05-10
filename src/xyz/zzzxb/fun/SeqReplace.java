package xyz.zzzxb.fun;

import xyz.zzzxb.entity.FileInfo;

import java.io.File;

/**
 * @author Zzzxb
 * @date 2020/5/10 19:04
 */
public class SeqReplace {
    private static String newName = "sheet";

    public static void seqReplace(FileInfo fileInfo) {
        File[] files = fileInfo.getFiles();
        int count = 0;

        for (File file : files) {
            if (file.isFile() && !file.getName().startsWith(".")) {
                String ap = file.getAbsoluteFile().getAbsolutePath();
                System.out.println("old: " + ap);
                String suf = "";
                if (ap.lastIndexOf(".") != -1) {
                    suf = ap.substring(ap.lastIndexOf("."));
                }
                String name =
                        fileInfo.getDirPath()+ "/".concat(newName).concat(String.valueOf(count)).concat(suf);
                file.renameTo(new File(name));
                System.out.println("new: " + name);
            }
            count++;
        }
    }

    public static String getNewName() {
        return newName;
    }

    public static void setNewName(String newName) {
        SeqReplace.newName = newName;
    }
}
