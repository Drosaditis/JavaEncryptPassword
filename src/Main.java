import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Give me password to encrypt");
        Scanner input=new Scanner(System.in);
        String password = input.nextLine();
        System.out.println("Original: " + password );
        System.out.println("Hash: " + toMD5Hash(password) );

    }

    static String toHexadecimal ( byte[] source ) {

        StringBuilder sb = new StringBuilder();

        for ( byte b : source ) {

            String toAppend = String.format("%2X", b ).replace(" ", "0"); // %X Hexadecimal
            sb.append( toAppend );
        }

        return sb.toString();
    }

    static String toMD5Hash ( String source ) {

        String result = "";

        try {

            MessageDigest md5 = MessageDigest.getInstance( "MD5" );
            byte[] md5HashBytes = md5.digest( source.getBytes() );

            result = toHexadecimal( md5HashBytes );
        }
        catch ( NoSuchAlgorithmException e ) {

            e.printStackTrace();
        }

        return result;
    }
}
