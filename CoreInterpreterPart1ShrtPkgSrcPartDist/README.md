# Project Description
## Introduction
- The goal of this project is to implement an interpreter for the programming language *Core* using Java.   
- The Interpreter was designed to accomplish four main functions: 
    - tokenize input 
    - parse the tokenized input 
    - print the inputted code with correct spacing and blocks 
    - and finally execute the program. 
- The Interpreter could take input files and tokenize the inputted CORE code from said files. It would then use those tokens to parse it using a recursive decent parser that could error check and output useful errors to the user. 
- The CORE program then could be executed and return the appropriate output back to the user.

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
