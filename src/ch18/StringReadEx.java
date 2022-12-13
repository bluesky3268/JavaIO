package ch18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StringReadEx {
    /**
     * 입출력 스트림의 최상위 클래스는
     * - 바이트 : InputStream, OutputStream
     * - 문자 : Reader, Writer
     * 
     * 보조 스트림 
     * - 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
     * - 보조 스트림 자체적으로 입출력을 수행할 수 없다
     * -> 입출력 소스로부터 직접 생성된 입출력 스트림에 연결해서 사용해야 한다.
     * ex) InputStream is = new FileInputStream();
     *    InputStreamReader reader = new InputStreamReader(is);
     *    
     * 보조 스트림의 종류
     *  - InputStreamReader : 바이트 스트림을 문자 스트림을 변환
     *  - BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter : 버퍼를 이용해 입출력 성능 향상
     *  - DataInputStream, DataOutputStream : 기본 타입 데이터 입출력
     *  - PrintStream, PrintWriter : 줄바꿈 처리 및 형식화된 문자열 처리
     *  - ObjectInputStream, ObjectOutputStream : 객체 입출력
     */
    public static void main(String[] args) {

        Reader reader = null;
        try {
            // 한 문자씩 읽기
//            reader = new FileReader("/Users/hyunbincho/Desktop/test3.txt");
            reader = new FileReader("C:/Users/hbcho/Desktop/test3.txt");

            while (true) {
                int data = reader.read();
                if (data == -1) {
                    break;
                }
                System.out.print((char) data);
            }

            reader.close();
            System.out.println();

            //문자 배열로 읽기
//            reader = new FileReader("/Users/hyunbincho/Desktop/test3.txt");
            reader = new FileReader("C:/Users/hbcho/Desktop/test3.txt");
            char[] data = new char[1024];
            while (true) {
                int num = reader.read(data);
                if(num == -1)
                    break;
                for (int i = 0; i < num; i++) {
                    System.out.print(data[i]);
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
