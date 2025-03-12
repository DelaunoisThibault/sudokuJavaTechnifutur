package be.technifutur.sudoku;

import be.technifutur.sudoku.utility.*;

public interface Model {
    public final static char EMPTY = ' ';

    public abstract void addValue(char value, int line, int column) throws SudokuValueException, SudokuPositionException, LockException, DoublonException;
    public abstract char getValue(int line, int column) throws SudokuPositionException;
    public abstract boolean isPositionValid(int line, int column);
    public abstract boolean isValueValid(char value);
    public abstract void lock();
}
