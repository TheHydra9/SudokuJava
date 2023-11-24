package sudokubacktracking;

/**
 *
 * @author Jaime Miguel Escalante
 */
public class Main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        if (sudoku.solve()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudoku.getBoard()[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("No se encontró una solución.");
        }
    }
}

