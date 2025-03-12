package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.utility.AbstractSudokuModel;
import be.technifutur.sudoku.Model;
import be.technifutur.sudoku.utility.Cellule;
import be.technifutur.sudoku.utility.Zone;

public class Model4x4 extends AbstractSudokuModel implements Model {

    /**
     * Constructeur
     */
    public Model4x4() {
        super(getGrille());
    }

    private static Cellule[][] getGrille(){
        Cellule[][] grille = new Cellule[4][4];
        Zone[] lignes = new Zone[4];
        Zone[] colonnes = new Zone[4];
        Zone[] squares = new Zone[4];
        for(int i = 0; i < 4; i++){
            lignes[i] = new Zone("Ligne " + (i + 1));
            colonnes[i] = new Zone("Colonne " + (i + 1));
            squares[i] = new Zone("Carré " + (i + 1));
        }
        for (int line = 0; line < grille.length; line++) {
            for (int column = 0; column < grille[line].length; column++) {
                Cellule baseCell = new Cellule();
                baseCell.addZone(lignes[line]);
                baseCell.addZone(colonnes[column]);
                baseCell.addZone(squares[( ( ( line / 2 ) * 2 ) + ( column / 2 ) )]);
                grille[line][column] = baseCell;
            }
        }
        return grille;
    }

    @Override
    public boolean isPositionValid(int line, int column) {
        return line >= 0 && line <= 3 && column >= 0 && column <= 3;
    }

    @Override
    public boolean isValueValid(char value){
        int testValue = Character.getNumericValue(value);
        return testValue >= 1 && testValue <= 4 || value == EMPTY ;
    }
}

