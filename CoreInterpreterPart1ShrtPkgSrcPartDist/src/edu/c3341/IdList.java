package edu.c3341;

import java.util.ArrayList;
import java.util.List;

public class IdList {
    private List<Id> idlist;//list of ids
    private Tokenizer t;

    public IdList() {
        this.t = Tokenizer1.instance();
        this.idlist = new ArrayList<>();

    }

    public void parseIdListForDS() {
        if (this.t.getToken() != TokenKind.IDENTIFIER) {
            System.out.println("Error! Expecting an identifier token!");
            System.exit(1);
        }
        while (this.t.getToken() == TokenKind.IDENTIFIER) {
            //parse all ids in the idlist
            Id id = Id.parseIdForDS();

            this.idlist.add(id);

            //skip comma
            if (this.t.getToken() == TokenKind.COMMA) {
                this.t.skipToken();
            }
        }
    }

    public void parseIdListForSS() {
        if (this.t.getToken() != TokenKind.IDENTIFIER) {
            System.out.println("Error! Expecting an identifier token!");
            System.exit(1);
        }
        while (this.t.getToken() == TokenKind.IDENTIFIER) {
            Id id = Id.parseIdForSS();
            this.idlist.add(id);
            if (this.t.getToken() == TokenKind.COMMA) {
                this.t.skipToken();
            }
        }
    }

    public void printIdList() {

        this.idlist.get(0).printId();
        //print all ids
        for (int i = 1; i < this.idlist.size(); i++) {
            System.out.print(", ");
            this.idlist.get(i).printId();

        }
    }

    public void executeRead() {
        //read each value of id that in the idlist and set the id value
        for (int i = 0; i < this.idlist.size(); i++) {
            this.idlist.get(i).setVal(Prog.getNextData());
        }

    }

    public void executeWrite() {
        //write all ids and their values
        for (int i = 0; i < this.idlist.size(); i++) {
            int value = this.idlist.get(i).getVal();
            this.idlist.get(i).printId();
            System.out.println(" = " + value);
        }
    }
}
