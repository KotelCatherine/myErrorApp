package ru.geekbrains.MyException;

public class MyArrayDataException extends MyException {

    public MyArrayDataException(int numberString, int numberColumn, String simbl) {
        super(numberString, numberColumn,
                String.format("String doesn't contain a parsable integer. " +
                                "Error in the cell: [%d][%d] \n " + "Incorrect value '%s'", numberString, numberColumn, simbl));
    }
}
