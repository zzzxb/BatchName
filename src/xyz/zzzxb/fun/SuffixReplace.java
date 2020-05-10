package xyz.zzzxb.fun;

import java.io.File;

/**
 * @author Zzzxb
 * @date 2020/5/10 18:24
 */
public class SuffixReplace {
    private static String oldSuffix = "";
    private static String newSuffix = "";

    public static void sufReplace(File[] files) throws Exception {
        if (newSuffix.equals("")) {
            throw new Exception("newSuffix is null");
        }

        for (File file : files) {
            if (file.isFile()) {
                String ap = file.getAbsoluteFile().getAbsolutePath();
                if (!file.getName().startsWith(".")) {
                    if ((ap.lastIndexOf(".")) != -1) {
                        // 没有 oldSuffix 的话，就进行全部替换
                        System.out.println("old: " + ap);
                        if (oldSuffix.equals("")) {
                            ap = ap.substring(0, ap.lastIndexOf("."));
                            ap = ap.concat(".").concat(newSuffix.replace(".", ""));
                        }else {
                            if (ap.substring(ap.lastIndexOf("."))
                                    .equalsIgnoreCase(".".concat(oldSuffix.replace(".","")))) {
                                ap =
                                        ap.substring(0, ap.lastIndexOf("."))
                                                .concat(".")+newSuffix.replace(".", "");
                            }
                        }
                        file.renameTo(new File(ap));
                        System.out.println("new: " + ap);
                    }
                }
            }
        }
    }

    public static String getOldSuffix() {
        return oldSuffix;
    }

    public static void setOldSuffix(String oldSuffix) {
        SuffixReplace.oldSuffix = oldSuffix;
    }

    public static String getNewSuffix() {
        return newSuffix;
    }

    public static void setNewSuffix(String newSuffix) {
        SuffixReplace.newSuffix = newSuffix;
    }
}
