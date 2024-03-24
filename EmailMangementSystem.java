import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;


public class EmailMangementSystem {
    static String firstName;
    static String lastName;
    static String department;
    static String company;

    static class newTeamEmails {
        String firstName;
        String lastName;
        String department;
        String company;
        String Password;
        String email;
        int mailboxCapacity;
        newTeamEmails(String firstName, String lastName, String department, String company) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = department;
            this.company = company;
            this.mailboxCapacity=2000;
        }

        public void returnInfo() {
            System.out.println("Your firstName is " + this.firstName);
            System.out.println("Your lastName is " + this.lastName);
            System.out.println("Your department is " + this.department);
            System.out.println("Your Company is " + this.company);
            System.out.println("Your Mailbox Capacity is " + this.mailboxCapacity);

        }

        public String generateRandomPassword() {
            int len = 8;
            String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                    + "lmnopqrstuvwxyz!@#$%&";
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
            this.Password = sb.toString();
            System.out.println("Your password is: " + this.Password );
            return sb.toString();
        }

        public void generateEmail() {
            String email = this.firstName + "." + this.lastName + "@" + this.company + "." +
                    this.department + ".com";
            this.email=email;
            System.out.println("Your email is: " + this.email);
        }
        public void getEmail(){
            System.out.println("Your email is"+this.email);
        }
        public String setNewPassword(int len) {
            System.out.println("Please your new password length");
            Scanner scanner = new Scanner(System.in);
            len = scanner.nextInt();
            String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                    + "lmnopqrstuvwxyz!@#$%&";
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
            this.Password = sb.toString();
            System.out.println("Your New password is: " + this.Password );
            return sb.toString();
        }
        public int setMailboxCapacity(){
            System.out.println("Please enter a new Mailbox Capacity");
            Scanner scanner = new Scanner(System.in);
            int newMailbox = scanner.nextInt();
            if (newMailbox>5000){
                System.out.println("You cannot set more than 5000");
            } else if(newMailbox<2000){
                System.out.println("2000 is the minimum Capacity");
            } else{
                System.out.println("Your new capacity is :"+newMailbox);
                this.mailboxCapacity=newMailbox;
            }

            return newMailbox;
        }

        public String setNewEmail(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter your first Name");
            this.firstName=scanner.nextLine();
            System.out.println("Please enter your last Name");
            this.lastName=scanner.nextLine();
            System.out.println("Please enter your Company");
            this.company=scanner.nextLine();
            System.out.println("Please enter your Department");
            this.department=scanner.nextLine();
            String email = this.firstName + "." + this.lastName + "@" + this.company + "." +
                    this.department + ".com";
            this.email=email;
            System.out.println("Your email is: " + this.email);
            return email;
        }

    }
    public static void main(String[] args) {

        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Do you want to add a new user\n1.)" +
                        "Yes\n2.)1No");
                int userAnswer=scanner.nextInt();
                if(userAnswer==1){

                    getFirstName();
                    getLastName();
                    getDepartment();
                    getCompany();

                    newTeamEmails newUser = new newTeamEmails(firstName, lastName, department, company);
                    newUser.generateEmail();
                    newUser.generateRandomPassword();
                    System.out.println("Would you like to perform any Operations\n1.)Yes\n2.)No");
                    userAnswer=scanner.nextInt();
                    if(userAnswer==1){
                        while(true){
                            System.out.println("Which Operation would " +
                                    "you like to perform\n1.)Return User Info\n2" +
                                    ".)Return Last Name\n3.)Set New Email\n" +
                                    "4.)Set New Mailbox Capacity\n5.)Get Your email");
                            userAnswer=scanner.nextInt();
                            switch(userAnswer){
                                case 1:
                                    newUser.returnInfo();
                                    break;
                                case 2:
                                    newUser.returnInfo();
                                    break;
                                case 3:
                                    newUser.setNewEmail()
                                    ;

                                    break;
                                case 4:
                                    newUser.setMailboxCapacity();
                                    break;
                                case 5:
                                    newUser.getEmail();
                                    break;
                                default:
                                    break;

                            }
                        }


                    }

                } else if(userAnswer==2){
                    System.out.println("Thanks for using this Program");
                    break;
                }


            }catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option (1 or 2).");
            }

        }


    }

    public static String getFirstName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your first name");
            firstName = scanner.nextLine();
            if (!firstName.isEmpty()) {
                System.out.println("Welcome " + firstName);
                break;
            } else {
                System.out.println("Please enter a valid name");
            }
        }
        return firstName;
    }

    public static String getLastName() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your last name");
            lastName = scanner.nextLine();
            if (!lastName.isEmpty()) {
                break;
            } else {
                System.out.println("Please enter a valid last name");
            }
        }
        return lastName;
    }

    public static String getDepartment() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your Department Name\n" +
                    "1.) Sales\n2.) Development\n3.) Accounting");
            int departmentChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (departmentChoice) {
                case 1:
                    department = "Sales";
                    break;
                case 2:
                    department = "Development";
                    break;
                case 3:
                    department = "Accounting";
                    break;
                default:
                    System.out.println("Please enter a valid Department Name");
                    continue;
            }
            break;
        }
        return department;
    }

    public static String getCompany() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your Company Name");
            company = scanner.nextLine();
            if (!company.isEmpty()) {
                break;
            } else {
                System.out.println("Please enter a valid Company Name");
            }
        }
        return company;
    }
}
