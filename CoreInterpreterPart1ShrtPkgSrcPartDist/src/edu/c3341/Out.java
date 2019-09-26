package edu.c3341;

public class Out {
    private Tokenizer t;
    private IdList idList;

    public Out() {
        this.t = Tokenizer1.instance();
        this.idList = null;
    }

    public void parseOut() {
        if (this.t.getToken() == TokenKind.WRITE) {
            this.t.skipToken(); // skip write
            this.idList = new IdList();
            this.idList.parseIdListForSS();
            if (this.t.getToken() == TokenKind.SEMICOLON) {
                this.t.skipToken(); // skip ;
            } else {
                System.out.println("Err: Out: Expected ;");
            }
        } else {
            System.out.println("Err: Out: Expected write");
        }
    }

    public void printOut() {
        System.out.print("write ");
        this.idList.printIdList();
        System.out.println(";");
    }

    public void execOut() {
        this.idList.executeWrite();

    }
}
