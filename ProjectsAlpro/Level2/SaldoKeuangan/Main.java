package SaldoKeuangan;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int saldo = 0;
        int b = 999999;
        int[] report= new int[99];
        String[] indi = new String[99];
        int r = 0;

        System.out.println("Menu, ketik A untuk pemasukan, ketik B untuk pengeluaran, ketik C untuk check saldo");
        for (int a = 0; a < b; a++){
            System.out.print(">> ");
            char menu = in.next().charAt(0);
            if (menu == 'A' || menu == 'a'){
                System.out.print("Pemasukan: ");
                report[a] = in.nextInt();
                saldo += report [a];
                r++;
                indi[a] = "+";
            } else if (menu == 'B'|| menu == 'b'){
                System.out.print("Pengeluaran: ");
                report[a] = in.nextInt();
                saldo -= report [a];
                r++;
                indi[a] = "-";
            } else if (menu == 'C' || menu == 'c'){
                System.out.println("Saldo: " + saldo);
                System.out.println("Laporan Pemasukan dan pengeluaran");
                for (int x = 0; x < r ; x++){
                    System.out.println(indi[x] +" Rp" + report[x]);
                }
                System.out.println("");
                break;
            } else {
                break;
            }
        }
    }
}
