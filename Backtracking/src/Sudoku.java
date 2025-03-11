public class Sudoku {
    
    int[][] sudoku = {
        {6, 0, 0, 7, 4, 5, 0, 0, 0},
        {0, 5, 0, 0, 3, 2, 0, 4, 0},
        {4, 8, 0, 1, 9, 6, 0, 7, 3},
        {5, 1, 4, 0, 0, 0, 9, 6, 2},
        {0, 0, 0, 7, 0, 2, 0, 1, 8},
        {8, 2, 0, 5, 0, 0, 0, 0, 4},
        {0, 0, 0, 0, 2, 0, 0, 0, 0},
        {2, 6, 9, 8, 0, 0, 0, 3, 0},
        {0, 0, 0, 0, 1, 3, 0, 8, 0}
    };
    
    
    public static void main(String[] args) throws Exception {
        new Sudoku();
    }

    public Sudoku() {
        loese(0,0);
        printSudoku();
    }

    public void printSudoku() {
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------"); // Horizontal separator after every 3 rows
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| "); // Vertical separator after every 3 columns
                }
                System.out.print((sudoku[row][col] == 0 ? "·" : sudoku[row][col]) + " ");
            }
            System.out.println();
        }
    }

    public void loese(int row, int col) {
        if (row == 9 && col == 0) return;
        if (sudoku[row][col] != 0) loese(row + ((col + 1) / 9), (col + 1) % 9);
        else for (int i = 1; i <= 9; i++) {
            if (isPossible(i, row, col)) {
                sudoku[row][col] = i;
                loese(row + ((col + 1) / 9), (col + 1) % 9);
            }
            sudoku[row][col] = 0;
        }
    }
            
    private boolean isPossible(int num, int row, int col) {
        for (int i = 0; i < 8; i++) {
            if (sudoku[row][i] == num) return false;
            if (sudoku[i][col] == num) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[((row/3)*3)+i][((col/3)*3)+j] == num) return false;
            }
        }
        return true;
    }

}
