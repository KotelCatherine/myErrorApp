package ru.geekbrains.MyException;

public abstract class MyException extends Exception {

    private int numberString;
    private int numberColumn;


    public MyException(int numberString, int numberColumn, String message) {
        super(message);
        this.numberString = numberString;
        this.numberColumn = numberColumn;
    }

    public MyException(String message) {
        super(message);
    }

    public int getNumberString() {
        return numberString;
    }

    public int getNumberColumn() {
        return numberColumn;
    }
}
