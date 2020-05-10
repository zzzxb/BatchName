package xyz.zzzxb.fun;

import xyz.zzzxb.entity.FileInfo;

import java.io.File;

/**
 * @author Zzzxb
 * @date 2020/5/10 19:25
 */
public class KeyReplace {
    private static String oldKey = "";
    private static String newKey = "";

    public static void keyReplace(FileInfo fileInfo) {
        File[] files = fileInfo.getFiles();
        for (File file : files) {
            if (!file.getName().startsWith(".")) {
                String ap = file.getAbsoluteFile().getAbsolutePath();
                System.out.println("old: " + ap);
                String newName = file.getName().replace(oldKey, newKey);
                if (!newName.trim().equals("")) {
                    file.renameTo(new File(fileInfo.getDirPath()+"/".concat(newName)));
                    System.out.println("new: " + fileInfo.getDirPath() + "/" + newName);
                }
            }
        }
    }

    public static String getOldKey() {
        return oldKey;
    }

    public static void setOldKey(String oldKey) {
        KeyReplace.oldKey = oldKey;
    }

    public static String getNewKey() {
        return newKey;
    }

    public static void setNewKey(String newKey) {
        KeyReplace.newKey = newKey;
    }
}
