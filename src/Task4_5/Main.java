package Task4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputRow = scanner.nextInt();
        int inputCol = scanner.nextInt();
        MainExcep[][] arr = new MainExcep[3][3];
        if (inputRow == 1 && inputCol == 1) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 1 && inputCol == 2) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 1 && inputCol == 3) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 2 && inputCol == 1) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 2 && inputCol == 2) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 2 && inputCol == 3) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 3 && inputCol == 1) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 3 && inputCol == 2) {
            arr[0][0] = new Exception1();
        } else if (inputRow == 3 && inputCol == 3) {
            arr[2][2] = new Exception9();
        } else {
            throw new Exception10();
        }
        System.out.println(arr[inputRow-1][inputCol-1].toString());


    }


}

//        Exception1 exception1 = new Exception1();
//        Exception2 exception2 = new Exception2();
//        Exception3 exception3 = new Exception3();
//        Exception4 exception4 = new Exception4();
//        Exception5 exception5 = new Exception5();
//        Exception6 exception6 = new Exception6();
//        Exception7 exception7 = new Exception7();
//        Exception8 exception8 = new Exception8();
//        Exception9 exception9 = new Exception9();
//        Exception10 exception10 = new Exception10();
//        RuntimeException[] exceptions = {exception1, exception2, exception3, exception6, exception10, exception7, exception5, exception4, exception8, exception7, exception9};
//        for (int i =0;i< exceptions.length;i++){
//            System.out.println(Arrays.toString(exceptions));
//        }