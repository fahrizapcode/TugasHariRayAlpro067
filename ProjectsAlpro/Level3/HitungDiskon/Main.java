package HitungDiskon;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan harga barang yang akan didiskon: ");
        int harga = in.nextInt();
        System.out.print("berapa diskon(%): ");
        int diskon1 = in.nextInt();
        System.out.print("tambah diskon?(Y/N): ");
        char add1 = in.next().charAt(0);
        if (add1 == 'Y' || add1 == 'y'){
            System.out.print("berapa diskon ke 2(%): ");
            int diskon2 = in.nextInt();
            System.out.print("tambah diskon?(Y/N): ");
            char add2 = in.next().charAt(0);
            float harga1 = harga - (harga * diskon1/100f);
            if (add2 == 'Y' || add2 == 'y'){
                System.out.print("berapa diskon ke 3(%): ");
                int diskon3 = in.nextInt();
                float harga2 = harga1 - (harga1 * diskon2/100f);
                System.out.println("Harga setelah diskon " + diskon1 + "% + " + diskon2 + "% + " + diskon3 + "% adalah: " + (harga2 - (harga2 * (diskon3/100f))));
            } else if (add2 == 'N' || add2 == 'n'){
                System.out.println("Harga setelah diskon " + diskon1 + "% + " + diskon2 + "% adalah: " + (harga1 - (harga1 * (diskon2/100f))));
            } else {
                System.out.println("Invalid");
            }
        } else if (add1 == 'N' || add1 == 'n'){
            
            System.out.print("Harga setelah diskon adalah: " + (harga - (harga * diskon1/100f)));
        } else {
            System.out.println("Invalid");
        }
    }
}
