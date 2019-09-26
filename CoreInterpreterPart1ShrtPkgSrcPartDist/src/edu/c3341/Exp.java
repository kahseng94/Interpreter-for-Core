package edu.c3341;

public class Exp {
    private Tokenizer t;
    private Trm trm;
    private Exp exp;
    private int altNo;
    
    public Exp(){
        t = Tokenizer1.instance();
        trm = null;
        exp = null;
        altNo = 0;
    }

    public void parseExp(){
        trm = new Trm();
        trm.parseTrm();
        if(t.getToken() == TokenKind.PLUS){
            altNo = 2;
            t.skipToken(); // skip add operator
            exp = new Exp();
            exp.parseExp();
        }
        if(t.getToken() == TokenKind.MINUS){
            altNo = 3;
            t.skipToken(); // skip minus operator
            exp = new Exp();
            exp.parseExp();
        }
    }
    
    public void printExp(){
        trm.printTrm();
        if(altNo == 2){
            System.out.print(" + ");
            exp.printExp();
        }
        if(altNo == 3){
            System.out.print(" - ");
            exp.printExp();
        }
    }
    
    public int evalExp(){
        int ans = trm.evalTrm();
        if(altNo == 2){
            ans = ans + exp.evalExp();
        }
        if(altNo == 3){
            ans = ans - exp.evalExp();
        }
        return ans;
    }
}
