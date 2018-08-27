package com.study.util;

import java.io.*;

/**
 * @author zhangcm
 * @since 1.0, 2018/6/20 上午10:39
 */
public class IOUtils {

    public static String readStreamAsString(InputStream in, String charset)
            throws IOException {

        if (in == null) {
            return "";
        }

        Reader reader = null;
        Writer writer = new StringWriter();
        String result;

        char[] buffer = new char[1024];
        try {
            int n = -1;
            reader = new BufferedReader(new InputStreamReader(in, charset));
            while((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

            result = writer.toString();
        } finally {
            in.close();
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        return result;
    }
}
