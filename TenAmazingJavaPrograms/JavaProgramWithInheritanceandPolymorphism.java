import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;




class Reservation{
   Random r = new Random();
   Scanner sc = new Scanner(System.in);
   LocalDate date = LocalDate.now();


   int reservation_id;
   String customer_name, reservation_date;


   int getId(){
       reservation_id = r.nextInt(100);
       return reservation_id;
   }


   void setCustomerName(String customer_name){


       this.customer_name = customer_name;
   }


   String getCustomerName(){


       return customer_name;
   }


   void setReservation_date(){


       System.out.println("Reservation Date = "+date);
   }


   void changeReservationDate(){
       System.out.println("Enter a date for reservation in format (YYYY-MM-DD) : ");
       reservation_date = sc.nextLine();
   }


   void display(){
       System.out.println("Name : "+getCustomerName());
       System.out.println("Reservation ID : "+getId());
       setReservation_date();
   }
}


class ResortReservation extends Reservation{
   Random r = new Random();


   int room_no;
   String room_type;
   double room_charge = r.nextDouble(2000);


   int getRoomNo(){
       room_no = r.nextInt(10);
       return room_no;
   }


   void setRoomType(String room_type){
       this.room_type = room_type;
   }


   String getRoomType(){


       return room_type;
   }


   void changeRoom(String room_type){


       this.room_type = room_type;
   }


   @Override
   void display() {
       super.display();
       System.out.println("Your Room No. : "+getRoomNo());
       System.out.println("Room Type : "+getRoomType());
       System.out.println("Room Charge per night (Included Tax) : "+String.format("%.2f",room_charge));
       System.out.println(" ");
   }
}


class RailwayReservation extends Reservation{
   int seat_no,ticket_price;
   String coach_type;


   int getSeatNo(){
       seat_no = r.nextInt(50);
       return seat_no;
   }


   String getCoachType(){
       return coach_type;
   }


   void setCoachType(String coach_type){
       this.coach_type = coach_type;
   }


   void changeSeat(){
       //No need of this method.
   }


   @Override
   void display() {
       super.display();
       System.out.println("Your Seat No. : "+getSeatNo());
       System.out.println("Coach Type : "+getCoachType());
       System.out.println(" ");
   }
}


public class JavaProgramWithInheritanceandPolymorphism {
   public static void main(String[] args) {
       ResortReservation resort = new ResortReservation();
       RailwayReservation railway = new RailwayReservation();
       Scanner sc = new Scanner(System.in);


       int choice;


       do {
           System.out.println("\t\t\tReservation Platform");
           System.out.println("1. Resort Reservation\n2. Railway Reservation\n3. Exit");
           System.out.println("Enter your choice : ");
           choice = sc.nextInt();
           if (choice != 3)
               sc.nextLine();
           System.out.println("************************************");
           System.out.println("Enter your name : ");
           String customer_name = sc.nextLine();
           resort.setCustomerName(customer_name);
           railway.setCustomerName((customer_name));




           switch (choice) {
               case 1 -> {
                   System.out.println("What would you have \n(a) Single Bed (b) Double Bed");
                   String room_type = sc.nextLine();
                   resort.setRoomType(room_type);


                   System.out.println("All information are : ");
                   resort.display();


                   System.out.print("Do you want to change room (y/n) :");
                   String room_change = sc.nextLine();




                   if (Objects.equals(room_change, "y")) {
                       System.out.println("What would you have \n(a) Single Bed (b) Double Bed");
                       room_type = sc.nextLine();
                       resort.setRoomType(room_type);
                   } else {
                       break;
                   }


               }


               case 2 -> {
                   System.out.println("What would you have \n(a) Sleeper Class (b) AC Coach (c) 2S Coach");
                   String coach_type = sc.nextLine();
                   railway.setCoachType(coach_type);


                   System.out.println("All information are : ");
                   railway.display();


                   System.out.print("Do you want to change seat (y/n) : ");
                   String seat_no_change = sc.next();


                   if (seat_no_change == "y") {
                       System.out.println(railway.getSeatNo());
                   } else {
                       break;
                   }


               }


               case 3 -> {
                   System.exit(0);
               }
           }
       }while (choice!=3);
   }
}
