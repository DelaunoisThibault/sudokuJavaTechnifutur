package be.technifutur.sudoku.sudoku4x4;

import be.technifutur.sudoku.Model;
import be.technifutur.sudoku.Vue;
import be.technifutur.sudoku.utility.*;

public class Vue4x4 implements Vue {
    private String grilleExt4x4 = "+-----+-----+";
    private String grilleInt4x4 = """
            | . . | . . |
            | . . | . . |""";
    private String grilleComplete = """
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+
            | . . | . . |
            | . . | . . |
            +-----+-----+
            """;

    public String getGrilleExt(){
        return this.grilleExt4x4;
    }
    public String getGrilleInt4x4(){
        return this.grilleInt4x4;
    }

    public void getGrilleVideFlex(){

        System.out.println(grilleExt4x4);
        for(int i = 0; i < 3; i++){
            System.out.println(grilleInt4x4);
            System.out.println(grilleExt4x4);
        }
    }

    @Override
    public String getGrilleVide(){
        return this.grilleComplete;
    }

    @Override
    public String getGrille(Model model) throws DoublonException {
        String grille = this.getGrilleVide().replace(".", "%s");
        Character[] tab = new Character[16];
        int line = 4;
        int column = 4;
        int posTab = 0;
        try {
            for (int l = 0; l < line; l++) {
                for (int c = 0; c < column; c++) {
                    if (model.getValue(l, c) != Model4x4.EMPTY){
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
        return String.format(grille, (Object[]) tab);
    }
}
