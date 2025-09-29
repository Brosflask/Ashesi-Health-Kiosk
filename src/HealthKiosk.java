//Class Name: HealthKiosk
//Date Created: 29/09/25
//Author Name: Asizem Curtis
//Purpose: Creates service intake service kiosk
import java.util.*;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int metric = 0;

        System.out.println("Hello and welcome to Ashesi Health Self-Service Intake Kiosk!");
        //Task 1
        System.out.println("Enter a service code (P/L/T/C): ");

        char serviceCode = input.next().charAt(0);
        serviceCode = Character.toUpperCase(serviceCode);

        switch (serviceCode) {
            case 'P' -> System.out.println("Go to Pharmacy Desk.");
            case 'L' -> System.out.println("Go to Lab Desk.");
            case 'T' -> System.out.println("Go to Triage Desk.");
            case 'C' -> System.out.println("Go to Counseling Desk.");
            default -> System.out.println("Invalid Service Code");
        }

        //Task 2

        System.out.println("Enter the health metric: 1 = BMI, 2 = Dosage round-up, 3 = Simple Trig Helper");
        String miniHealthMetric = input.next();

        switch (miniHealthMetric) {
            case "1": {
                System.out.println("Enter weight in kg: ");
                double weight = input.nextDouble();
                System.out.println("Enter height in m: ");
                double height = input.nextDouble();

                double bmi = weight / Math.pow(height, 2);
                metric = (int) Math.round(bmi);
                System.out.println("BMI: " + Math.round(bmi * 10) / 10.0);


                if (bmi < 18.5)
                    System.out.println("Category: Underweight");
                else if (bmi >= 18.5 && bmi <= 24.9)
                    System.out.println("Category: Normal");
                else if (bmi >= 25.0 && bmi <= 29.9)
                    System.out.println("Category: Overweight");
                else
                    System.out.println("Obese");
                break;
            }


            case "2": {
                System.out.println("Enter the required dosage in mg: ");
                double dosage = input.nextDouble();
                double numberOfTablets = Math.ceil(dosage / 250);
                System.out.println("Number of tablets to receive: " + (int) numberOfTablets);
                metric = (int) numberOfTablets;
                break;


            }
            //If user selects option for mini-metric: sine/cos calculator
            case "3": {
                System.out.println("Enter an angle in degrees");
                double angle = Math.toRadians(input.nextDouble());
                double sinAngle = Math.round(Math.sin(angle)*1000)/1000.0;
                double cosAngle = Math.round(Math.cos(angle)*1000)/1000.0;
                metric = (int) Math.round(sinAngle * 100);

                System.out.println("Sine of angle: " + sinAngle);
                System.out.println("Cosine of angle: " + cosAngle);
                break;

            }
        }


        // task 3
       char randomCharacter = (char) (64 + (Math.random() * 26));
        int randoNum1 = (int) (3 + Math.random() * 7);
        int randoNum2 = (int) (3 + Math.random() * 7);
        int randoNum3 = (int) (3 + Math.random() * 7);
        int randoNum4 = (int) (3 + Math.random() * 7);

        String shortID = randomCharacter + String.valueOf(randoNum1) + randoNum2 + randoNum3 + randoNum4;

        if (shortID.length() == 5 && Character.isLetter(shortID.charAt(0)) && Character.isDigit(shortID.charAt(1)) && Character.isDigit(shortID.charAt(2)) && Character.isDigit(shortID.charAt(3)) && Character.isDigit(shortID.charAt(4)))
            System.out.println("ID okay: " + shortID);
        else if (shortID.length() != 5) {
            System.out.println("Invalid Length");
        } else if (!(Character.isLetter(shortID.charAt(0)))) {
            System.out.println("Invalid: first char must be a letter");
        } else if (!(Character.isDigit(shortID.charAt(1)) && Character.isDigit(shortID.charAt(2)) && Character.isDigit(shortID.charAt(3)) && Character.isDigit(shortID.charAt(4)))) {
            System.out.println("Invalid: last four digits must be digits");

        }

        System.out.println("Enter your first name in upper case: ");
        String firstName = input.next().toUpperCase();
        char base = firstName.charAt(0);


        String idLastTwo = shortID.substring(3, 5);

        char shiftedLetter = (char) ('A' + (base - 'A' + 2) % 26);
        String displayCode = shiftedLetter + idLastTwo + "-" + metric;


        System.out.println("Base code: " + base);
        System.out.println("Shifted letter: " + shiftedLetter);
        System.out.println("Last two characters for ID: " + idLastTwo);
        System.out.println("Metric: " + metric);

        System.out.println("Display code: " + shiftedLetter + idLastTwo + "-" + metric);


        switch (serviceCode) {
            case 'P' -> System.out.println("PHARMACY| ID = " + shortID + "| Code =  " + displayCode);
            case 'T' ->
                    System.out.println("TRIAGE| ID = " + shortID + "| Metric: BMI/Dosage/Angle Calculator = " + metric + "| Code =  " + displayCode);
            case 'L' -> System.out.println("LABORATORY| ID = " + shortID + "| Code =  " + displayCode);
            case 'C' -> System.out.println("COUNSELLING| ID = " + shortID + "| Code =  " + displayCode);


        }
    }
}
