package ch18;

import java.io.*;

public class CopyEx {
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
//        String originFileName = "/Users/hyunbincho/Desktop/test1.txt";
//        String targetFileName = "/Users/hyunbincho/Desktop/test2.txt";

        String originFileName = "C:/Users/hbcho/Desktop/test1.txt";
        String targetFileName = "C:/Users/hbcho/Desktop/test2.txt";

        try {
            InputStream is = new FileInputStream(originFileName);
            OutputStream os = new FileOutputStream(targetFileName);

            byte[] data = new byte[1024];
            while (true) {
                int num = is.read(data);
                if (num == -1) {
                    break;
                }
                // 데이터 출력하기
                os.write(data, 0, num);

                // 눈으로 확인용
                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }

            // 위의 while문은 아래의 코드 한줄이면 대체 가능
//            is.transferTo(os);

            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
