package examples;  //your package

import java.util.Scanner;
/**
 *
 * @author Alan
 */
public class RSA {
    public static void main(String[] args) {
        boolean exit = false;
        int choice;
        int e=11;
        int n=35;
        int d=11;
        int msg;
        Scanner keyboard = new Scanner(System.in);
        do {
            do {
                System.out.println("Select Action:\n1. Encrypt\n2. Decrypt\n3.Exit");
                if (keyboard.hasNextInt()) {
                    choice = keyboard.nextInt();
                    if (choice <= 3 && choice > 0) {
                        break;
                    } else {
                        keyboard.nextLine();
                        System.out.println("Valid choices 1-3");
                    }
                } else {
                    keyboard.nextLine();
                    System.out.println("Not Valid Input");
                }
            } while (true);

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Type Message (INT)");
                        if (keyboard.hasNextInt()) {
                            msg = keyboard.nextInt();
                            System.out.println(Math.pow(msg, e) %n);
                            break;

                        } else {
                            keyboard.nextLine();
                            System.out.println("Not Valid Input");
                        }
                    } while (true);
                    break;
                case 2:
                    do {
                        System.out.println("Type Message (INT)");
                        if (keyboard.hasNextInt()) {
                            msg = keyboard.nextInt();
                            System.out.println(Math.pow(msg,d) %n);
                            break;

                        } else {
                            keyboard.nextLine();
                            System.out.println("Not Valid Input");
                        }
                    } while (true);
                    break;
                case 3:
                    exit = true;
                    break;
            }
        } while (!exit);

    }
}
