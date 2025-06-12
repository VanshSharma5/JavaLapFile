import java.util.Base64;
import java.util.Scanner;

class Secret {
    // Encoding
    public static String encodeMessage(String phraseString) {      
        byte[] encodedBytes = Base64.getEncoder().encode(phraseString.getBytes());
        String encodedString = new String(encodedBytes);        
        
        return encodedString;
        
    }
    
    // Decoding
    public static String decodeMessage(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);

        return decodedString;
    }

}

public class JavaProgramtouseclassBase64 {
    public static int menu(){
        try{
            Scanner scan = new Scanner(System.in);
            System.out.print("""
                +-------------------------------------------------------+
                |            Welcome To Secret Software                 |
                +------+------------------------------------------------+
                |  1.  |        Encrypt Message                         |
                +------+------------------------------------------------+
                |  2.  |        Decrypt Message                         |
                +------+------------------------------------------------+
                |  Enter Your Choice = >""");
            return scan.nextInt();
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static boolean mainloop() {
        switch(menu()) {
            case 1 -> {
                System.out.print("Enter Message to Encode : ");
                try {
                    Scanner scan = new Scanner(System.in);
                    String message = scan.nextLine();
                    System.out.println(Secret.encodeMessage(message));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            case 2 -> {
                System.out.print("Enter Message to Decode : ");
                try {
                    Scanner scan = new Scanner(System.in);
                    String message = scan.nextLine();
                    System.out.println(Secret.decodeMessage(message));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        while(mainloop());
    }
}
