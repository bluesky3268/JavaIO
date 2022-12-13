package ch18;

import java.io.*;

public class DataInputOutputStreamEx {
    public static void main(String[] args) throws IOException {
        // outputStream 생성
        FileOutputStream fos = new FileOutputStream("C:/Users/hbcho/Desktop/test5.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        
        // 기본타입 출력
        dos.writeUTF("hyunbin");
        dos.writeDouble(80.3);
        dos.writeInt(18);

        dos.writeUTF("안녕하세요");
        dos.writeDouble(99.9);
        dos.writeInt(20);

        dos.flush();
        dos.close();
        fos.close();

        // inputStream생성
        FileInputStream fis = new FileInputStream("C:/Users/hbcho/Desktop/test5.txt");
        DataInputStream dis = new DataInputStream(fis);

        // 기본타입 읽기
        for (int i = 0; i < 2; i++) {
            String name = dis.readUTF();
            double score = dis.readDouble();
            int age = dis.readInt();
            System.out.println("name : " + name + ", score : " + score + ", age : " + age);
        }
        dis.close();
        fis.close();
    }
}
