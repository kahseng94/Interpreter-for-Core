package edu.c3341;

import java.util.ArrayList;
import java.util.List;

public class Id {
    private String name;
    private int val;
    private boolean init;
    private boolean initialized;
    private static Tokenizer t = Tokenizer1.instance();
    private static List<Id> arrId = new ArrayList<>(20);
    private static int idCount = 0;

    private Id(String n) {
        this.name = n;
        this.initialized = false;

    }

    //check whether the identifier is different
    private static Boolean isDiff(String name) {
        for (int i = 0; i < idCount; i++) {
            if (name.equals(arrId.get(i).name)) {
                return false;
            }
        }
        return true;
    }

    public static Id parseIdForDS() {
        //check unique first. Avoid duplicate declared
        if (isDiff(t.idName())) {
            Id id = new Id(t.idName());
            arrId.add(id);
            idCount++;
            t.skipToken();
            return id;
        } else {
            System.out.println("Error! The declared variable is already exist");
            System.exit(1);
            return null;
        }
    }

    public static Id parseIdForSS() {
        boolean decl = false;
        int index = 0;
        for (int i = 0; i < idCount & !decl; i++) {
            if (arrId.get(i).name.equals(t.idName())) {
                index = i;
                decl = true;
            }
        }
        //check whether the identifier declared
        if (decl) {
            Id id = arrId.get(index);
            t.skipToken();
            return id;

        } else {
            System.out.println("Error! The identifier isn't declared!");
            System.exit(1);
            return null;
        }
    }

    public void printId() {
        System.out.print(this.name);
    }

    public Integer getVal() {
        if (this.initialized) {
            return this.val;
        } else {
            System.out.println(
                    "Error: Attempt to use variable X without prior initialization.");
            System.exit(0);
            return 0;
        }
    }

    public void setVal(int val) {
        this.val = val;
        this.initialized = true;
    }

    public String getIdName() {
        return this.name;
    }

    public void setIdName(String s) {
        this.name = s;
    }
}
