package ch18;

import java.io.*;

public class CharacterConvertStreamEx {

    public static void main(String[] args) {
        write("문자 변환 스트림 사용");
        String data = null;
        try {
            data = read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(data);
    }

    private static void write(String str) {
        try {
            OutputStream os = new FileOutputStream("C:/Users/hbcho/Desktop/test4.txt");
            Writer writer = new OutputStreamWriter(os, "UTF-8");

            writer.write(str);
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String read() throws IOException {
        InputStream is = new FileInputStream("C:/Users/hbcho/Desktop/test4.txt");
        Reader reader = new InputStreamReader(is, "UTF-8");

        char[] data = new char[100];
        int num = reader.read(data);
        reader.close();

        return new String(data, 0, num);
    }



}
