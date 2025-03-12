package be.technifutur.sudoku;

import be.technifutur.sudoku.sudoku4x4.Vue4x4;
import be.technifutur.sudoku.sudoku4x4.Model4x4;
import be.technifutur.sudoku.sudoku9x9.Vue9x9;
import be.technifutur.sudoku.sudoku9x9.Model9x9;
import be.technifutur.sudoku.sudokusamourai.ModelSamourai;
import be.technifutur.sudoku.sudokusamourai.VueSamourail;
import be.technifutur.sudoku.utility.DoublonException;
import be.technifutur.sudoku.utility.LockException;
import be.technifutur.sudoku.utility.SudokuPositionException;
import be.technifutur.sudoku.utility.SudokuValueException;

import java.io.FileNotFoundException;
import java.util.Optional;


public class Main {
    public static void main(String[] args) throws SudokuValueException, SudokuPositionException, LockException, DoublonException {

        SudokuReader sudokuReader = new SudokuReader();
        try{
            sudokuReader.read("modelsudoku4x40001.txt");
            Optional<Model> sudokuModel = sudokuReader.getModel();
            Optional<Vue> sudokuVue = sudokuReader.getVue();
            if(sudokuModel.isPresent() && sudokuVue.isPresent()){
                SudokuControler sudokuControler = new SudokuControler(sudokuModel.get(), sudokuVue.get());
                sudokuControler.start();
            }
        } catch(FileNotFoundException e){
            System.out.println("Fichier non trouvé");
        }

        /*Vue4x4 baseView = new Vue4x4();
        Model4x4 baseModel = new Model4x4();
        Vue9x9 bigView = new Vue9x9();
        Model9x9 bigModel = new Model9x9();
        VueSamourail samouraiView = new VueSamourail();
        ModelSamourai samouraiModel = new ModelSamourai();

        System.out.println("Grille de Sudoku (4x4) :");
        baseView.getGrilleVideFlex();
        System.out.println(" ");
        System.out.println("Grille de Sudoku (9x9) :");
        bigView.getGrilleVideFlex();
        System.out.println(" ");
        System.out.println("Grille de Sudoku (Samourai) :");
        samouraiView.getGrilleVide();

        baseModel.addValue('5', 0, 0);
        baseModel.addValue('4', 0, 3);
        baseModel.addValue('1', 3, 0);
        baseModel.addValue('2', 3, 3);
        baseModel.addValue('7', 1, 1);
        System.out.println(baseView.getGrille(baseModel));

        bigModel.addValue('5', 0, 0);
        bigModel.addValue('6', 4, 6);
        bigModel.addValue('9', 2, 1);
        bigModel.addValue('3', 8, 0);
        bigModel.addValue('4', 0, 8);
        bigModel.addValue('1', 5, 5);
        System.out.println(bigView.getGrille(bigModel));*/

        /*String type = "4x4";
        Model model = getModel(type);
        Vue vue = getVue(type);
         */
    }
}