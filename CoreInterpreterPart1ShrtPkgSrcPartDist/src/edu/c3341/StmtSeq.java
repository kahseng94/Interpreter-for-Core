package edu.c3341;

import java.util.ArrayList;

public class StmtSeq {
    private Tokenizer t;
    private Stmt stmt;
    private StmtSeq stmtSeq;
    private int altNo;

    public StmtSeq() {
        this.t = Tokenizer1.instance();
        this.stmt = null;
        this.stmtSeq = null;
        this.altNo = 0;
    }

    public void parseStmtSeq() {
        this.stmt = new Stmt();
        this.stmt.parseStmt();
        if (this.t.getToken() == TokenKind.IDENTIFIER
                || this.t.getToken() == TokenKind.IF
                || this.t.getToken() == TokenKind.WHILE
                || this.t.getToken() == TokenKind.READ
                || this.t.getToken() == TokenKind.WRITE) {
            this.altNo = 2;
            this.stmtSeq = new StmtSeq();
            this.stmtSeq.parseStmtSeq();
        }
    }

    public void printStmtSeq(String space) {
        System.out.print(space);
        this.stmt.printStmt(space);
        if (this.altNo == 2) {
            this.stmtSeq.printStmtSeq(space);
        }
    }

    public void execStmtSeq(ArrayList<Integer> in) {
        this.stmt.execStmt(in);
        if (this.altNo == 2) {
            this.stmtSeq.execStmtSeq(in);
        }
    }
}
