package sample;
import java.util.Scanner;
public class LoginAuthentication {
    public static Scanner read = new Scanner(System.in);
    public static boolean comparePassword(String s) {
        if(s.contentEquals("5845"))
            return true;
           else
               return false;
    }
    public static boolean compareUsername(String s ) {
        if(s.contentEquals("omar")||s.contentEquals("Omar"))
            return true;
        else
            return false;
    }
}
