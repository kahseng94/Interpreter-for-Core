package edu.c3341;

public class CompOp {
    private String op;
    private Tokenizer t;

    public CompOp() {
        this.op = null;
        this.t = Tokenizer1.instance();
    }

    public void parseCompOp() {
        if (this.t.getToken() == TokenKind.NOTEQUAL_TEST) {
            this.op = "!=";
        } else if (this.t.getToken() == TokenKind.EQUALITY_TEST) {
            this.op = "==";
        } else if (this.t.getToken() == TokenKind.SMALLER) {
            this.op = "<";
        } else if (this.t.getToken() == TokenKind.LARGER) {
            this.op = ">";
        } else if (this.t.getToken() == TokenKind.SMALLER_EQUAL) {
            this.op = "<=";
        } else if (this.t.getToken() == TokenKind.LARGER_EQUAL) {
            this.op = ">=";
        } else {
            System.out.println(
                    "Error: Illegal token encountered for parseCompOp.");
        }
        this.t.skipToken();
    }

    public void printCompOp() {
        System.out.print(" " + this.op + " ");
    }

    public String getCompOp() {
        return this.op;
    }
}
