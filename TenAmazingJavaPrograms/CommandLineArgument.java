/*
 * Write a java program to take the number from the user from the command line and 
 * check whether the number is palindrome or not.
 * E.g. if the number is 12321 then its reverse i.e. 12321 equals to the actual number.
 */
public class CommandLineArgument {
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);

        int numcpy = num, newnum = 0;

        while(numcpy != 0){
            newnum *= 10;
            newnum += numcpy%10;
            numcpy /= 10;
        }
        System.out.println("The Number "+num+" is "+(num == newnum?"":"not ")+"Palindrome");
    }
}