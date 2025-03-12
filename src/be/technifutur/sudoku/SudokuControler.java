package be.technifutur.sudoku;

import be.technifutur.sudoku.utility.DoublonException;
import be.technifutur.sudoku.utility.LockException;
import be.technifutur.sudoku.utility.SudokuPositionException;
import be.technifutur.sudoku.utility.SudokuValueException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SudokuControler {

    private char chosenValue;
    private int chosenLine;
    private int chosenColumn;
    private Pattern format = Pattern.compile("(\\d)\\.(\\d+)\\.(\\d+)");
    private Vue vueSudoku;
    private Model modelSudoku;

    public char getChosenValue(){
        return this.chosenValue;
    }
    public int getChosenLine(){
        return this.chosenLine;
    }
    public int getChosenColumn(){
        return this.chosenColumn;
    }

    public SudokuControler(Model model, Vue vue) {
        this.vueSudoku = vue;
        this.modelSudoku = model;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        //System.out.println(vueSudoku.getGrilleVide());
        System.out.println("Entrez la valeur, ainsi que la ligne et la colonne où elle sera placée, ou entrez 'q' pour quitter.");
        System.out.println("Valeur (Entrez . pour enlever une valeur) : ");
        String valueToConvertToChar = scan.nextLine();
        while (!valueToConvertToChar.equals("q")) {
            try{
                if(valueToConvertToChar.equals(".")){
                    this.chosenValue = Model.EMPTY;
                } else {
                    this.chosenValue = valueToConvertToChar.charAt(0);
                }
                System.out.println("Ligne : ");
                this.chosenLine = Integer.parseInt(scan.nextLine());
                this.chosenLine = this.chosenLine - 1;
                System.out.println("Colonne : ");
                this.chosenColumn = Integer.parseInt(scan.nextLine());
                this.chosenColumn = this.chosenColumn - 1;
                this.modelSudoku.addValue(chosenValue, chosenLine, chosenColumn);
                //this.modelSudoku.lock();
                //System.out.println(this.modelSudoku.getValue(chosenLine, chosenColumn));
                System.out.println(vueSudoku.getGrille(modelSudoku));
            } catch(SudokuValueException | SudokuPositionException | LockException | DoublonException e){
                System.out.println(e.getMessage());
            }
            System.out.println("Entrez la valeur, ainsi que la ligne et la colonne où elle sera placée, ou entrez 'q' pour quitter.");
            System.out.println("Valeur (Entrez . pour enlever une valeur) : ");
            valueToConvertToChar = scan.nextLine();
        }
        System.out.println("Application quittée.");
    }
}
