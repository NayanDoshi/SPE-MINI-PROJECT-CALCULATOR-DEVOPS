package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);
    public Calculator() {
    }

    public static void main(String args[]) {



        Calculator calculator = new Calculator();
        Scanner obj = new Scanner(System.in);
        double input1, input2;
        System.out.println("Welcome to calculator devops! ");
        for(;;) {
            System.out.println("Choose your choice to perform calculation");
            System.out.println("Enter 1 to find factorial\nEnter 2 to find Square root\nEnter 3 to find power\nEnter 4 to find natural logarithm\n" +
                    "Enter 5 to exit\nEnter your choice: ");
            int choice;
            try {
                choice = obj.nextInt();
            } catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // Factorial Operation
                    System.out.print("Enter a number : ");
                    int num;
                    num = obj.nextInt();
                    System.out.println("Factorial of "+num+" is : " + calculator.calculate_factoral(num));
                    System.out.println("\n");

                    break;
                case 2:
                    //Square_root operation
                    System.out.print("Enter a number : ");
                    input1 = obj.nextDouble();
                    System.out.println("Square root of "+input1+" is : " + calculator.calculate_squareRoot(input1));
                    System.out.println("\n");


                    break;
                case 3:
                    // power operation
                    System.out.print("Enter the first number : ");
                    input1 = obj.nextDouble();
                    System.out.print("Enter the power : ");
                    input2 = obj.nextDouble();
                    System.out.println(input1+ " raised to power "+input2+" is : " + calculator.calculate_power(input1, input2));
                    System.out.println("\n");
                    break;
                case 4:
                    // Natural_Log operation
                    System.out.print("Enter a number : ");
                    input1 = obj.nextDouble();
                    System.out.println("Natural log of "+input1+" is : " + calculator.calculate_naturalLog(input1));
                    System.out.println("\n");

                    break;
                default:
                    System.out.println("Are you sure that want to exit? \n If Yes,Enter 1 \n If No,Enter 2");
                    int response=obj.nextInt();
                    if(response==1)
                    return;
                    else break;

            }
        }
    }


    public double calculate_factoral(double input1) {
        logger.info("[FACTORIAL] - " + input1);
        double result = calculate_factOfNum(input1);
        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }



    public double calculate_squareRoot(double input1) {
        logger.info("[SQ ROOT] - " + input1);
        double result = Math.sqrt(input1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }


    public double calculate_power(double input1, double input2) {
        logger.info("[POWER - " + input1 + " RAISED TO] " + input2);
        double result = Math.pow(input1,input2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double calculate_naturalLog(double input1) {
        logger.info("[NATURAL LOG] - " + input1);
        double result = 0;
        try {

            if (input1 <0 ) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else {
                result = Math.log(input1);
            }
        } catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
    public double calculate_factOfNum(double num) {
        double facto = 1;
        for(int i = 1; i <= num; ++i)
        { facto *= i;   }
        return  facto;
    }
}