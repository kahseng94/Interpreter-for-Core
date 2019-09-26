package edu.c3341;

import java.util.ArrayList;

public class Stmt {
    private int altNo;
    private Assign s1;
    private If s2;
    private Loop s3;
    private In s4;
    private Out s5;
    private Tokenizer t;
    
    public Stmt(){
        altNo = 0;
        s1 = null;
        s2 = null;
        s3 = null;
        s4 = null;
        s5 = null;
        
        t = Tokenizer1.instance();
    }
    
    public void parseStmt(){
        if(t.getToken() == TokenKind.IDENTIFIER){
            altNo = 1;
            s1 = new Assign();
            s1.parseAssign();
            return;
        }
        if(t.getToken() == TokenKind.IF){
            altNo = 2;
            s2 = new If();
            s2.parseIf();
            return;
        }
        if(t.getToken() == TokenKind.WHILE){
            altNo = 3;
            s3 = new Loop();
            s3.parseLoop();
            return;
        }
        if(t.getToken() == TokenKind.READ){
            altNo = 4;
            s4 = new In();
            s4.parseIn();
            return;
        }
        if(t.getToken() == TokenKind.WRITE){
            altNo = 5;
            s5 = new Out();
            s5.parseOut();
            return;
        }
    }
    
    public void printStmt(String space){
        if(altNo == 1){
            s1.printAssign();
        }
        if(altNo == 2){
            s2.printIf(space);
        }
        if(altNo == 3){
            s3.printLoop(space);
        }
        if(altNo == 4){
            s4.printIn();
        }
        if(altNo == 5){
            s5.printOut();
        }
    }
    
    public void execStmt(ArrayList<Integer> in){
        if(altNo == 1){
            s1.execAssign();
        }
        if(altNo == 2){
            s2.execIf(in);
        }
        if(altNo == 3){
            s3.execLoop(in);
        }
        if(altNo == 4){
            s4.execIn(in);
        }
        if(altNo == 5){
            s5.execOut();
        }
    }
}
