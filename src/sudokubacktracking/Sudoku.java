package sudokubacktracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Sudoku class represents a Sudoku puzzle solver using backtracking
 * algorithm. It contains methods to initialize, solve, and validate the Sudoku
 * puzzle.
 *
 * The puzzle board is represented as a 9x9 integer array, where empty cells are
 * denoted by the value 0.
 *
 * @author Jaime Miguel Escalante
 */
public class Sudoku {

    // Constant representing the size of the Sudoku puzzle (9x9 grid)
    private static final int SIZE = 9;

    // The Sudoku puzzle board
    private int[][] board;

    /**
     * Constructs an instance of the Sudoku class with an empty puzzle board.
     */
    public Sudoku() {
        this.board = new int[SIZE][SIZE];
    }

    /**
     * Solves the Sudoku puzzle using a backtracking algorithm.
     *
     * @return True if a solution is found, false otherwise.
     */
    public boolean solve() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    ArrayList<Integer> numbers = new ArrayList<>();
                    for (int number = 1; number <= SIZE; number++) {
                        numbers.add(number);
                    }
                    Collections.shuffle(numbers);

                    for (int number : numbers) {
                        if (isValid(row, col, number)) {
                            board[row][col] = number;

                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if placing a number at a specific position in the puzzle is valid.
     *
     * @param row The row index.
     * @param col The column index.
     * @param number The number to be placed.
     * @return True if the placement is valid, false otherwise.
     */
    private boolean isValid(int row, int col, int number) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == number || board[row][i] == number) {
                return false;
            }
        }

        int boxRow = row - row % 3;
        int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Gets the current Sudoku puzzle board.
     *
     * @return The Sudoku puzzle board.
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Sets the Sudoku puzzle board to a specified configuration.
     *
     * @param board The new puzzle board configuration.
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }
}
