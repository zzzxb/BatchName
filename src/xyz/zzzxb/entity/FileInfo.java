package xyz.zzzxb.entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Zzzxb
 * @date 2020/5/10 16:30
 */
public class FileInfo {
    private String dirPath = "";
    private File[] files;

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) throws IOException {
        if ((new File(dirPath)).exists()) {
            this.dirPath = dirPath;
        }else {
            throw new IOException("not found dir ["+ dirPath +"]");
        }
    }

    public File[] getFiles() {
        files = new File(dirPath).listFiles();
        return files;
    }

}
