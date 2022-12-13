package ch18;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class StringWriteEx {
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
        try {
            //
//            Writer writer = new FileWriter("/Users/hyunbincho/Desktop/test3.txt");
            Writer writer = new FileWriter("C:/Users/hbcho/Desktop/test3.txt");

            // 문자 하나씩 출력
            char a = 'A';
            writer.write(a);

            char b = 'B';
            writer.write(b);

            // 배열 출력
            char[] chArr = {'C', 'D', 'E'};
            writer.write(chArr);

            String str = "FG";
            writer.write(str);

            // 버퍼에 남은 문자를 모두 출력하고 버퍼 비우기
            writer.flush();

            // 출력 스트림 닫고 버퍼 비우기
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
