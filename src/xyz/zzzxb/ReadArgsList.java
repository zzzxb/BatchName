package xyz.zzzxb;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Zzzxb
 * @date 2020/5/10 16:16
 */
public class ReadArgsList {

    public  void argsList() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/resources/argsList.txt");
        InputStreamReader isr = new InputStreamReader(is);
        char[] chars = new char[1024];
        while (isr.read(chars) != -1) {
            System.out.println(chars);
        }
        isr.close();
    }

    public void version() {
        String msg =
                "* BatchName *\nauth: Zzzxb \nversion: "
                        + Launch.VERSION + "\ntime" + ":2020-5-10";
        System.out.println(msg);
    }
}
