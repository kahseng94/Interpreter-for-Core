package edu.c3341;

/**
 * Token kinds needed for Part 1 of the Core Interpreter project.
 *
 * @author Wayne D, Heym
 *
 */
enum TokenKind {

    /**
     * Test driver's token number = 1.
     */
    LOWER_CASE_WORD(0),

    /**
     * Test driver's token number = 1; token is program.
     */
    PROGRAM(1),

    /**
     * Test driver's token number = 2; token is begin.
     */
    BEGIN(2),

    /**
     * Test driver's token number = 3; token is end.
     */
    END(3),

    /**
     * Test driver's token number = 4; token is int.
     */
    INT(4),

    /**
     * Test driver's token number = 5; token is if.
     */
    IF(5),

    /**
     * Test driver's token number = 6; token is then.
     */
    THEN(6),

    /**
     * Test driver's token number = 7; token is else.
     */
    ELSE(7),

    /**
     * Test driver's token number = 8; token is while.
     */
    WHILE(8),

    /**
     * Test driver's token number = 9; token is loop.
     */
    LOOP(9),

    /**
     * Test driver's token number = 10; token is read.
     */
    READ(10),

    /**
     * Test driver's token number = 11; token is write.
     */
    WRITE(11),
    /**
     * Test driver's token number = 12; token is ;.
     */
    SEMICOLON(12),

    /**
     * Test driver's token number = 13; token is ,.
     */
    COMMA(13),

    /**
     * Test driver's token number = 14; token is =.
     */
    ASSIGNMENT_OPERATOR(14),

    /**
     * Test driver's token number = 15; token is !.
     */
    EXCLAMATION(15),

    /**
     * Test driver's token number = 16; token is [.
     */
    SQUAREBRACKET_LEFT(16),

    /**
     * Test driver's token number = 17; token is ].
     */
    SQUAREBRACKET_RIGHT(17),

    /**
     * Test driver's token number = 18; token is &&.
     */
    AND_OPERATOR(18),

    /**
     * Test driver's token number = 19; token is ||.
     */
    OR_OPERATOR(19),

    /**
     * Test driver's token number = 20; token is (.
     */
    BRACKET_LEFT(20),

    /**
     * Test driver's token number = 21; token is ).
     */
    BRACKET_RIGHT(21),

    /**
     * Test driver's token number = 22; token is +.
     */
    PLUS(22),

    /**
     * Test driver's token number = 23; token is -.
     */
    MINUS(23),

    /**
     * Test driver's token number = 24; token is *.
     */
    MULTIPLY(24),

    /**
     * Test driver's token number = 25; token is !=.
     */
    NOTEQUAL_TEST(25),

    /**
     * Test driver's token number = 26; token is ==.
     */
    EQUALITY_TEST(26),

    /**
     * Test driver's token number = 27; token is <.
     */
    SMALLER(27),

    /**
     * Test driver's token number = 28; token is >.
     */
    LARGER(28),

    /**
     * Test driver's token number = 29; token is <=.
     */
    SMALLER_EQUAL(29),

    /**
     * Test driver's token number = 30; token is >=.
     */
    LARGER_EQUAL(30),

    /**
     * Test driver's token number = 31.
     */
    INTEGER_CONSTANT(31),

    /**
     * Test driver's token number = 32.
     */
    IDENTIFIER(32),

    /**
     * Test driver's token number = 33.
     */
    EOF(33),

    /**
     * Test driver's token number = 34.
     */
    ERROR(34);

    /**
     * Test driver's token number.
     */
    private int testDriverTokenNumber;

    /**
     * Constructor.
     *
     * @param number
     *            the test driver's token number
     */
    private TokenKind(int number) {
        this.testDriverTokenNumber = number;
    }

    /**
     * Return test driver's token number.
     *
     * @return test driver's token number
     */
    public int testDriverTokenNumber() {
        return this.testDriverTokenNumber;
    }
}
