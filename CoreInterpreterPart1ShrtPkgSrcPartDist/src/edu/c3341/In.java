package edu.c3341;

import java.util.ArrayList;

public class In {
    private Tokenizer t;
    private IdList idList;

    public In() {
        this.t = Tokenizer1.instance();
        this.idList = null;
    }

    public void parseIn() {
        if (this.t.getToken() == TokenKind.READ) {
            this.t.skipToken(); // skip read
            this.idList = new IdList();
            this.idList.parseIdListForSS();
            if (this.t.getToken() == TokenKind.SEMICOLON) {
                this.t.skipToken(); // skip ;
            } else {
                System.out.println("Err: In: ; needed");
            }
        } else {
            System.out.println("Err: In: read needed");
        }
    }

    public void printIn() {
        System.out.print("read ");
        this.idList.printIdList();
        System.out.println(";");
    }

    public void execIn(ArrayList<Integer> in) {
        this.idList.executeRead();
    }
}
