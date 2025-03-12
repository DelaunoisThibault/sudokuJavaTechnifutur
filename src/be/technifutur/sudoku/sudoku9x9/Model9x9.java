package be.technifutur.sudoku.sudoku9x9;

import be.technifutur.sudoku.utility.AbstractSudokuModel;
import be.technifutur.sudoku.Model;
import be.technifutur.sudoku.utility.Cellule;
import be.technifutur.sudoku.utility.Zone;

public class Model9x9 extends AbstractSudokuModel implements Model {

    /**
     * Constructeur
     */
    public Model9x9() {
        super(getGrille());
    }

    private static Cellule[][] getGrille(){
        Cellule[][] grille = new Cellule[9][9];
        Zone[] lignes = new Zone[9];
        Zone[] colonnes = new Zone[9];
        Zone[] squares = new Zone[9];
        for(int i = 0; i < 9; i++){
            lignes[i] = new Zone("Ligne " + (i + 1));
            colonnes[i] = new Zone("Colonne " + (i + 1));
            squares[i] = new Zone("Carré " + (i + 1));
        }
        for (int line = 0; line < grille.length; line++) {
            for (int column = 0; column < grille[line].length; column++) {
                Cellule baseCell = new Cellule();
                baseCell.addZone(lignes[line]);
                baseCell.addZone(colonnes[column]);
                baseCell.addZone(squares[( ( ( line / 3 ) * 3 ) + ( column / 3 ) )]);
                grille[line][column] = baseCell;
            }
        }
        return grille;
    }

    @Override
    public boolean isPositionValid(int line, int column) {
        return line >= 0 && line <= 9 && column >= 0 && column <= 9;
    }

    @Override
    public boolean isValueValid(char value){
        int testValue = Character.getNumericValue(value);
        return testValue >= 1 && testValue <= 9 | testValue == getEmptyCharValue();
    }
}
