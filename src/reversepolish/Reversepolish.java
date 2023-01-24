package reversepolish;

import java.util.Scanner;

public class Reversepolish {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        /*
        expression e1 = new expression("((10 * 2) + (4 - 5)) / 2");
        
        
        System.out.println(e1.toString());
        
        expression e2 = new expression("(7 / 3) / ((1 - 4) * 2) + 1");
        
        System.out.println(e2.toString());
        
        expression e3 = new expression("5 + (10 * 2)");
        
        System.out.println(e3.toString());
        */
        
        String input;
        
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("  _____  _____  _   _    _____                          _            \n" +
                           " |  __ \\|  __ \\| \\ | |  / ____|                        | |           \n" +
                           " | |__) | |__) |  \\| | | |     ___  _ ____   _____ _ __| |_ ___ _ __ \n" +
                           " |  _  /|  ___/| . ` | | |    / _ \\| '_ \\ \\ / / _ \\ '__| __/ _ \\ '__|\n" +
                           " | | \\ \\| |    | |\\  | | |___| (_) | | | \\ V /  __/ |  | ||  __/ |   \n" +
                           " |_|  \\_\\_|    |_| \\_|  \\_____\\___/|_| |_|\\_/ \\___|_|   \\__\\___|_|   ");
        
        System.out.println("\n\n\n");
        System.out.print("Input your expression: ");
        input = sc.nextLine();
        
        expression e1 = new expression(input);
        
        System.out.println("RPN CONVERTED -> " + e1.toString());
        
        System.out.println("+-------------------------------------------------------------------------+");
        
        
    }
    
}
