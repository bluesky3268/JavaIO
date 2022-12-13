package ch18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx {
    
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("C:/Users/hbcho/Desktop/test6.txt");
        PrintStream ps = new PrintStream(fos);
        
        ps.print("프린터가 ");
        ps.println("출력하는 것처럼");
        ps.print("데이터를");
        ps.println("출력합니다.");
        
        ps.printf("| %6d | %-10s | %10s | \n", 1, "김개똥", "무직");
        
    }
    
}
