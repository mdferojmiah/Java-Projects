package emailapp;
import java.util.*;

public class Email {
    public Scanner s = new Scanner(System.in);

    //Setting variables
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;
    //Constructor to receive first name and last name
    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);
        //calling methods
        this.dept = this.setDept();
        this.password = this.generate_password(8);
        this.email = this.generate_email();


    }
    //Generate mail method
    private String generate_email(){
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
    }
    //Asking department
    private String setDept(){
        System.out.println("Department codes: \n(101) for Sales Department \n(102) for Development Department \n(103) for Accounting Department \n(0) for NONE");
        boolean flag = false;
        do {
            System.out.print("Enter department code: ");
            int choice = s.nextInt();
            switch (choice) {
                case 101 -> {
                    return "Sales";
                }
                case 102 -> {
                    return "Development";
                }
                case 103 -> {
                    return "Accounting";
                }
                case 0 -> {
                    return "None";
                }
                default -> System.out.println("INVALID code! Please follow the instruction!");
            }
        }while(!flag);
        return null;
    }
    //Generate Random password method
    private String generate_password(int length){
        Random r = new Random();
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars+Small_chars+numbers+symbols;
        String password = "";
        for(int i = 0; i < length; i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
    //Change Password method
    public void set_password(){
        boolean flag = false;
        do {
            System.out.print("Do you want to change your password!(Y/N): ");
            char choice = s.next().charAt(0);
            if(choice == 'Y' || choice == 'y'){
                //current password input
                System.out.print("Enter your current password: ");
                String temp = s.next();
                //password checking
                if(temp.equals(this.password)){
                    flag = true;
                    System.out.print("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed Correctly!");
                } else {
                    System.out.println("Incorrect password!");
                }
            } else if(choice == 'N' || choice == 'n'){
                flag = true;
                System.out.println("Password change option cancelled!");
            } else {
                System.out.println("INVALID input! try again!");
            }
        }while(!flag);
    }
    //Set mailbox capacity
    public void set_mailCap(){
        System.out.println("Current capacity = " + this.mailCapacity + " mb.");
        System.out.print("Enter new mailbox capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox capacity changed Successfully!");
    }
    //Set alternative email
    public void alternative_email(){
        System.out.print("Enter new alternative mail: ");
        this.alter_email = s.next();
        System.out.println("Alternative email is set!");
    }
    // Display user information method
    public void getInfo(){
        System.out.println("--------User Information--------");
        System.out.println("Name: " + this.fname + " " + this.lname);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox Capacity: " + this.mailCapacity + " mb.");
        System.out.println("Alternate mail: " + this.alter_email);
    }



}
