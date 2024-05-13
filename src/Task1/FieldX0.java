package x0;

import java.util.Scanner;

public class FieldX0 {

    char[][] field;
    Scanner sc= new Scanner(System.in);
    int size;
    int countWin;

    private void createField() {
        System.out.println("Создайте размер поля.");
        size = sc.nextInt();
        if (size > 3) {
            countWin = size;
        } else {
            countWin = 3;
        }
    }

    void initField() {
        createField();
        this.field = new char[size][size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.field[row][col] = ' ';
            }
        }
        System.out.println("Инициализация поля");
        this.printField();
    }


    void printField() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("  " + (i + 1) + " ");
        }
        System.out.println();
        for (int row = 0; row < this.size; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < this.size; col++) {
                System.out.print("[" + this.field[row][col] + "]");
            }

            System.out.println();

        }
    }

    void setValue(int rowIndex, int colIndex, char ch) {
        this.field[rowIndex][colIndex] = ch;
    }

    boolean isFree(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex > size || colIndex < 0 || colIndex > size) {
            return false;
        } else if (this.field[rowIndex][colIndex] == ' ') {
            return true;
        } else {
            return false;
        }

    }

    boolean isGameOver(char player) {
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                if (isRight(row, col, player)) {
                    return true;
                } else if (isDown(row, col, player)) {
                    return true;
                } else if (isRightDiagonal(row, col, player)) {
                    return true;
                } else if (isLeftDiagonal(row, col, player)) {
                    return true;
                }
            }
        }
        return false;
    }


    boolean isRight(int row, int col, char player) {
        if (col > this.size - this.countWin) {
            return false;
        }
        for (int i = col; i < col + this.countWin; i++) {
            if (this.field[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    boolean isDown(int row, int col, char player) {
        if (row > this.size - this.countWin) {
            return false;
        }
        for (int i = row; i < row + this.countWin; i++) {
            if (this.field[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    boolean isLeftDiagonal(int row, int col, char player) {
        if (row > this.size - this.countWin) {
            return false;
        }
        if (col < this.countWin - 1) {
            return false;
        }
        for (int i = 0; i < this.countWin; i++) {
            int rowToCheck = row + i;
            int colToCheck = col - i;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }
        }
        return true;
    }

    boolean isRightDiagonal(int row, int col, char player) {
        if (col > this.size - this.countWin) {
            return false;
        }
        if (row > this.size - this.countWin) {
            return false;
        }
        for (int i = 0; i < this.countWin; i++) {
            int rowToCheck = row + i;
            int colToCheck = col + i;
            if (this.field[rowToCheck][colToCheck] != player) {
                return false;
            }
        }
        return true;
    }
}
