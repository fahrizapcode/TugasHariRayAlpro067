package a_HitungLuasPersegi;
import java.util.Scanner;
public class LuasPersegi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Panjang persegi: ");
        int panjang = in.nextInt();
        System.out.println("Luas Persegi: " + panjang*panjang);
        in.close();
    }
}