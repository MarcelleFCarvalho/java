package org.mystudies.rpg;

public class Computer {

    private int hpComputer;

    public Computer() {
        this.hpComputer = 10;
    }

    public TypeOfAttack chooseAttack() {
        return TypeOfAttack.values()[(int) (Math.random() * TypeOfAttack.values().length)];
    }

    public void computerGetHit(int hit){
        this.hpComputer -= hit;
    }

    public void printHpComputer(){
        System.out.println("   HP Enemy: " + this.hpComputer);
        System.out.println("|-----------------------------------|");
    }

    public int getHpComputer() {
        return hpComputer;
    }

    public void restoreHpComputer(int hpComputer) {
        this.hpComputer = 10 + hpComputer;
    }

}
