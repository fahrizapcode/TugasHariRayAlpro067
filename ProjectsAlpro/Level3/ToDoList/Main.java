package c_ToDoList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] task = new String[10000];
        int g = 0;
        System.out.println("ToDoListProgram");
        System.out.println("ketik S untuk berhenti, ketik A untuk tambah");
        for (int f = 0; f <= g; f++){
            System.out.print("Tugas " + (f+1) + ": ");
            String tugasBaru = in.nextLine();
            System.out.print(">>");
            char confirm = in.nextLine().charAt(0);
            task[f] = tugasBaru;
            if (confirm == 'A' || confirm == 'a'){
                g++;
            } else if (confirm == 'S' || confirm == 's') {
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("ToDoList Hari Ini, semangat!");
                for (int h = 0; h <= g; h++){
                    System.out.println((h+1) + "." + task[h]);
                }
                    System.out.println("Ketikkan nomor tugas yang sudah diselesaikan untuk dicoret");
                    System.out.print(">> ");
                    int del = in.nextInt();
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("ToDoList Hari Ini, semangat!");
                    for (int i = 0; i <= g; i++) {
                        if(i+1 != del){
                            System.out.println((i+1) + "." + task[i]);
                        }
                    }
            } else {
                System.out.println("Invalid");
            }
            
        }
 }}

