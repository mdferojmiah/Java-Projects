package emailapp;
import java.util.*;
public class EmailApp {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String f_name = s.next();
        System.out.print("Enter your last name: ");
        String l_name = s.next();
        // calling email class
        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        do{
            System.out.println("--------Email Application by FEROJ--------");
            System.out.println("Welcome to dashboard, " + f_name + " " + l_name);
            System.out.println("Choose an option:\n(1) Show Information\n(2) Change Password\n(3) Change Mailbox Capacity\n(4) Set Alternative Email\n(5) EXIT");
            System.out.print("Choose an option: ");
            choice = s.nextInt();
            switch(choice){
                case 1 ->{
                    em1.getInfo();
                    break;
                }
                case 2 ->{
                    em1.set_password();
                    break;
                }
                case 3 ->{
                    em1.set_mailCap();
                    break;
                }
                case 4 ->{
                    em1.alternative_email();
                    break;
                }
                case 5 ->{
                    System.out.println("Thanks for using our service!");
                    break;
                }
                default -> System.out.println("INVALID option! Choose accordingly!");
            }
        }while(choice != 5);
    }
}
