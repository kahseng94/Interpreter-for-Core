# README
## How to compile:  
1. import this zip file into eclipse  
2. OSU library component should be included  
3. To Run TokenizerTest with arguments:  
  Run > Run Configurations > Arguments  
  and Enter your command line arguments in the Program Arguments box.   
  Then Apply and run.  

or  
Type:  
1. `mkdir bin`  

2. `javac -d bin src/edu/c3341/*.java ` 

3. `cd bin ` 

4. `java edu.c3341.Interpreter ../../../data/test33.txt ../../../data/test33data01.txt print  `

Make sure you have 3 command line arguments:  

the first argument is the program file  
The second argument is the input data file  
The third argument is the print or not print command  

Example of a command:  
`java edu.c3341.Interpreter ../../../data/test33.txt ../../../data/test33data01.txt print  `

## List of file submitted:  
Tokenizer.java :   interface of Tokenizer for Core Interpreter project.  
Tokenizer1.java :  Implements Tokenizer.  
TokenKind.java :   Token kinds needed for the Core Interpreter project.  
TokenizerTest.java :   Test a tokenizer for Core language  
Interpreter.java :    Create an Interpreter for Core language  
Assign.java :  Implementation of parser, printer and executor for assignment  
Comp.java :  Implementation of parser, printer and executor for comparison statement  
CompOp.java :  Implementation of parser, printer and executor for comparison assignment  
Cond.java :  Implementation of parser, printer and executor for conditional  
Decl.java :  Implementation of parser, printer and executor for declaration  
DeclSeq.java :   Implementation of parser, printer and executor for declaration sequence  
Exp.java :   Implementation of parser, printer and executor for expression  
Id.java :  Implementation of parser, printer and executor for identifier  
IdList.java :  Implementation of parser, printer and executor for identifier list  
If.java :  Implementation of parser, printer and executor for if statement  
In.java :  Implementation of parser, printer and executor for read/input  
Loop.java :  Implementation of parser, printer and executor for while loop  
No.java :  Implementation of parser, printer and executor for digit  
Op.java :  Implementation of parser, printer and executor for operation  
Out.java :   Implementation of parser, printer and executor for write/output  
Prog.java :  Implementation of parser, printer and executor for beginning of the program  
Stmt.java :  Implementation of parser, printer and executor for statement  
StmtSeq.java :   Implementation of parser, printer and executor for statement sequence  
Trm.java :   Implementation of parser, printer and executor for term  
