package edu.c3341;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Interpreter {

    private Interpreter() {

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     * 
     * @throw IOException
     */
    public static void main(String[] args) {
        Scanner progIn, dataIn;
        try {
            progIn = new Scanner(Paths.get(args[0]));
        } catch (IOException e) {
            System.err.println("Error opening file: " + args[0]);
            return;
        }

        try {
            dataIn = new Scanner(Paths.get(args[1]));
        } catch (IOException e) {
            System.err.println("Error opening file: " + args[1]);
            return;
        }

        String isPrint = args[2];

        ArrayList<Integer> input = new ArrayList<>();

        while (dataIn.hasNext()) {
            int temp = dataIn.nextInt();
            input.add(temp);
        }

        Tokenizer t = Tokenizer1.create(progIn);
        if (t.getToken() == TokenKind.PROGRAM) {
            Prog prog = new Prog(input);

            prog.parseProg();

            //print if print command is entered
            if (isPrint.equals("print")) {
                prog.printProg();
            } else if (!isPrint.equals("doNotPrint")) {
                System.out.println(
                        "Error: Please include the third argument or type it in a correct spelling (print/doNotPrint)");
                System.exit(1);
            }

            prog.execProg();
        } else {
            System.out.println("Error: First Token Must Be \"Program\"");
        }

        /*
         * Close input stream
         */
        progIn.close();
        dataIn.close();
    }
}
