package demo.restful.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;

public class ReadFileUTF8 {
    /*
     * 读取文件
     */
    public static String read(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) {
            return "File not found!";
        }
        FileInputStream fs;
        String result = "";


        try {
            fs = new FileInputStream(f);
            BufferedReader br = new BufferedReader(
                    new UnicodeReader(
                            new FileInputStream(f),
                            Charset.defaultCharset().name()));
            String line;
            while ((line = br.readLine()) != null) {

                result+=line+"\n";
            }
            br.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }



}
