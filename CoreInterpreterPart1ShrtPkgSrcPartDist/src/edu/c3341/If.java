package edu.c3341;

import java.util.ArrayList;

public class If {
    private Tokenizer t;
    private Cond cond;
    private StmtSeq stmtSeq1;
    private StmtSeq stmtSeq2;
    private int altNo;

    public If() {
        t = Tokenizer1.instance();
        cond = null;
        stmtSeq1 = null;
        stmtSeq2 = null;
        altNo = 0;
    }

    public void parseIf() {
        if (t.getToken() == TokenKind.IF) {
            t.skipToken(); // skip if
            cond = new Cond();
            cond.parseCond();
            if (t.getToken() == TokenKind.THEN) {
                t.skipToken(); // skip then
                stmtSeq1 = new StmtSeq();
                stmtSeq1.parseStmtSeq();
                if (t.getToken() == TokenKind.ELSE) {
                    t.skipToken(); // skip else
                    altNo = 2;
                    stmtSeq2 = new StmtSeq();
                    stmtSeq2.parseStmtSeq();
                }
                if (t.getToken() == TokenKind.END) {
                    t.skipToken(); // skip end
                } else {
                    System.out.println("Err: If: end needed");
                }
                if (t.getToken() == TokenKind.SEMICOLON) {
                    t.skipToken(); // skip ;
                } else {
                    System.out.println("Err: If: ; needed");
                }
            } else {
                System.out.println("Err: If: if needed");
            }
        }
    }

    public void printIf(String space) {
        System.out.print("if ");
        cond.printCond();
        System.out.println(" then");
        String subSpace = space + "   ";
        stmtSeq1.printStmtSeq(subSpace);
        if (altNo == 2) {
            System.out.println(space + "else");
            stmtSeq2.printStmtSeq(subSpace);
        }
        System.out.println(space + "end;");
    }

    public void execIf(ArrayList<Integer> in) {
        if (cond.evalCond()) {
            stmtSeq1.execStmtSeq(in);
        }
        if (altNo == 2) {
            stmtSeq2.execStmtSeq(in);
        }
    }
}
