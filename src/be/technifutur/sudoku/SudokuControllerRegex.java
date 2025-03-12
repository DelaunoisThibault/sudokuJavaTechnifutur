package be.technifutur.sudoku;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SudokuControllerRegex {

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

    public SudokuControllerRegex(Model model, Vue vue) {
        this.vueSudoku = vue;
        this.modelSudoku = model;
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println(vueSudoku.getGrilleVide());
        System.out.println("Entrez la valeur, ainsi que la ligne et la colonne où elle sera placée, ou entrez 'q' pour quitter.");
        System.out.println("Valeur : ");
        String valueToConvertToChar = scan.nextLine();

            /*this.chosenValue = valueToConvertToChar.charAt(0);
            if(modelSudoku.isValueValid(this.chosenValue)){
                System.out.println("Ligne : ");
                this.chosenLine = Integer.parseInt(scan.nextLine());
                System.out.println("Colonne : ");
                this.chosenColumn = Integer.parseInt(scan.nextLine());
                if(modelSudoku.isPositionValid(this.chosenLine, this.chosenColumn)){
                    this.modelSudoku.addValue(chosenValue,chosenLine,chosenColumn);
                    System.out.println(this.modelSudoku.getValue(chosenLine,chosenColumn));
                    System.out.println(vueSudoku.getGrille(modelSudoku));
                } else {
                    System.out.println("Position invalide");
                }
            } else {
                System.out.println("Valeur invalide");
            }
        }
        } else {
            System.out.println("Application quittée.");
        }*/
    }
}
