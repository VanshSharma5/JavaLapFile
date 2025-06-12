import java.util.Scanner;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class Registration{
   Random r = new Random();


   int user_id;
   long mobile_no;
   String user_name,password,email_id;


   Registration(){
       this.user_id = r.nextInt(10000);
   }


   void setUserName(String user_name){
       this.user_name = user_name;
   }


   String getUserName(){
       return user_name;
   }


   void setPassword(String password){
       this.password = password;
   }


   String getPassword(){
       return password;
   }


   void setMobileNo(long mobile_no){
       this.mobile_no = mobile_no;
   }


   long getMobileNo(){
       return mobile_no;
   }


   void setEmailID(String email_id){
       this.email_id = email_id;
   }


   String getEmailID(){
       return email_id;
   }


   boolean checkUserName(){
       return Pattern.matches("^[a-zA-z][a-zA-z0-9_]{2,10}$",user_name);
   }


   boolean checkPassword(){
       return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9]).{8,20}$",password);
   }


   boolean checkEmail(){
       return Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",email_id);
   }


   boolean checkMobileNo(){
       String mobNo = Long.toString(mobile_no);
       return Pattern.matches("^[0-9][0-9]{9}$",mobNo);
   }
}


class InvalidUserNameException extends Exception{
   InvalidUserNameException(){
      
       super("You entered username in wrong format");
   }
}


class InvalidContactNumberException extends Exception{
   InvalidContactNumberException(){
       super("You entered more than 10 digits or enter alphabets");
   }
}


class InvalidEmailException extends Exception{
   InvalidEmailException(){
       super("Wrong Email Format");
   }
}


class InvalidPasswordException extends Exception{
   InvalidPasswordException(){
       super("Wrong Password Format");
   }
}


public class JavaProgramToImplementExceptionHandling {
   public static void main(String[] args) {
       Registration regis = new Registration();
       Scanner sc = new Scanner(System.in);




       try{
           System.out.print("Enter your Name : ");
           String user_name = sc.nextLine();
           regis.setUserName(user_name);


           boolean username = regis.checkUserName();
           if(!username) {
               throw new InvalidUserNameException();
           }
       }
       catch(InvalidUserNameException e){
           System.out.println("Please contain lowercase, uppercase and underscore(_)");
       }


       try{
           System.out.print("Enter your Mobile number : ");
           long mobile_no = sc.nextLong();
           regis.setMobileNo(mobile_no);


           boolean mobile = regis.checkMobileNo();
           if (!mobile) {
               throw new InvalidContactNumberException();
           }
       }


       catch(InvalidContactNumberException e){
           System.out.println("Please enter only 10 digit number");
       }


       sc.nextLine();
       try{
           System.out.print("Enter your Email ID : ");
           String email_id = sc.nextLine();
           regis.setEmailID(email_id);


           boolean email = regis.checkEmail();
           if (!email) {
               throw new InvalidEmailException();
           }
       }


       catch(InvalidEmailException e){
           System.out.println("Enter an email with right format");
       }


       try {
           System.out.print("Enter your Password : ");
           String password = sc.nextLine();
           regis.setPassword(password);


           boolean pass = regis.checkPassword();
           if (!pass)
               throw new InvalidPasswordException();
       }


       catch(InvalidPasswordException e){
           System.out.println("Enter password that contains at least 8 letters and an Uppercase and Special Symbol");
       }
   }
}