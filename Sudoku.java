import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Sudoku PP Divide and Conquer
 * 
 * @author Antonio Macabantad
 */

// 2d arrays are indexed as [row][column] OR y,x
public class Sudoku {
    // checks when only one possible value is left and sets cell value to that

    public static cell[][] makeCell(int[][] grid) {
        cell[][] cellGrid = new cell[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellGrid[i][j] = new cell();
                cellGrid[i][j].value = 0;
                for (int k = 1; k <= 9; k++) {
                    cellGrid[i][j].possibleValues.add((k));
                }

            }
        }
        return cellGrid;
    }


    public static ArrayList<Integer> checkLines(ArrayList<Integer> possibleValues, int[][] grid, int row, int col) {
        // System.out.println(row+" "+col);
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] != 0) {
                possibleValues.remove(Integer.valueOf(grid[row][i]));
            }
            if (grid[i][col] != 0) {
                possibleValues.remove(Integer.valueOf(grid[i][col]));

            }
        }
        // System.out.println(row+" "+col);
        // System.out.println(possibleValues);
        return possibleValues;
    }

    public static ArrayList<Integer> checkBox(ArrayList<Integer> possibleValues, int[][] grid, int row, int col) {
        int blockXpos;
        int blockYpos;
        int xPos;
        int yPos;
        blockXpos = col / 3;
        blockYpos = row / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xPos = j + (blockXpos * 3);
                yPos = i + (blockYpos * 3);
                if (grid[yPos][xPos] != 0) {
                    possibleValues.remove(Integer.valueOf(grid[yPos][xPos]));
                }
            }
        }
        return possibleValues;
    }

    public static boolean containsZero(int[][]grid){
        boolean isZero=false;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j]==0)
                isZero=true;
            }
        }
        return isZero;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int WIDTH = 9;
        final int HEIGHT = 9;
        final int POSSIBLEVALS = 9;
        final int[] POSSIBLEARR = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int cellInt;
        System.out.println("Please input puzzle seaparating cells by commas and rows by semicolons");

        /*
         * int[][] grid = {
         * { 7, 3, 8, 5, 1, 0, 9, 6, 2 },
         * { 0, 4, 9, 3, 0, 7, 0, 0, 5 },
         * { 0, 5, 1, 0, 2, 0, 0, 0, 0 },
         * { 3, 0, 2, 7, 0, 0, 0, 0, 0 },
         * { 0, 0, 6, 4, 0, 2, 7, 5, 3 },
         * { 4, 0, 0, 6, 0, 0, 2, 1, 0 },
         * { 0, 0, 0, 2, 0, 0, 0, 3, 0 },
         * { 0, 0, 0, 0, 3, 0, 6, 4, 0 },
         * { 0, 0, 3, 9, 0, 5, 0, 2, 0 }
         * };
         */
        int[][] grid = {
                { 0, 0, 0, 5, 6, 0, 4, 2, 0 },
                { 6, 0, 7, 3, 0, 2, 9, 0, 5 },
                { 0, 0, 0, 0, 9, 0, 0, 0, 3 },
                { 8, 9, 0, 4, 7, 3, 0, 0, 0 },
                { 7, 0, 6, 8, 5, 1, 0, 0, 9 },
                { 0, 0, 5, 9, 0, 6, 8, 0, 1 },
                { 0, 7, 9, 0, 8, 5, 0, 0, 2 },
                { 0, 0, 2, 0, 0, 4, 0, 0, 0 },
                { 5, 0, 0, 0, 0, 0, 7, 6, 0 }
        };

        cell[][] cellGrid = makeCell(grid);

        boolean game = true;
        // public static ArrayList<Integer> checkLines(ArrayList<Integer>
        // possibleValues, int[][] grid, int row, int col) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        int loops = 0;
        while (game) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (grid[row][col] == 0) {
                        cellGrid[row][col].possibleValues = checkLines(cellGrid[row][col].possibleValues, grid, row,
                                col);
                        cellGrid[row][col].possibleValues = checkBox(cellGrid[row][col].possibleValues, grid, row,
                                col);
                        if (cellGrid[row][col].possibleValues.size() == 1) {
                            grid[row][col] = cellGrid[row][col].possibleValues.get(0);
                        }
                    }

                }
            }
            loops++;
            game=containsZero(grid);
            System.out.println();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }

        }
        System.out.println("This puzzle took "+loops+" to solve.");
    }
}
