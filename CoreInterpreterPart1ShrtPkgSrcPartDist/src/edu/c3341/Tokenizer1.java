package edu.c3341;

import java.util.Iterator;

public class Tokenizer1 implements Tokenizer {

    private String currentToken;
    private String remainToken;
    private TokenKind kind;
    private static Tokenizer singleInstance;

    public Tokenizer1() {
        this.currentToken = "";
        this.remainToken = "";

    }

    /**
     * @param itString
     *            the Iterator<String> from which tokens will be extracted;
     *            Tokenizer expects itString's next() method never to deliver an
     *            empty String or a String containing whitespace.
     * @return the single instance of the Tokenizer
     * @updates itString
     * @ensures <pre>[the reference create returned is the reference to the
     *                newly created and only instance of the class implementing
     *                the Tokenizer interface]  and
     *          there exists content: string of character
     *            (content = AGGREGATE(~#itString.unseen)  and
     *             create.front * create.remainder = content  and
     *             (([no prefix of content is a legal token] and
     *               [create.front is the text of an ERROR token]) or
     *              ([create.front is the text of a legal token kind] and
     *               [create.front cannot be extended by the first character
     *                of create.remainder to be the prefix of any
     *                legal token kind])))
     *       </pre> public static Tokenizer create(Iterator<String> itString)
     *
     */
    public static Tokenizer create(Iterator<String> itString) {

        if (Tokenizer1.singleInstance == null) {
            Tokenizer1 newTok = new Tokenizer1();

            newTok.currentToken = "";
            newTok.remainToken = "";

            while (itString.hasNext()) {
                newTok.remainToken += itString.next();
                newTok.remainToken += " ";
            }

            newTok.skipToken();

            Tokenizer1.singleInstance = newTok;
        }
        return Tokenizer1.singleInstance;
    }

    /**
     * Return either null or the single instance of the Tokenizer, if it exists.
     *
     * @return either null or the single instance of the Tokenizer, if it exists
     *
     *
     *
     */
    public static Tokenizer instance() {
        return Tokenizer1.singleInstance;
    }

    /**
     * Return the kind of the front token. (Restores this.)
     *
     * @return the kind of the front token
     * @ensures getToken = [the kind of token this.front]
     */
    @Override
    public TokenKind getToken() {

        return this.kind;
    }

    /**
     * Skip front token.
     *
     * @updates this
     * @ensures <pre>(if [the token kind of #this.front is good and legal]
     *                  then this.front * this.remainder = #this.remainder)  or
     *          ([the token kind of #this.front is EOF] and
     *          this = #this)</pre>
     */
    @Override
    public void skipToken() {
        //EOF check
        if (this.remainToken.length() > 0) {
            char firstChar = this.remainToken.charAt(0);

            //skip delimiter using recursion
            if (firstChar == ' ' || firstChar == '\n' || firstChar == '\t') {
                this.remainToken = this.remainToken.substring(1);
                this.skipToken();

                //lowercase word check
            } else if (Character.isLowerCase(this.remainToken.charAt(0))) {
                this.currentToken = "";
                this.currentToken += this.remainToken.charAt(0);
                this.remainToken = this.remainToken.substring(1);
                this.kind = TokenKind.LOWER_CASE_WORD;
                //check if the lowercase token has remainder
                while (this.remainToken.length() > 0) {

                    //if next token is lowercase
                    if (Character.isLowerCase(this.remainToken.charAt(0))) {
                        this.currentToken += this.remainToken.charAt(0);
                        this.remainToken = this.remainToken.substring(1);

                        //if next token is uppercase
                    } else if (Character
                            .isUpperCase(this.remainToken.charAt(0))) {
                        this.kind = TokenKind.ERROR;
                        break;

                        //if next token is integer constant
                    } else if (Character.isDigit(this.remainToken.charAt(0))) {
                        this.kind = TokenKind.ERROR;
                        break;
                    } else {
                        break;
                    }

                }
                if (this.kind.equals(TokenKind.LOWER_CASE_WORD)) {
                    switch (this.currentToken) {
                        case "program":
                            this.currentToken = "program";
                            this.kind = TokenKind.PROGRAM;
                            break;
                        case "begin":
                            this.currentToken = "begin";
                            this.kind = TokenKind.BEGIN;
                            break;
                        case "end":
                            this.currentToken = "end";
                            this.kind = TokenKind.END;
                            break;
                        case "int":
                            this.currentToken = "int";
                            this.kind = TokenKind.INT;
                            break;
                        case "if":
                            this.currentToken = "if";
                            this.kind = TokenKind.IF;
                            break;
                        case "then":
                            this.currentToken = "then";
                            this.kind = TokenKind.THEN;
                            break;
                        case "else":
                            this.currentToken = "else";
                            this.kind = TokenKind.ELSE;
                            break;
                        case "while":
                            this.currentToken = "while";
                            this.kind = TokenKind.WHILE;
                            break;
                        case "loop":
                            this.currentToken = "loop";
                            this.kind = TokenKind.LOOP;
                            break;
                        case "read":
                            this.currentToken = "read";
                            this.kind = TokenKind.READ;
                            break;
                        case "write":
                            this.currentToken = "write";
                            this.kind = TokenKind.WRITE;
                            break;
                        default:
                            this.currentToken = "ERROR";
                            this.kind = TokenKind.ERROR;
                            break;
                    }
                }
                //uppercase word check
            } else if (Character.isUpperCase(this.remainToken.charAt(0))) {
                this.currentToken = "";
                this.currentToken += this.remainToken.charAt(0);
                this.remainToken = this.remainToken.substring(1);
                this.kind = TokenKind.IDENTIFIER;
                while (this.remainToken.length() > 0) {

                    //if next token is lowercase
                    if (Character.isLowerCase(this.remainToken.charAt(0))) {
                        this.kind = TokenKind.ERROR;
                        break;

                        //if next token is uppercase and 0
                    } else if (Character.isUpperCase(this.remainToken.charAt(0))
                            || this.remainToken.charAt(0) == '0') {
                        this.currentToken += this.remainToken.charAt(0);
                        this.remainToken = this.remainToken.substring(1);

                        //if next token is integer constant
                    } else if (Character.isDigit(this.remainToken.charAt(0))) {
                        this.currentToken += this.remainToken.charAt(0);
                        this.remainToken = this.remainToken.substring(1);

                        if (this.remainToken.length() > 0) {
                            //if next token after digit is uppercase
                            if (Character
                                    .isUpperCase(this.remainToken.charAt(0))) {
                                this.kind = TokenKind.ERROR;
                                break;
                            }
                        }
                    } else {
                        break;
                    }
                }

                //integer constant check
            } else if (Character.isDigit(this.remainToken.charAt(0))) {
                this.currentToken = "";
                this.currentToken += this.remainToken.charAt(0);
                this.remainToken = this.remainToken.substring(1);
                this.kind = TokenKind.INTEGER_CONSTANT;

                while (this.remainToken.length() > 0) {

                    //if next token is integer constant
                    if (Character.isDigit(this.remainToken.charAt(0))) {
                        this.currentToken += this.remainToken.charAt(0);
                        this.remainToken = this.remainToken.substring(1);

                        //if next token is uppercase
                    } else if (Character
                            .isUpperCase(this.remainToken.charAt(0))) {
                        this.kind = TokenKind.ERROR;
                        break;

                        //if next token is lowercase
                    } else if (Character
                            .isLowerCase(this.remainToken.charAt(0))) {
                        this.kind = TokenKind.ERROR;
                        break;
                    } else {
                        break;
                    }
                }

                //semicolon check
            } else if (firstChar == ';') {
                this.currentToken = ";";
                this.kind = TokenKind.SEMICOLON;
                this.remainToken = this.remainToken.substring(1);

            } else if (firstChar == ',') {
                this.currentToken = ",";
                this.kind = TokenKind.COMMA;
                this.remainToken = this.remainToken.substring(1);

                //assign operator check
            } else if (firstChar == '=') {
                this.currentToken = "=";

                this.remainToken = this.remainToken.substring(1);
                if (this.remainToken.length() > 0) {

                    //equality operator check
                    if (this.remainToken.charAt(0) == '=') {
                        this.currentToken += this.remainToken.charAt(0);
                        this.remainToken = this.remainToken.substring(1);
                        this.kind = TokenKind.EQUALITY_TEST;
                    } else {
                        this.kind = TokenKind.ASSIGNMENT_OPERATOR;
                    }
                } else {
                    this.kind = TokenKind.ASSIGNMENT_OPERATOR;
                }
                //exclamation check
            } else if (firstChar == '!') {
                this.remainToken = this.remainToken.substring(1);
                if (this.remainToken.length() > 0) {
                    if (this.remainToken.charAt(0) == '=') {
                        this.currentToken = "!=";
                        this.remainToken = this.remainToken.substring(1);
                        this.kind = TokenKind.NOTEQUAL_TEST;

                    } else {
                        this.currentToken = "!";
                        this.kind = TokenKind.EXCLAMATION;
                    }
                }

            } else if (firstChar == '[') {
                this.currentToken = "[";
                this.kind = TokenKind.SQUAREBRACKET_LEFT;
                this.remainToken = this.remainToken.substring(1);

            } else if (firstChar == ']') {
                this.currentToken = "]";
                this.kind = TokenKind.SQUAREBRACKET_RIGHT;
                this.remainToken = this.remainToken.substring(1);

            } else if (firstChar == '&') {
                this.currentToken = "&";
                this.remainToken = this.remainToken.substring(1);
                if (this.remainToken.length() > 0) {

                    //or operator check
                    if (this.remainToken.charAt(0) == '&') {
                        this.currentToken += this.remainToken.charAt(0);
                        this.remainToken = this.remainToken.substring(1);
                        this.kind = TokenKind.AND_OPERATOR;
                    } else {
                        this.kind = TokenKind.ERROR;

                    }
                }
                //or operator check
            } else if (firstChar == '|') {
                this.currentToken = "|";
                this.remainToken = this.remainToken.substring(1);
                if (this.remainToken.length() > 0) {

                    //or operator check
                    if (this.remainToken.charAt(0) == '|') {
                        this.currentToken += this.remainToken.charAt(0);
                        this.remainToken = this.remainToken.substring(1);
                        this.kind = TokenKind.OR_OPERATOR;
                    } else {
                        this.kind = TokenKind.ERROR;

                    }

                } else {
                    this.kind = TokenKind.ERROR;

                }

            } else if (firstChar == '(') {
                this.currentToken = "(";
                this.kind = TokenKind.BRACKET_LEFT;
                this.remainToken = this.remainToken.substring(1);

            } else if (firstChar == ')') {
                this.currentToken = ")";
                this.kind = TokenKind.BRACKET_RIGHT;
                this.remainToken = this.remainToken.substring(1);

            } else if (firstChar == '+') {

                this.currentToken = "+";
                this.kind = TokenKind.PLUS;
                this.remainToken = this.remainToken.substring(1);
            } else if (firstChar == '-') {

                this.currentToken = "-";
                this.kind = TokenKind.MINUS;
                this.remainToken = this.remainToken.substring(1);
            } else if (firstChar == '*') {

                this.currentToken = "*";
                this.kind = TokenKind.MULTIPLY;
                this.remainToken = this.remainToken.substring(1);

            } else if (firstChar == '<') {
                // handle smaller and smaller equal
                this.remainToken = this.remainToken.substring(1);
                if (this.remainToken.length() > 0
                        && this.remainToken.charAt(0) == '=') {
                    this.currentToken = "<=";
                    this.kind = TokenKind.SMALLER_EQUAL;
                    this.remainToken = this.remainToken.substring(1);
                } else {
                    this.currentToken = "<";
                    this.kind = TokenKind.SMALLER;
                }

            } else if (firstChar == '>') {
                // handle smaller and smaller equal
                this.remainToken = this.remainToken.substring(1);
                if (this.remainToken.length() > 0
                        && this.remainToken.charAt(0) == '=') {
                    this.currentToken = ">=";
                    this.kind = TokenKind.LARGER_EQUAL;
                    this.remainToken = this.remainToken.substring(1);
                } else {
                    this.currentToken = ">";
                    this.kind = TokenKind.LARGER;
                }
            } else {
                this.kind = TokenKind.ERROR;
            }
        } else {
            this.kind = TokenKind.EOF;
        }

    }

    /**
     * Return the integer value of the front INTEGER_CONSTANT token. (Restores
     * this.)
     *
     * @return the integer value of the front INTEGER_CONSTANT token
     * @requires [the kind of this.front is INTEGER_CONSTANT]
     * @ensures intVal = [the integer value of this.front]
     */
    @Override
    public int intVal() {

        return Integer.parseInt(this.currentToken);
    }

    /**
     * Return the name of the front IDENTIFIER token. (Restores this.)
     *
     * @return the name of the front IDENTIFIER token
     * @requires [the kind of this.front is IDENTIFIER]
     * @ensures intVal = this.front
     */
    @Override
    public String idName() {

        return this.currentToken;
    }

}
