package edu.c3341;

public class Cond {
    private Tokenizer t;
    private Comp comp;
    private Cond cond1;
    private Cond cond2;
    private int altNo;
    
    public Cond(){
        t = Tokenizer1.instance();
        comp = null;
        cond1 = null;
        cond2 = null;
        altNo = 0;
    }
    
    public void parseCond(){
        if(t.getToken() == TokenKind.BRACKET_LEFT){
            altNo = 1;
            comp = new Comp();
            comp.parseComp();
        }
        if(t.getToken() == TokenKind.EXCLAMATION){
            altNo = 2;
            t.skipToken(); // skip !
            cond1 = new Cond();
            cond1.parseCond();
        }
        if(t.getToken() == TokenKind.SQUAREBRACKET_LEFT){
            t.skipToken(); // skip [
            cond1 = new Cond();
            cond1.parseCond();
            if(t.getToken() == TokenKind.AND_OPERATOR){
                altNo = 3;
            }
            if(t.getToken() == TokenKind.OR_OPERATOR){
                altNo = 4;
            }
            t.skipToken(); // skip && or ||
            cond2 = new Cond();
            cond2.parseCond();
            if(t.getToken() == TokenKind.SQUAREBRACKET_RIGHT){
                t.skipToken();
            }else{
                System.out.println("Err: ] needed");
            }
        }
    }
    
    public void printCond(){
        if(altNo == 1){
            comp.printComp();
        }
        if(altNo ==2){
            System.out.print("!");
            cond1.printCond();
        }
        if(altNo == 3 || altNo == 4){
            System.out.print("[");
            cond1.printCond();
            
            if(altNo == 3){
                System.out.print("&&");
            }
            if(altNo == 4){
                System.out.print("||");
            }
            cond2.printCond();
            System.out.print("]");
        }
    }
    
    public boolean evalCond(){
        boolean ans = false;
        if(altNo == 1){
            ans = comp.evalComp();
        }
        if(altNo == 2){
            ans = (!comp.evalComp());
        }
        if(altNo == 3){
            ans = (cond1.evalCond() && cond2.evalCond());
        }
        if(altNo == 4){
            ans = (cond1.evalCond() || cond2.evalCond());
        }
        return ans;
    }
}
