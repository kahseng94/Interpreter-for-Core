package edu.c3341;

import java.util.ArrayList;

public class Prog {
    private Tokenizer t;
    private DeclSeq ds;
    private StmtSeq ss;
    private static ArrayList<Integer> in;
    private static int pos;

    public Prog(ArrayList<Integer> input) {
        this.t = Tokenizer1.instance();
        this.ds = null;
        this.ss = null;
        in = input;
    }

    //get the next data value
    public static int getNextData() {
        int value = in.get(pos);
        pos++;
        return value;
    }

    public void parseProg() {
        if (this.t.getToken() == TokenKind.PROGRAM) {
            this.t.skipToken(); // skip program
            this.ds = new DeclSeq();
            this.ds.parseDeclSeq();
            if (this.t.getToken() == TokenKind.BEGIN) {
                this.t.skipToken();
                this.ss = new StmtSeq();
                this.ss.parseStmtSeq();
                if (this.t.getToken() == TokenKind.END) {
                    this.t.skipToken(); // skip end
                } else {
                    System.out.println("Error: Prog: expected \"end\" token");
                }
            } else {
                System.out.println("Error: Prog: expected \"begin\" token");
            }
        } else {
            System.out.println("Error: Prog: expected \"program\" token");
        }
    }

    public void printProg() {
        System.out.println("program");
        this.ds.printDeclSeq();
        System.out.println("begin");
        this.ss.printStmtSeq("   ");
        System.out.println("end");
    }

    public void execProg() {
        this.ss.execStmtSeq(in);
    }
}
