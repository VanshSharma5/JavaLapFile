/*
 * Write a Java program to check if the given number is an Armstrong or not.
 * Definition :An Armstrong number is a positive integer that's equal to the 
 * sum of its digits, each raised to the power of the number of digits.
 * E.g. 153 is an Armstrong number because 1^3 + 5^3 + 3^3 = 153.
 */
import java.util.Scanner;
// Note: we use try catch{exception handeling } latter
public class JavaSimpleProgram {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the Number :");
        int num = scan.nextInt();
        int digits = 0;
        // calculate digits
        int temp = num;
        while(temp != 0){
            digits++;
            temp /= 10;
        }
        // calculate the number
        temp = num;
        int newnum = 0;
        while(temp != 0){
            newnum += (Math.pow(temp%10, digits));
            temp /= 10;
        }

        System.out.println("The Number "+num+" is "+(num == newnum?"":"not ")+"Armstrong");

        scan.close();
    }
}