package be.technifutur.sudoku.utility;

import be.technifutur.sudoku.Model;

import java.util.*;

public class Cellule{
    private char value = Model.EMPTY;
    private boolean lock = false;
    private Set<Zone> setZone = new HashSet<>();

    public char getValue(){
        return value;
    }

    public void setValue(char charValue) throws LockException, DoublonException {

        if( this.value != charValue) {
            if (isLock()) {
                throw new LockException("Cellule verrouillée");
            }
            if( charValue != Model.EMPTY){
                checkDoublon(charValue);
            }
            if(this.value != Model.EMPTY){
                removeValue(this.value);
            }
            if( charValue != Model.EMPTY ){
                addValue(charValue);
            }
            this.value = charValue;
        }
    }

    private void checkDoublon(char charValue)  throws DoublonException{
        int intValue = Character.digit(charValue, 10);
        for(Zone z : setZone){
             if(z.contains(intValue)){
                throw new DoublonException("Doublon dans la ligne, la colonne ou le carré.");
            }
        }
    }

    private void removeValue(char value) {
        int intValue = Character.digit(value, 10);
        for(Zone z : setZone){
            z.remove(intValue);
        }
    }

    private void addValue(char charValue) {
        int intValue = Character.digit(charValue, 10);
        for(Zone z : setZone){
            z.add(intValue);
        }
    }

    public void addZone(Zone zone){
        setZone.add(Objects.requireNonNull(zone));
    }

    public boolean isLock(){
        return lock;
    }

    public void lockCell(){
        this.lock = value != Model.EMPTY;
    }

    public void unlockCell(){
        this.lock = false;
    }

    @Override
    public String toString() {
        return "Cellule{" +
                "value=" + value +
                ", lock=" + lock +
                ", setZone=" + setZone +
                '}';
    }
}
