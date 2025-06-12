import authenticate.Auth;
import java.util.Arrays;
import java.util.Scanner;


public class Package {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       Auth a1 = new Auth();


       int[] checkSlot = new int[100];
       Arrays.fill(checkSlot,0);
       do{
           System.out.print("Enter the slot { Between 1 to 100 } : ");
           int i = sc.nextInt();
           checkSlot[i] = 1;
           if (checkSlot[i] == 1){
               System.out.println("""
                       _____________________________________________
                       |              Shopping Center              |
                       |___________________________________________|
                       | 1. Registration                           |
                       |-------------------------------------------|
                       | 2. Login                                  |
                       |-------------------------------------------|
                       | 3. Change Password                        |
                       |-------------------------------------------|
                       | 4. Check User                             |
                       |-------------------------------------------|
                       | 5. Check Login                            |
                       |-------------------------------------------|
                       | 6. Logout                                 |
                       |-------------------------------------------|
                       |7. Exit                                    |
                       |___________________________________________|
                       """);
               System.out.print("Enter your choice : ");
               int choice = sc.nextInt();
               sc.nextLine();
               switch (choice){
                   case 1 ->{
                       a1.register();
                   }


                   case 2 ->{
                       System.out.print("Enter your name : ");
                       String name = sc.nextLine();
                       System.out.print("Enter your password : ");
                       String password = sc.nextLine();
                       a1.login(name , password);
                   }


                   case 3 ->{
                       String old_pass , new_pass;
                       System.out.print("Enter your old password : ");
                       old_pass = sc.nextLine();
                       System.out.print("Enter your new password : ");
                       new_pass = sc.nextLine();
                       a1.changePassword(old_pass , new_pass);
                   }


                   case 4 ->{
                       System.out.print("Enter your Username : ");
                       String username = sc.nextLine();
                       System.out.println(a1.isUser(username));
                   }


                   case 5 ->{
                       System.out.println("Enter your Username : ");
                       String username = sc.nextLine();
                       boolean is_login = a1.isLogin(username);
                       if (is_login)
                           System.out.println("You are already login");
                       else
                           System.out.println("You are not login");
                   }


                   case 6 ->{


                   }


                   case 7 ->{
                       System.exit(0);
                   }
               }
           }
           else
               System.out.println("This slot is already filled.");
       }while(true);
   }
}
