package BintangSegitigaSikuSiku;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Berapa tingginya: ");
        int tinggi = in.nextInt();
        System.out.println("*");
        for (int x = 1; x < tinggi; x++){
            for (int y = 0; y < x*3; y++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
