package ch18;

import java.io.*;

public class BufferEx {

    public static void main(String[] args) throws IOException {
        String originalFilePath1 = BufferEx.class.getResource("leaves-g09fea5b4e_1920.jpg").getPath();
        String targetFilePath1 = "C:/Users/hbcho/Desktop/leaves-g09fea5b4e_1920_copy.jpg";

        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

        // 입출력 스트림 + 버퍼 스트림 생성
        String originalFilePath2 = BufferEx.class.getResource("leaves-g09fea5b4e_1920.jpg").getPath();
        String targetFilePath2 = "C:/Users/hbcho/Desktop/leaves-g09fea5b4e_1920_copy2.jpg";

        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);

        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        // 버퍼를 사용하지 않을 때
        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼 미사용 : " + nonBufferTime + "ns");

        // 버퍼를 사용할 때
        long bufferTime = copy(fis, fos);
        System.out.println("버퍼 사용 : " + bufferTime + "ns");

        fis.close();
        fos.close();

        bis.close();
        bos.close();

    }

    public static long copy(InputStream is, OutputStream os) throws IOException {
        long start = System.nanoTime();

        while (true) {
            int data = is.read();
            if (data == -1)
                break;
            os.write(data);
        }
        os.flush();

        long end = System.nanoTime();

        return (end - start);
    }

}
