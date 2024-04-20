package HitungUmur;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calendar kalender = Calendar.getInstance();
        System.out.print("Masukkan Bulan lahir: ");
        int bulanLahir = in.nextInt();
        System.out.print("Masukkan Tahun lahir: ");
        int tahunLahir = in.nextInt();
        int bulanSekarang = kalender.get(Calendar.MONTH) + 1; // +1 karena dalam modul bulan dimulai dari 0, jadi bulan maret = 2, maka perlu ditambah 1
        int tahunSekarang = kalender.get(Calendar.YEAR);
        int umurTahun = tahunSekarang - tahunLahir;
        int umurBulan;
        if (bulanLahir > bulanSekarang){
            umurTahun-=1;
            umurBulan = bulanLahir + bulanSekarang;
        } else {
            umurBulan = bulanSekarang - bulanLahir;
        }
        System.out.println("Umur kamu adalah " + umurTahun + " tahun " + umurBulan + " bulan");
   
    }
}
