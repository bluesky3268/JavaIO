package ch18.File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {

    public static void main(String[] args) throws IOException {
        // File 객체 생성
        File dir = new File("C:/Users/hbcho/Desktop/testDir");
        File file1 = new File("C:/Users/hbcho/Desktop/testDir/file1.txt");
        File file2 = new File("C:/Users/hbcho/Desktop/testDir/file2.txt");
        File file3 = new File("C:/Users/hbcho/Desktop/testDir/file3.txt");

        // 경로 혹은 파일이 존재하지 않는 경우 생성
        if(!dir.exists())
            dir.mkdirs();

        if(!file1.exists())
            file1.createNewFile();
        if(!file2.exists())
            file2.createNewFile();
        if(!file3.exists())
            file3.createNewFile();

        // 폴더의 내용 출력
        File testDir = new File("C:/Users/hbcho/Desktop/testDir");
        File[] contents = testDir.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (File file : contents) {
            System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
            if (file.isDirectory()) {
                System.out.printf("%-10s%-20s", "<DIR>", file.getName());
            }else{
                System.out.printf("%-10s%-20s", file.length(), file.getName());
            }
            System.out.println();
        }
    }

}
