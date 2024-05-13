package x0;

import java.util.Scanner;

public class X0Game {
    FieldX0 fieldX0;
    Scanner sc = new Scanner(System.in);
    char nextTurn;
    boolean gameOver = false;

    void newGame() {
        this.fieldX0 = new FieldX0();
        this.fieldX0.initField();
        System.out.println("Игра началась!");
    }

    void play() {
        this.newGame();
        System.out.println("Выберите символ: X and 0");
        char first = this.sc.next().charAt(0);
        if (first == 'X' || first == '0') {
            this.nextTurn = first;
        } else {
            throw new RuntimeException("Вы вели что то не подходящие.");
        }
        while (!gameOver) {
            turn();
            this.gameOver = this.fieldX0.isGameOver(this.nextTurn);
            if (this.gameOver){
                System.out.println(this.nextTurn + " Win");
            }
            if (this.nextTurn == 'X') {
                this.nextTurn = '0';
            } else {
                this.nextTurn = 'X';
            }
        }

    }

    void turn() {
        System.out.println(this.nextTurn + ", Ваш ход");
        System.out.println("Row number: ");
        int rowNum = this.sc.nextInt();
        System.out.println("Column number: ");
        int colNum = this.sc.nextInt();
        int rowIndex = rowNum - 1;
        int colIndex = colNum - 1;
        if (this.fieldX0.isFree(rowIndex, colIndex)) {
            this.fieldX0.setValue(rowIndex, colIndex, nextTurn);
            this.fieldX0.printField();
        } else {
            System.out.println("Ячейка занята. Сделайте еще раз ход.");
            turn();
        }
    }
}
