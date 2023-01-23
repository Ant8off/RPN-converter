package reversepolish;

public class Reversepolish {

    public static void main(String[] args) {
        
        expression e1 = new expression("((10 * 2) + (4 - 5)) / 2");
        
        
        System.out.println(e1.toString());
        
        expression e2 = new expression("(7 / 3) / ((1 - 4) * 2) + 1");
        
        System.out.println(e2.toString());
        
    }
    
}
