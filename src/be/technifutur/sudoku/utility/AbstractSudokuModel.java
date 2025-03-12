package be.technifutur.sudoku.utility;

import be.technifutur.sudoku.Model;

import java.util.Arrays;

public abstract class AbstractSudokuModel implements Model{

    private Cellule[][] grille;

    /**
     * Constructeur
     */
    protected AbstractSudokuModel(Cellule[][] grille){
        this.grille = grille;
    }

    /*public static char getEmpty(){
        Cellule emptyCell = new Cellule();
        return emptyCell;
    }*/

    public static char getEmptyCharValue(){
        return EMPTY;
    }

    @Override
    public void addValue(char value, int line, int column) throws SudokuValueException, SudokuPositionException, LockException, DoublonException {
        if(!isValueValid(value)) {
                throw new SudokuValueException(String.format(
                        "la valeur (%s) n'est pas valide",
                        value));
        }else if (!isPositionValid(line, column)) {
            throw new SudokuPositionException(String.format(
                    "la position (%s, %s) n'est pas valide",
                    line,
                    column)
            );
        } else {
            grille[line][column].setValue(value);
        }
    }

    @Override
    public char getValue(int line, int column) throws SudokuPositionException {
        if (!isPositionValid(line, column))
            throw new SudokuPositionException(String.format(
                    "la position (%s, %s) n'est pas valide",
                    line,
                    column)
            );
        return grille[line][column].getValue();
    }

    @Override
    public void lock(){
        for (int line = 0; line < grille.length; line++) {
            for (int column = 0; column < grille[line].length; column++) {
                grille[line][column].lockCell();
               // System.out.println(grille[line][column].getValue()+" "+grille[line][column].isLock());
            }
        }
        System.out.println("coin coin");
    }

    @Override
    public String toString() {
        return "AbstractSudokuModel{" +
                "grille=" + Arrays.deepToString(grille) +
                '}';
    }
}
