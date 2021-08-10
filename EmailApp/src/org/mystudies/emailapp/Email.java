package org.mystudies.emailapp;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternativeEmail;
    private String email;

    public Email() {

        init();
    }

    public void init(){
        setName();
        setDepartment();
        setAlternativeEmail();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Email created with success: ");
        System.out.println(getEmail());
        generatePassword();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Please chance your password.");
        changePassword();
    }

    public void generatePassword(){
        int leftLimit = 48;
        int rightLimit = 122;
        int stringLength = 10;
        Random random = new Random();

        this.password = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println("Your password is: " + this.password);
    }
    public void changePassword(){

        System.out.println("Please enter your corporate email: ");
        Scanner scannerEmail = new Scanner(System.in);
        String enteredEmail = scannerEmail.next();

        System.out.println("Enter current password:");
        Scanner scannerPassword = new Scanner(System.in);
        String currentPassword = scannerPassword.next();

        if(!this.email.equals(enteredEmail) || !this.password.equals(currentPassword)) {
            if(!this.email.equals(enteredEmail)){
                System.out.println("Wrong email. Please try again.");
            }

            if(!this.password.equals(currentPassword)){
                System.out.println("Wrong password. Please try again.");
            }

            changePassword();
        }

        if(this.email.equals(enteredEmail) && this.password.equals(currentPassword)){

            System.out.println("Enter new your password:");
            Scanner scannerNewPassword = new Scanner(System.in);
            String newPassword = scannerNewPassword.next();

            System.out.println("Please confirm your password.");
            Scanner scannerNewPasswordConfirmation = new Scanner(System.in);
            String newPasswordConfirmation  = scannerNewPasswordConfirmation.next();

            if(newPassword.equals(newPasswordConfirmation)){
                this.password = newPassword;
                System.out.println("Password changed with success.");
            }

            if(!newPassword.equals(newPasswordConfirmation)){
                System.out.println("Different passwords. Please try again.");
                changePassword();
            }

        }
    }

    public String getEmail(){
        this.email = this.firstName.toLowerCase()  + "." + this.lastName.toLowerCase() + "@" + this.department
                + "." + "company.com";
        return email;
    }


    public String getName() {
        return firstName + " " + lastName;
    }

    public void setName(){
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" CREATE YOUR CORPORATE EMAIL");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Please enter your first name.");
        Scanner scannerFirstName = new Scanner(System.in);
        this.firstName = scannerFirstName.next();

        System.out.println("Please enter your last name.");
        Scanner scannerLastName = new Scanner(System.in);
        this.lastName = scannerLastName.next();
    }

    public void setDepartment(){
        System.out.println("Please enter your department:");
        System.out.println("[1] - Sales");
        System.out.println("[2] - Development");
        System.out.println("[3] - Accounting");
        Scanner scannerDepartment = new Scanner(System.in);
        String choice = scannerDepartment.next();
        String regex = "[0-9]";

        if(choice.matches(regex)) {

            int chosenNumber = Integer.parseInt(choice);

            switch (chosenNumber) {
                case 1:
                    this.department = "sales";
                    break;
                case 2:
                    this.department = "development";
                    break;
                case 3:
                    this.department = "accounting";
                    break;
                default:
                    System.out.println("Invalid number. Please choose a valid option.");
                    setDepartment();
                    break;
            }
        } else {
            System.out.println("Please choose a valid option.");
            setDepartment();
        }
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public void setAlternativeEmail() {
        System.out.println("Please enter an alternative email.");
        Scanner scannerAlternativeEmail = new Scanner(System.in);
        this.alternativeEmail  = scannerAlternativeEmail.next();

        System.out.println("Please confirm your alternative email.");
        Scanner scannerAlternativeEmailConfirmation = new Scanner(System.in);
        String alternativeEmailConfirmation  = scannerAlternativeEmailConfirmation.next();

        if(!alternativeEmail.equals(alternativeEmailConfirmation)){
            System.out.println("Different emails. Please try again.");
            setAlternativeEmail();
        }

        emailValidation();
    }

    public void emailValidation(){
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(alternativeEmail);

        if(!matcher.matches()){
            System.out.println("Invalid email.");
            setAlternativeEmail();
        }
    }

}
