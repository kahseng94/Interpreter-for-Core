package edu.c3341;

public class Assign {
    private Id id;
    private Exp exp;
    private Tokenizer t;

    public Assign() {
        this.id = null;
        this.exp = null;
        this.t = Tokenizer1.instance();
    }

    public void parseAssign() {
        this.id = Id.parseIdForSS();
        if (this.t.getToken() == TokenKind.ASSIGNMENT_OPERATOR) {
            this.t.skipToken(); // skip =
        } else {
            System.out.println("Err: Assign: = needed");
        }
        this.exp = new Exp();
        this.exp.parseExp();
        if (this.t.getToken() == TokenKind.SEMICOLON) {
            this.t.skipToken(); // skip ;
        } else {
            System.out.println("Err: Assign: ; needed");
        }
    }

    public void printAssign() {
        this.id.printId();
        System.out.print(" = ");
        this.exp.printExp();
        System.out.println(";");
    }

    public void execAssign() {
        this.id.setVal(this.exp.evalExp());
    }
}
