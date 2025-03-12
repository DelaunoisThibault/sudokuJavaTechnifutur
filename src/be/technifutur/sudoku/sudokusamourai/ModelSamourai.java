package be.technifutur.sudoku.sudokusamourai;

import be.technifutur.sudoku.utility.AbstractSudokuModel;
import be.technifutur.sudoku.Model;
import be.technifutur.sudoku.utility.Cellule;

public class ModelSamourai extends AbstractSudokuModel implements Model {

    /**
     * Constructeur
     */
    public ModelSamourai() {
        super(getGrille());
    }

    private static Cellule[][] getGrille(){
        Cellule[][] grille = new Cellule[21][21];
        for (int line = 0; line < grille.length; line++) {
            for (int column = 0; column < grille[line].length; column++) {
                if(isPositionValidStatic(line, column)){
                    Cellule baseCell = new Cellule();
                    grille[line][column] = baseCell;
                }
            }
        }
        return grille;
    }

    public static boolean isPositionValidStatic(int line, int column){
        return line >= 0 && line <= 21 && column >= 0 && column <= 21
                && !((line >= 0 && line <= 5 || line >= 15 && line < 21) && column >= 9 && column <= 11)
                && !((column >= 0 && column <= 5 || column >= 15 && column < 21) && line >= 9 && line <= 11);
    }

    @Override
    public boolean isPositionValid(int line, int column) {
        return isPositionValidStatic(line, column);
    }

    @Override
    public boolean isValueValid(char value){
        int testValue = Character.getNumericValue(value);
        return testValue >= 1 && testValue <= 9 | testValue == getEmptyCharValue();
    }
}
