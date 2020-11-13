import java.util.List;
import java.util.ArrayList;

/**
 * Finds the number of possible valid solutions for 'eight queens' problem.
 * 
 * @author Rachel Lowy
 * @version 30 Oct 2016
 */
public class EightQueens {
    
    /**
     * Runs several different board configurations for the 8 queens problem and prints 
     * number of solutions fo each configuratino.
     * 
     */
    public static void main (String[] args) {
        Board board8 = new Board(8);
        System.out.println("8 Queens: " + solve(board8));

        Board board4 = new Board(4);
        System.out.println("4 Queens: " + solve(board4));

        Board board10 = new Board(10);
        System.out.println("10 Queens: " + solve(board10));
        
        Board board2 = new Board(2);
        System.out.println("2 Queens: " + solve(board2));

    }
    
    /**
     * Client code for solving eight queens problem
     * 
     * @param  board   A chess board object
     * @return int     Number of solutions to queen puzzle for 'board' size chess board
     * 
     */
    public static int solve(Board board) {
        return explore (board, 1, 1, 0);
    }

    /**
     * Private code that finds and adds up the total number of solutions to queens problem
     * for an inputted board.
     * 
     * @param   board       A chess board object
     * @param   row         Current row being evaluated
     * @param   column      Current column being evaluated
     * @param   solutions   Number of solutions known
     * 
     * @return  Total number of solutions for this board
     * 
     */
    private static int explore(Board board, int row, int column, int solutions) {
        //base case - finds safe spaces for the last queen to be placed
        if (column == board.size()) {
            
            //finds safe spaces in last column for current board configurations
            for (row = 1; row <= board.size(); row++) {
                if (board.safe(row, column)) {
                    //increases number of solution for each safe board space
                    solutions += 1;
                }          
            }
            return solutions;
        } else {
            //recursive case - looks for safe places for each queen up to the last column
            for (row = 1; row <= board.size(); row++) {
                if (board.safe(row, column)) {
                    //places queen in safe place
                    board.place(row,column);
                    
                    //continues exploring board for subsequent queens
                    solutions = explore(board, row, column + 1, solutions);                    
                    
                    //removes queen so other options for this column can be explored
                    board.remove(row,column);
                }                                
            }
            
            //advances recursion
            explore(board, 1, column+1, solutions);
        }        
        return solutions;
    }

}
