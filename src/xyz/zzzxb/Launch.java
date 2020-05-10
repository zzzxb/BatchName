package xyz.zzzxb;


import xyz.zzzxb.entity.FileInfo;
import xyz.zzzxb.fun.KeyReplace;
import xyz.zzzxb.fun.SecReplace;
import xyz.zzzxb.fun.SeqReplace;
import xyz.zzzxb.fun.SuffixReplace;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Zzzxb
 * @date 2020/5/10 14:52
 */
public class Launch {
    public static final String VERSION = "1.0.0";
    private static final String REMIND =
            "BatchName : Use the -h parameter to view the help documentation.";
    private static FileInfo fileInfo = new FileInfo();

    public static void main(String[] args) throws Exception {
        // 如果没有通过命令行传递参数或通过properties文件传递参数就报异常
        if (args.length == 0) {
            try {
                Properties properties = new Properties();
                properties.load(new InputStreamReader(
                        new FileInputStream(new File("batchName.properties"))));
                // 文件中没可用参数
                if (properties.isEmpty()) {
                    System.out.println(REMIND);
                    throw new Exception("No available parameters were found from the file");
                }
                // TODO 读取 properties 文件参数
                System.out.println("没有实现");
            } catch (IOException e) {
                System.out.println(REMIND);
                throw new Exception("Not Found Args Or Properties File");
            }
        } else {
            // 解析命令行参数
            if (args[0].equals("-h")) {
                new ReadArgsList().argsList();
                return;
            } else if (args[0].equals("-v")) {
                new ReadArgsList().version();
                return;
            }

            if (args[0].equals("-f")) {
                if (fileInfo.getDirPath().equals("") && !Objects.equals(args[0 + 1], "")) {
                    fileInfo.setDirPath(args[0 + 1]);
                }
                if (args.length >= 3 && !fileInfo.getDirPath().equals("") && Objects.equals(args[2],
                        "-l")) {
                    for (File file : fileInfo.getFiles()) {
                        System.out.println(file.getAbsoluteFile());
                    }
                    return;
                }
                if (args.length >= 3 && !fileInfo.getDirPath().equals("")) {
                    switch(args[2].substring(0,3).toLowerCase()) {
                        case "suf":
                            if (args[3].equalsIgnoreCase("-o")){
                                SuffixReplace.setOldSuffix(args[4]);
                            }
                            if (args[5].equalsIgnoreCase("-n")){
                                SuffixReplace.setNewSuffix(args[6]);
                            }
                            // 根据后缀替换
                            SuffixReplace.sufReplace(fileInfo.getFiles());
                            break;
                        case "seq":
                            if (args[3].equalsIgnoreCase("-n")) {
                                SeqReplace.setNewName(args[4]);
                            }
                            // 序列命名
                            SeqReplace.seqReplace(fileInfo);
                            break;
                        case "key":
                            if (args[3].equalsIgnoreCase("-o")){
                                KeyReplace.setOldKey(args[4]);
                            }
                            if (args[5].equalsIgnoreCase("-n")) {
                                KeyReplace.setNewKey(args[6]);
                            }
                            // key 替换
                            KeyReplace.keyReplace(fileInfo);
                            break;
                        case "sec":
                            if (args[3].equalsIgnoreCase("-s")){
                                SecReplace.setStar(Integer.valueOf(args[4]));
                            }
                            if (args[5].equalsIgnoreCase("-e")) {
                                SecReplace.setEnd(Integer.valueOf(args[6]));
                            }
                            if (args[7].equalsIgnoreCase("-n")) {
                                SecReplace.setNewStr(args[8]);
                            }
                            // 区间替换
                            SecReplace.secReplace(fileInfo);
                            break;
                    }
                }
            } else {
                throw new Exception("The -f parameter must be in the first position");
            }

        }
    }
}
