# Documentation of the Interpreter Project
## User Manual
1. First, the program will read its input from a file whose name will be specified as a command line argument
2. After the reading of the input file, the program will create a tokenizer to separate different token into different token kind.
3. After that, the program will print out the numbers according to the token kind from the input file.
  -if the input valid, print test driver token number.
  -if not, print Error message.

## Files included:
Tokenizer.java : interface of Tokenizer for Core Interpreter project.  
Tokenizer1.java : Implements Tokenizer.  
TokenKind.java : Token kinds needed for the Core Interpreter project.  
TokenizerTest.java : Test a tokenizer for Core language.  
Interpreter.java :  Create an Interpreter for Core language.  
Assign.java : Implementation of parser, printer and executor for assignment.  
Comp.java : Implementation of parser, printer and executor for comparison statement.  
CompOp.java : Implementation of parser, printer and executor for comparison assignment.  
Cond.java : Implementation of parser, printer and executor for conditional.  
Decl.java : Implementation of parser, printer and executor for declaration.  
DeclSeq.java : Implementation of parser, printer and executor for declaration sequence.  
Exp.java : Implementation of parser, printer and executor for expression.  
Id.java : Implementation of parser, printer and executor for identifier.  
IdList.java : Implementation of parser, printer and executor for identifier list.  
If.java : Implementation of parser, printer and executor for if statement.  
In.java : Implementation of parser, printer and executor for read/input.  
Loop.java : Implementation of parser, printer and executor for while loop.  
No.java : Implementation of parser, printer and executor for digit.  
Op.java : Implementation of parser, printer and executor for operation.  
Out.java : Implementation of parser, printer and executor for write/output.  
Prog.java : Implementation of parser, printer and executor for beginning of the program.  
Stmt.java : Implementation of parser, printer and executor for statement.  
StmtSeq.java : Implementation of parser, printer and executor for statement sequence.  
Trm.java : Implementation of parser, printer and executor for term.  


## Functions implemented:
**getToken()**:   
	- returns current token kind   
	- Repeated calls to getToken() return same token.   
 
**skipToken()**:   
	- skips front token   
	- next non-whitespace token becomes front token   
	- so next call to getToken() will return new token.  

**create(Iterator<String> itString)**:  
	-extract the iterator<String>  
	-declare a new tokenizer  
	-copy every character into the remainToken string variable  
	-assign the tokenizer to an instance   

**instance()**:  
	-Return either null or the single instance of the Tokenizer, if it exists.  
	
**parse()** for every non-terminal class:  
    -Obtain abstract parse tree  
    -Pass root node to PS (S is starting non-terminal).  
    -Each PN gets most of the work done by procedures  
        corresponding to the children of the node it receives as argument.  
        
**print()** for every non-terminal class:  
    -pretty print all the token with organized indentation  

**execute()** for every non-terminal class:  
    -execute the input code using the parser  
     
## Testing
This program passed all the test file provided by the instructor.  
There is no bug in the program.  
