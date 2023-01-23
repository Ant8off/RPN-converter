package reversepolish;

import java.util.Stack;

/**
 *
 * @author antoa
 */

public class expression{
    
    private Stack segni;
    private String espressione;
    private int parentesi = 0;
    private int aperte;
    private String polish = "";
    
    public expression(String espressione){
        this.espressione = espressione;
        this.segni = new Stack();
        for(int i = 0; i<espressione.length(); i++){
            
            System.out.println("giro "+i+": \n"+segni);
            switch(espressione.charAt(i)){
                case '+':
                    if(espressione.charAt(i+1) == '+' || espressione.charAt(i+1) == '-'){
                        push(espressione.charAt(i));
                    }else{
                        segni.push(espressione.charAt(i));
                    }
                break;
                case '-':
                    if(espressione.charAt(i+1) == '+' || espressione.charAt(i+1) == '-'){
                        push(espressione.charAt(i));
                    }else{
                        segni.push(espressione.charAt(i));
                    }
                break;
                case '*':
                    push(espressione.charAt(i));
                break;
                case '/':
                    push(espressione.charAt(i));
                break;
                case '(':
                    segni.push(espressione.charAt(i)); 
                    aperte ++;
                break;
                case ')':
                    while(!segni.isEmpty() && parentesi < aperte){
                        System.out.println(segni.peek());
                        if(segni.peek() != (Character)'('){
                            polish += segni.pop();
                        }else{
                            segni.pop();
                            parentesi ++;
                            aperte --;
                        }
                        
                        
                        System.out.println("Nuova Stringa: " + polish);
                    }
                    parentesi = 0;
                break;
                default:
                    polish += espressione.charAt(i);
                break;  
            }
        }
        
        while(!segni.isEmpty()){
            polish += segni.pop();
        }
        
        polish = polish.strip();
    }
    
    private void push(char c){
        if(!segni.isEmpty() && segni.peek() != (Character)'(')
        polish += segni.pop();
        segni.push(c);
    }
    
    @Override
    public String toString(){
        return polish;
    }

}
