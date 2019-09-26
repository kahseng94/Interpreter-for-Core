package edu.c3341;

public class No {
    private int no;
    private Tokenizer t;
    
    public No(){
        no = 0;
        t = Tokenizer1.instance();
    }
    
    public void parseNo(){
        if(t.getToken() == TokenKind.INTEGER_CONSTANT){
            int val = t.intVal();
            no = val;
            t.skipToken();
        }else{
            System.out.println("Error: Illegal token encountered for parseNo.");
        }
    }

    public void printNo(){
        System.out.print(no);
    }
    
    public int getNo(){
        return no;
    }
}
