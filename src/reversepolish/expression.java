package reversepolish;

import java.util.Stack;

/**
 *
 * @author Ant8off
 */

public class expression{
    
    private Stack segni;                                                        //used to store signs (+, -, *, /)
    private int parentesi = 0;                                                  //used to count how many braces are in "segni" stack
    private int aperte;                                                         //used to count how many braces are open 
    private String polish = "";                                                 //output string 
    
    /**
     * 
     * @param espressione 
     */
    public expression(String espressione){
        this.segni = new Stack();                                               //stack init
        for(int i = 0; i<espressione.length(); i++){                            //for each char in expression string
            
            switch(espressione.charAt(i)){                                      //check what char is in the string
                case '+':                                                       //if is +
                    if(espressione.charAt(i+1) == '+' || espressione.charAt(i+1) == '-'){ // check if has the same value 
                        push(espressione.charAt(i));                            //TRUE call push method
                    }else{
                        segni.push(espressione.charAt(i));                      //FALSE push to stack          
                    }
                break;
                case '-':                                                       //same thing as +
                    if(espressione.charAt(i+1) == '+' || espressione.charAt(i+1) == '-'){
                        push(espressione.charAt(i));
                    }else{
                        segni.push(espressione.charAt(i));
                    }
                break;
                case '*':                                                       //call push method
                    push(espressione.charAt(i));
                break;
                case '/':
                    push(espressione.charAt(i));                                //same as *
                break;
                case '(':
                    segni.push(espressione.charAt(i));                          //push in stack
                    aperte ++;                                                  //increase opened braces
                break;
                case ')':
                    while(!segni.isEmpty() && parentesi != aperte){             //check if stack is empty and if braces are not same as opened braces
                        if(segni.peek() != (Character)'('){                     //if last element of stack is not an (
                            polish += segni.pop();                              //pops the sign in string
                        }else{
                            segni.pop();                                        //pops brace
                            parentesi ++;                                       //encrease braces
                            aperte --;                                          //decrease open braces
                        }
                    }
                    parentesi = 0;                                              //nulls total braces
                break;
                default:
                    polish += espressione.charAt(i);                            //append to polish string
                break;  
            }
        }
        
        while(!segni.isEmpty()){                                                //pops all the stack out in polish string
            polish += segni.pop();
        }
        
        polish = polish.strip();                                                //formats the String
    }
    
    /**
     * 
     * @param c 
     */
    private void push(char c){
        if(!segni.isEmpty() && segni.peek() != (Character)'(')                  //check if stack is not empty and if the top has (
            polish += segni.pop();                                              //pops into polish last sign
        segni.push(c);                                                          //push into stack the sign
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){                                                   //return polish string
        return polish;
    }

}
