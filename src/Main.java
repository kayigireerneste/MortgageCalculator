import java.text.NumberFormat;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        final byte MONTHS_OF_THE_YEAR = 12;
        final byte PERCENTAGE = 100;
        int principalLoanAmount;
        float annualInterestRate;
        byte period;
        float monthlyInterestRate;
        int numberOfPayments;
        



        Scanner scanner = new Scanner(System.in);

        //calculating principle
        while (true) {
            System.out.print("Principal Loan Amount(P): ");

            // Check if input is a valid integer
            if (scanner.hasNextInt()) {
                principalLoanAmount = scanner.nextInt();
                if (principalLoanAmount >= 1000 && principalLoanAmount <= 1_000_000)
                    break;
                else
                    System.out.println("Please enter valid principle. value between $1000 and $1,000,000");
            } else {
                System.out.println("Invalid input. Please enter the amount between $1000 and $1,000,000");
                scanner.next(); //scan next input after invalid input
            }
        }

        // calculating annual interest rate
        while (true) {
            System.out.print("Enter Annual Interest Rate: ");

            // Check if input is a valid floating number
            if (scanner.hasNextFloat()) {
                annualInterestRate = scanner.nextFloat();
                if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                    monthlyInterestRate = annualInterestRate / PERCENTAGE / MONTHS_OF_THE_YEAR;
                    break;
                }
                else
                    System.out.println("Please enter the valid annual interest rate. value between 1 and 30");
            }
            else {
                System.out.println("Invalid input. the valid annual interest rate value between 1 and 30");
                scanner.next();
            }
        }

        //calculating period of payment
        while (true) {
            System.out.print("Enter Period(Years): ");

            //check valid input
            if (scanner.hasNextByte()) {
                period = scanner.nextByte();
                if (period >= 1 && period <= 30) {
                    numberOfPayments = period * MONTHS_OF_THE_YEAR;
                    break;
                }
                else
                    System.out.println("Please enter the valid payment period. value between 1 and 30");
            }
            else {
                System.out.println("Invalid input. the valid payment period value between 1 and 30");
                scanner.next();
            }
        }

        double mortgagePayment = principalLoanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String formatMortgage = NumberFormat.getCurrencyInstance().format(mortgagePayment).trim();
        System.out.println("Your monthly mortgage payment is equal to " + formatMortgage);
    }
}