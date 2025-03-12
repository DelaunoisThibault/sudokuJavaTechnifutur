package be.technifutur.sudoku.utility;

import java.util.Objects;
import java.util.Scanner;

public class Zone {

    private int data;
    private String name;

    public Zone(String name){
        this.name = Objects.requireNonNull(name);
    }

    public int getData(){
        return this.data;
    }

    public void setData(int newData){
        this.data = newData;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "data=" + Integer.toBinaryString(this.getData()) +
                ", name='" + this.getName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Zone zone = (Zone) obj;

        //if(!name.equals(zone.name)) return false;
        //return Objects.equals(data, zone.data);
        return this.name.equals((zone).name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result;
    }

    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int userInput;
        Zone zone = new Zone("zone");
        zone.init();
        System.out.println(zone);
        System.out.println("Définir une valeur à tester : ");
        userInput = Integer.parseInt(scan.nextLine());
        String bineryUserInput = Integer.toBinaryString(userInput);
        System.out.println(bineryUserInput);
    }

    public void init(){
        this.data = 0;
    }

    public boolean isPresent(int userInput){
        String binaryInput = Integer.toBinaryString(userInput);
        String binaryData =  Integer.toBinaryString(this.getData());
        if(binaryInput == (binaryData)){
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return Integer.bitCount(data);
    }

    public boolean contains(int value) {
        return (data & (1 << value-1)) != 0;
    }

    public boolean add(int value){
        int anc = data;
        data |= 1 << (value-1);
        return anc != data;
    }

    public boolean remove(int number){
        int anc = data;
        data &= ~(1 << (number-1));
        return anc != data;
    }

    public int count(){
        return 1;
    }


}
