package be.technifutur.sudoku;

import be.technifutur.sudoku.sudoku4x4.Model4x4;
import be.technifutur.sudoku.sudoku4x4.Vue4x4;
import be.technifutur.sudoku.sudoku9x9.Model9x9;
import be.technifutur.sudoku.sudoku9x9.Vue9x9;
import be.technifutur.sudoku.sudokusamourai.ModelSamourai;
import be.technifutur.sudoku.sudokusamourai.VueSamourail;
import be.technifutur.sudoku.utility.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class SudokuReader {

    private Model sudokuReaderModel;
    private Vue sudokuRedearVue;

    public void read(String pathName) throws FileNotFoundException {
        File sudokuFile = new File(pathName);
        try(Scanner fileScanner = new Scanner(sudokuFile)){
            if(fileScanner.hasNextLine()){
                String titleSudoku = fileScanner.nextLine();
                this.sudokuReaderModel = this.getModel(titleSudoku);
                this.sudokuRedearVue = this.getVue(titleSudoku);
                System.out.println("Sudoku " + titleSudoku);
                for(int l = 0; fileScanner.hasNextLine(); l++){
                    String sudokuData = fileScanner.nextLine();
                    for(int c = 0; c < sudokuData.length(); c++){
                        if(sudokuData.charAt(c) != '.'){
                            try{
                                this.sudokuReaderModel.addValue(sudokuData.charAt(c), l, c);
                            } catch ( SudokuValueException | SudokuPositionException | LockException |
                                     DoublonException e) {
                                System.out.println("Erreur dans le fichier");
                            }
                        }
                    }
                }
                this.sudokuReaderModel.lock();
                try{
                    System.out.println(this.sudokuRedearVue.getGrille(this.sudokuReaderModel));
                } catch ( DoublonException e){
                    System.out.println(e.getMessage());
                }
            }
          } catch (FileNotFoundException e){
            System.out.println("Fichier non trouvé");
        }
    }

    public Optional<Model> getModel(){
        Optional<Model> model = Optional.of(this.sudokuReaderModel);
        return model;
    }

    public Optional<Vue> getVue(){
        Optional<Vue> vue = Optional.of(this.sudokuRedearVue);
        return vue;
    }

    private Model getModel(String type){
        Model model;
        switch(type){
            case "4x4":
                model = new Model4x4();
                break;
            case "9x9":
                model = new Model9x9();
                break;
            case "samourai":
                model = new ModelSamourai();
                break;
            default:
                model = null;
                break;
        }
        return model;
    }

    private Vue getVue(String type){
        Vue vue;
        switch(type){
            case "4x4":
                vue = new Vue4x4();
                break;
            case "9x9":
                vue = new Vue9x9();
                break;
            case "samourai":
                vue = new VueSamourail();
                break;
            default:
                vue = null;
                break;
        }
        return vue;

    }
}
