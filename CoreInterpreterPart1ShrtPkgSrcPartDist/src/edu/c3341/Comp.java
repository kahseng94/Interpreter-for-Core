package edu.c3341;

public class Comp {
    private Tokenizer t;
    private Op op1;
    private CompOp compOp;
    private Op op2;
    
    public Comp(){
        t = Tokenizer1.instance();
        op1 = null;
        compOp = null;
        op2 = null;
    }
    
    public void parseComp(){
        if(t.getToken() == TokenKind.BRACKET_LEFT){
            t.skipToken(); // skip (
            op1 = new Op();
            compOp = new CompOp();
            op2 = new Op();
            op1.parseOp();
            compOp.parseCompOp();
            op2.parseOp();
            if(t.getToken() == TokenKind.BRACKET_RIGHT){
                t.skipToken(); // skip )
            }else{
                System.out.println("Err: ) needed");
            }
        }
    }
    
    public void printComp(){
        System.out.print("(");
        op1.printOp();
        compOp.printCompOp();
        op2.printOp();
        System.out.print(")");
    }
    
    public boolean evalComp(){
        boolean ans = false;
        if(compOp.getCompOp().equals("!=")){
            ans = (op1.getOp() != op2.getOp());
        }
        if(compOp.getCompOp().equals("==")){
            ans = (op1.getOp() == op2.getOp());
        }
        if(compOp.getCompOp().equals(">")){
            ans = (op1.getOp() > op2.getOp());
        }
        if(compOp.getCompOp().equals("<")){
            ans = (op1.getOp() < op2.getOp());
        }
        if(compOp.getCompOp().equals(">=")){
            ans = (op1.getOp() >= op2.getOp());
        }
        if(compOp.getCompOp().equals("<=")){
            ans = (op1.getOp() <= op2.getOp());
        }
        return ans;
    }
}
