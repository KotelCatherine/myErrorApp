package ru.geekbrains;

import ru.geekbrains.MyException.MyArrayDataException;
import ru.geekbrains.MyException.MyArraySizeException;

public class Programm {

    private static final int SIZE_STRING = 4;
    private static final int SIZE_COLUMN = 4;

    public static void main(String[] args){
        String[][] stringArray;
        int sum = 0;

        stringArray = new String[][]{
                {"1", "2", "3", "4"},
                {"8", "7", "6", "5"},
                {"9", "10", "qw", "12"},
                {"16", "15", "14", "13"}
        };

        try {
            sum = sumArray(stringArray);
        } catch (MyArrayDataException ex) {
            System.err.println("Error converting a string to a number in: " + "[" + ex.getNumberString() + "]" + "[" + ex.getNumberColumn() + "]");
        } catch (MyArraySizeException ex) {
            System.err.println("Array size error");
        }

        System.out.println("Sum of array elements: " + sum);

    }

    private static int sumArray(String[][] stringArray) throws MyArrayDataException, MyArraySizeException {
        arraySize(stringArray);

        int sum = 0;

        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j, stringArray[i][j]);
                }
            }
        }

        return sum;
    }

    private static void arraySize(String[][] stringArray) throws MyArraySizeException {
        int countString = 0;

        for (int i = 0; i < stringArray.length; i++) {
            countString++;
            int countColumn = 0;
            for (int j = 0; j < stringArray[i].length; j++) {
                countColumn++;
            }

            if (countColumn != SIZE_COLUMN) {
                throw new MyArraySizeException("Array size more or little");
            }
        }

        if (countString != SIZE_STRING) {
            throw new MyArraySizeException("Array size more or little");
        }
    }
}