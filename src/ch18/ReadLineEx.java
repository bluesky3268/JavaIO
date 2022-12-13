package ch18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineEx {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:/Users//hbcho/Desktop/hyunbin/javaIO/src/ch18/CopyEx.java"));

        int lineNo = 1;

        while (true) {
            String str = br.readLine();
            if(str == null)
                break;
            System.out.println(lineNo + "\t" + str);
            lineNo++;
        }

        br.close();
    }

}
