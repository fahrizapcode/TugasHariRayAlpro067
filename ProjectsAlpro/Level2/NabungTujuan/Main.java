package NabungTujuan;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Apa tujuanmu menabung: ");
        String obj = in.nextLine();
        System.out.print("Berapa harganya: ");
        int harga = in.nextInt();
        System.out.print("Berapa lama kamu ingin mencapainya(hari): ");
        int hari = in.nextInt();
        System.out.println("Untuk " + obj + ", selama " + hari + " hari, kamu perlu menabung sebanyak " + (harga/hari) + " setiap harinya, Semangat ;)");

    }
}
