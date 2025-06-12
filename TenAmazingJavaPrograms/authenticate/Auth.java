package authenticate;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

class User{
   String user_name,password;
   boolean is_login;


   User(){}


   User(User user){
       this.user_name = user.user_name;
       this.password = user.password;
       this.is_login = user.is_login;
   }
}


public class Auth {


   HashMap<String, User> hash = new HashMap<>();
   User user = new User();
   Scanner sc = new Scanner(System.in);




   public boolean isLogin(String user_name){
       if (Objects.equals(user_name, user.user_name))
           user.is_login = true;
       return user.is_login;
   }


   public void logout(String user_name){
       if (hash.containsKey(user_name))
           hash.get(user_name).is_login = false;
   }


   public void login(String user_name, String password){


       if (hash.containsKey(user_name)) {
           if (hash.get(user_name).password.equals(password)) {
               hash.get(user_name).is_login = true;
               System.out.println("Login Successfully");
           }
           else
               System.out.println("Password is incorrect");
       }
       else
           System.out.println("Incorrect Username");
   }


   public String isUser(String user_name){
       return ((user_name.equals(user.user_name)?"Yes, You are registered":"No, You are not registered"));
   }


   public void register(){
       System.out.println(" ---------------------Registration------------------");
       System.out.print("\tEnter your Name : ");
       user.user_name = sc.nextLine();
       System.out.print("\tEnter your Password : ");
       user.password = sc.nextLine();
       hash.put(user.user_name,new User(user));
       System.out.println("You are successfully registered\n");
       System.out.println("Now you can login 😊");
   }


   public void changePassword(String old_pass , String new_pass){
       if (old_pass.equals(user.password))
           user.password = new_pass;
       else
           System.out.println("Old Password is incorrect");
   }
}
