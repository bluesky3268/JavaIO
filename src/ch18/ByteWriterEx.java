package ch18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteWriterEx {
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
     *    InputStreamReader reader = new InputStreamReader();
     *
     * 보조 스트림의 종류
     *  - InputStreamReader : 바이트 스트림을 문자 스트림을 변환
     *  - BufferedInputStream, BufferedOutputStream, BufferedReader, BufferedWriter : 버퍼를 이용해 입출력 성능 향상
     *  - DataInputStream, DataOutputStream : 기본 타입 데이터 입출력
     *  - PrintStream, PrintWriter : 줄바꿈 처리 및 형식화된 문자열 처리
     *  - ObjectInputStream, ObjectOutputStream : 객체 입출력
     */
    public static void main(String[] args) {
        try {
            // write(int b) : 매개값 int(4바이트)에서 끝 1byte만 출력한다.
            // writer(byte[] b) : 매개변수 배열의 모든 바이트를 출력한다.
            // writer(byte[] b, int off, int len) : 매개변수 배열의 off부터 len개의 바이트를 출력한다.


//            OutputStream fos = new FileOutputStream("/Users/hyunbincho/Desktop/test1.txt");
            OutputStream fos = new FileOutputStream("C:/Users/hbcho/Desktop/test1.txt");

//            String message = "Hello World";
//            fos.write(message.getBytes(Charset.forName("UTF-8")));

            byte a = 1;
            byte b = 2;

            fos.write(a);
            fos.write(b);

            fos.flush();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
