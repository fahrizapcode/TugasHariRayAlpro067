package b_hitungVolumePrismaSegitiga;
import java.util.Scanner;
public class LuasPrisma {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Lebar alas: ");
        int lebarAlas = in.nextInt();
        System.out.print("Tinggi alas: ");
        int tinggiAlas = in.nextInt();
        System.out.print("tinggi prisma: ");
        int tinggiPrisma = in.nextInt();
        System.out.println("Volume prisma segitiga: " + 0.5f * lebarAlas * tinggiAlas * tinggiPrisma);
        in.close();
    }
}
