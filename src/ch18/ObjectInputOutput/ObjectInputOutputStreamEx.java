package ch18.ObjectInputOutput;

import java.io.*;
import java.util.Arrays;

public class ObjectInputOutputStreamEx {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // ObjectOutputStream에 연결
        FileOutputStream fos = new FileOutputStream("C:/Users/hbcho/Desktop/test7.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 객체 생성
        Member member1 = new Member("fall", "단풍");
        Product product1 = new Product("맥북", 1_500_000);

        int[] intArr = {1, 2, 3};

        // 객체 직렬화하여 파일에 저장
        oos.writeObject(member1);
        oos.writeObject(product1);
        oos.writeObject(intArr);

        oos.flush();
        oos.close();
        fos.close();

        // ObjectInputStream에 연결
        FileInputStream fis = new FileInputStream("C:/Users/hbcho/Desktop/test5.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Member findMember = (Member) ois.readObject();
        Product findProduct = (Product) ois.readObject();
        int[] findIntArr = (int[]) ois.readObject();

        ois.close();
        fis.close();

        System.out.println(findMember.toString());
        System.out.println(findProduct.toString());
        System.out.println(Arrays.toString(findIntArr));
    }

}
