# sudoku-solver
Solves sudoku puzzles
Rules of sudoku:
explicit 
-each row contains each digit1-9
-each column contians each digit1-9
-each box contains each digit1-9
-using these rules, we can solve simple puzzles by simply narrowing down possible values of each empty cell in a loop

implicit(assumed)
-we can assume when there is a sole possible value, that it is the value!
-we can assume that if a possible value exists in a single row in a box, that the value cannot exist in the same row of the boxes right/left of it
-we can assume that if a possible value exists in a single column in a box, that the value cannot exist in the same column of the boxes above/below it


language-Java
working on this project for few weeks now
working on taking in user input
has check in line method 
has check in box method
works for easy puzzles
