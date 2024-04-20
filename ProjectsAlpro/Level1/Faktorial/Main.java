package Faktorial;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Berapa faktorial: ");
        int fc = in.nextInt();
        int hasil = 1;
        for(int x = 1; x < fc+1; x++){
            hasil*= x;
        }
        System.out.println(hasil);
    }
}
