package be.technifutur.sudoku;

import be.technifutur.sudoku.sudoku4x4.Model4x4;
import be.technifutur.sudoku.utility.DoublonException;

public interface Vue {
    public abstract String getGrilleVide();
    public abstract String getGrille(Model model) throws DoublonException;
}
