package edu.c3341;

public class Trm {
    private Tokenizer t;
    private Op op;
    private Trm trm;
    private int altNo;
    
    public Trm(){
        t = Tokenizer1.instance();
        op = null;
        trm = null;
        altNo = 0;
    }

    public void parseTrm(){
        op = new Op();
        op.parseOp();
        if(t.getToken() == TokenKind.MULTIPLY){
            altNo = 1;
            t.skipToken(); //skip * operator
            trm = new Trm();
            trm.parseTrm();
        }
    }
    
    public void printTrm(){
        op.printOp();
        if(altNo == 1){
            System.out.print(" * ");
            trm.printTrm();
        }
    }
    
    public int evalTrm(){
        int ans = op.getOp();
        if(altNo == 1){
            ans = ans * trm.evalTrm();
        }
        return ans;
    }
}
