package be.technifutur.sudoku.sudokusamourai;

import be.technifutur.sudoku.Model;
import be.technifutur.sudoku.Vue;
import be.technifutur.sudoku.sudoku4x4.Model4x4;
import be.technifutur.sudoku.utility.Cellule;
import be.technifutur.sudoku.utility.DoublonException;
import be.technifutur.sudoku.utility.LockException;
import be.technifutur.sudoku.utility.SudokuPositionException;

public class VueSamourail implements Vue {
    private String grilleExtSamourai = "";
    private String grilleComplete = """
    +-------+-------+-------+       +-------+-------+-------+
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    +-------+-------+-------+       +-------+-------+-------+
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    +-------+-------+-------+-------+-------+-------+-------+
    | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
    | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
    | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
    +-------+-------+-------+-------+-------+-------+-------+
                    | . . . | . . . | . . . |
                    | . . . | . . . | . . . |
                    | . . . | . . . | . . . |
    +-------+-------+-------+-------+-------+-------+-------+
    | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
    | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
    | . . . | . . . | . . . | . . . | . . . | . . . | . . . |
    +-------+-------+-------+-------+-------+-------+-------+
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    +-------+-------+-------+       +-------+-------+-------+
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    | . . . | . . . | . . . |       | . . . | . . . | . . . |
    +-------+-------+-------+       +-------+-------+-------+
    """;

    public String getGrilleExt(){
        return this.grilleExtSamourai;
    }

    @Override
    public String getGrilleVide(){

        return this.grilleComplete;
    }

    @Override
    public String getGrille(Model model) throws DoublonException {
        String grille = this.getGrilleVide().replace(".", "%s");
        Character[] tab = new Character[441];
        int line = 21;
        int column = 21;
        int posTab = 0;
        try {
            for (int l = 0; l < line; l++) {
                for (int c = 0; c < column; c++) {
                    if (model.getValue(l, c) != ModelSamourai.EMPTY){
                        tab[posTab] = model.getValue(l, c);
                    } else {
                            tab[posTab] = '.';
                    }
                    posTab = posTab + 1;
                }
            }
        } catch (SudokuPositionException e) {
            throw new RuntimeException(e);
        }
        return String.format(grille,tab);
    }
}
