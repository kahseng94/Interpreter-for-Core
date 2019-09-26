package edu.c3341;

public class Decl {
    private IdList idList;
    private Tokenizer t;

    public Decl() {
        this.idList = null;
        this.t = Tokenizer1.instance();
    }

    public void parseDecl() {
        if (this.t.getToken() == TokenKind.INT) {
            this.t.skipToken(); // skip int
            this.idList = new IdList();
            this.idList.parseIdListForDS();
            if (this.t.getToken() == TokenKind.SEMICOLON) {
                this.t.skipToken(); // skip ;
            } else {
                System.out.println("Err: Decl: Expected ;");
            }
        } else {
            System.out.println("Err: Decl: Expected int");
        }
    }

    public void printDecl() {
        System.out.print("int ");
        this.idList.printIdList();
        System.out.println(";");
    }

}
