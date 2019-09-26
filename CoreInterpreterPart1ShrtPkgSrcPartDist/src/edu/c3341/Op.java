package edu.c3341;

public class Op {
    private Tokenizer t;
    private int altNo;
    private No no;
    private Id id;
    private Exp exp;

    public Op() {
        this.t = Tokenizer1.instance();
        this.altNo = 0;
        this.no = null;
        this.id = null;
        this.exp = null;
    }

    public void parseOp() {
        TokenKind tokNo = this.t.getToken();
        if (tokNo == TokenKind.INTEGER_CONSTANT) {
            this.altNo = 1;
            this.no = new No();
            this.no.parseNo();
        }
        if (tokNo == TokenKind.IDENTIFIER) {
            this.altNo = 2;
            this.id = Id.parseIdForSS();
        }
        if (tokNo == TokenKind.BRACKET_LEFT) {
            this.t.skipToken(); // skip left parenthese
            this.altNo = 3;
            this.exp.parseExp();
            if (this.t.getToken() == TokenKind.BRACKET_RIGHT) {
                this.t.skipToken(); // skip right parenthese
            } else {
                System.out.println("Err: ) needed");
            }
        }
    }

    public void printOp() {
        if (this.altNo == 1) {
            this.no.printNo();
        }
        if (this.altNo == 2) {
            this.id.printId();
        }
        if (this.altNo == 3) {
            System.out.print("(");
            this.exp.parseExp();
            System.out.print(")");
        }
    }

    public int getOp() {
        int ans = 0;
        if (this.altNo == 1) {
            ans = this.no.getNo();
        }
        if (this.altNo == 2) {
            ans = this.id.getVal();
        }
        if (this.altNo == 3) {
            ans = this.exp.evalExp();
        }
        return ans;
    }
}
