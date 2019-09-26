package edu.c3341;

public class DeclSeq {
    private Decl decl;
    private DeclSeq declSeq;
    private Tokenizer t;
    private int altNo;

    public DeclSeq() {
        this.decl = null;
        this.declSeq = null;
        this.t = Tokenizer1.instance();
        this.altNo = 0;
    }

    public void parseDeclSeq() {
        this.decl = new Decl();
        this.decl.parseDecl();
        if (this.t.getToken() == TokenKind.INT) {
            this.altNo = 1;
            this.declSeq = new DeclSeq();
            this.declSeq.parseDeclSeq();
        }
    }

    public void printDeclSeq() {
        System.out.print("    ");
        this.decl.printDecl();
        if (this.altNo == 1) {
            this.declSeq.printDeclSeq();
        }
    }
}
