package edu.c3341;

import static edu.c3341.TokenKind.ERROR;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Part 1 of Project 1 for CSE 3341. Test a Tokenizer for Core.
 *
 * @author Wayne D. Heym
 *
 */
public final class TokenizerTest {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private TokenizerTest() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner in;
        try {
            in = new Scanner(Paths.get(args[0]));
        } catch (IOException e) {
            System.err.println("Error opening file: " + args[0]);
            return;
        }
        Tokenizer t = Tokenizer1.create(in);
        while (t.getToken() != TokenKind.EOF && t.getToken() != ERROR) {
            System.out.println(t.getToken().testDriverTokenNumber());
            t.skipToken();
        }

        if (t.getToken() == TokenKind.EOF) {
            System.out.println(t.getToken().testDriverTokenNumber());
        }

        if (t.getToken() == ERROR) {
            System.out.println("Error: Illegal token encountered.");
        }
        /*
         * Close input stream
         */
        in.close();
    }

}
