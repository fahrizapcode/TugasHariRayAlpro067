import java.util.Scanner;
import java.util.Random;
public class LoginWithDoWhile {
    public static void main(String[] args) {
        String username = "Fahriza";
        String password = "12345678";
        Scanner in = new Scanner(System.in);
        int attempts = 2;
        String message = "";
        Random random = new Random();
        StringBuilder randomLetters = new StringBuilder();
        int numberOfLetters = 5;
        for (int i = 0; i < numberOfLetters; i++) {
            int randomNumber = random.nextInt(26); 
            char randomLetter = (char) ('a' + randomNumber);
            randomLetters.append(randomLetter);
        }
        String charCpC = randomLetters.toString();
        
        do {
            System.out.print("Username: ");
            String usernameIn = in.nextLine();
            System.out.print("Password: ");
            String passwordIn = in.nextLine();
            if (usernameIn.equals(username) && passwordIn.equals(password)) {
                for (int v = 0; v < 1000; v++){
                System.out.print("Tuliskan ulang '" + charCpC + "'  :");
                String captcha = in.nextLine();
                    if (captcha.equals(charCpC)) {
                        message = "Anda berhasil login";
                        System.out.println(message);
                        break;
                    }
                    
                }
                attempts = 0;
            } else if (usernameIn.equals(username)){
                message = "Password Anda salah";
                System.out.println(message);
                System.out.println("Kesempatan: " + attempts);
            } else if (passwordIn.equals(password)){
                message = "Username Anda salah";
                System.out.println(message);
                System.out.println("Kesempatan: " + attempts);
            } else {
                message = "Username dan password Anda salah";
                System.out.println(message);
                System.out.println("Kesempatan: " + attempts);
            }
            attempts--;
        } while (attempts >= 0);
        in.close();
    }
}
