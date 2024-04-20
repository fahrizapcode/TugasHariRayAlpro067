package BilanganGanjil;
import java.util.Scanner;;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Berapa banyak angka ganjil? ");
        int jumlah = in.nextInt();
        for (int x = 0; x < jumlah*2; x++){
            if (x % 2 == 1){
                System.out.print(x + "  ");
            }
        }
    }
}
