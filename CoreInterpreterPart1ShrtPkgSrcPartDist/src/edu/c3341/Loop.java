package edu.c3341;

import java.util.ArrayList;

public class Loop {
    private Tokenizer t;
    private Cond cond;
    private StmtSeq stmtSeq;

    public Loop() {
        this.t = Tokenizer1.instance();
        this.cond = null;
        this.stmtSeq = null;
    }

    public void parseLoop() {

        if (this.t.getToken() == TokenKind.WHILE) {
            this.t.skipToken(); // skip while
            this.cond = new Cond();
            this.cond.parseCond();

            if (this.t.getToken() == TokenKind.LOOP) {
                this.t.skipToken(); //skip loop
                this.stmtSeq = new StmtSeq();
                this.stmtSeq.parseStmtSeq();
            }
            if (this.t.getToken() == TokenKind.END) {
                this.t.skipToken();
            } else {
                System.out.println("Err: Loop: enddo needed");
            }
            if (this.t.getToken() == TokenKind.SEMICOLON) {
                this.t.skipToken(); // skip ;
            } else {
                System.out.println("Err: Loop: ; needed");
            }
        } else {
            System.out.println("Err: Loop: loop needed");
        }
    }

    public void printLoop(String space) {
        System.out.print("while ");
        cond.printCond();
        System.out.println(" loop");
        stmtSeq.printStmtSeq(space + "   ");
        System.out.println(space + "end;");
    }

    public void execLoop(ArrayList<Integer> in) {
        while (this.cond.evalCond()) {
            this.stmtSeq.execStmtSeq(in);
        }
    }
}
