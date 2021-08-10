package org.mystudies.rpg;

import java.util.Scanner;

public class Player {

   private int hpPlayer;
   private String name;
   private int countSpecialAttack;

    public Player(String name){
        this.hpPlayer = 50;
        this.name = name;
        this.countSpecialAttack = 5;
    }

    public int playerAttack(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your attack: ");
        System.out.println("[1] - Punch");
        System.out.println("[2] - Special");
        return scanner.nextInt();
    }

    public void printHpPlayer(){
        System.out.println("|----------------------------------|");
        System.out.println("   HP " + this.name + ": " + this.hpPlayer);
        System.out.println("   Special Attacks of " + this.name + ": " + countSpecialAttack);
        System.out.println("|----------------------------------|");
    }

    public void restoreLife(){
        this.hpPlayer += 5;
        if(hpPlayer >= 50){
            this.hpPlayer = 50;
        }
    }

    public String getName() {
        return name;
    }

    public int getHpPlayer() {
        return hpPlayer;
    }

    public void setHpPlayer(int hp) {
        this.hpPlayer = hp;
    }

    public int getCountSpecialAttack() {
        return countSpecialAttack;
    }

    public void setCountSpecialAttack(int countSpecialAttack) {
        this.countSpecialAttack = countSpecialAttack;
    }

}
