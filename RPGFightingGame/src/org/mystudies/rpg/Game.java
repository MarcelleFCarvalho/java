package org.mystudies.rpg;

import java.util.Scanner;

public class Game {

    private Scanner scanner;
    private int goOn;
    private Player player;
    private Computer computer;
    private int level;

    public Game(String name){
        this.goOn = 1;
        this.scanner = new Scanner(System.in);
        this.player = new Player(name);
        this.computer = new Computer();
        this.level = 1;
        init();
    }

    public void battle(){

        while (player.getHpPlayer() > 0) {
            computer.restoreHpComputer(level);

            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("             Enemy " + level);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

            while (checkGameOn()) {
                this.player.printHpPlayer();
                this.computer.printHpComputer();
                playersTurn();
                computersTurn();
            }

            levelUp();
        }
    }

    public void init(){
        while (goOn == 1){
            battle();
            System.out.println("End of game. Would you like to continue? [1] - Yes [2] - No");
            goOn = scanner.nextInt();
            if(goOn == 1){
               resetGame();
            }
        }
    }

    public void hitComputerPunch(){
        int hp = player.getHpPlayer();
        hp -= 2 + (level / 10);
        player.setHpPlayer(hp);
    }

    public void hitComputerKick(){
        int hp = player.getHpPlayer();
        hp -= 3 + (level / 10);
        player.setHpPlayer(hp);
    }

    public void hitComputerSpecial(){
        int hp = player.getHpPlayer();
        hp -= 4 + (level / 20);
        player.setHpPlayer(hp);
    }

    public boolean checkGameOn(){
        if(this.player.getHpPlayer() > 0 && this.computer.getHpComputer() > 0) {
            return true;
        }
        return false;
    }

    public void playersTurn(){

        switch (this.player.playerAttack()) {

            case 1:
                System.out.println(player.getName() + " has punched the adversary.");
                this.computer.computerGetHit(7);
                break;

            case 2:
                System.out.println(player.getName() + " has unleashed a special attack.");

                if(player.getCountSpecialAttack() > 0){
                    this.computer.computerGetHit(20);
                    this.player.setCountSpecialAttack(player.getCountSpecialAttack() -1);
                } else {
                    System.out.println("You don't have any special attack left.");
                }
                break;

            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    public void computersTurn(){
        if (computer.getHpComputer() > 0) {
            TypeOfAttack attackComputer = this.computer.chooseAttack();

            switch (attackComputer) {
                case PUNCH:
                    System.out.println("Your enemy has punched you.");
                    hitComputerPunch();
                    break;
                case KICK:
                    System.out.println("Your enemy has kicked you.");
                    hitComputerKick();
                    break;
                case SPECIAL:
                    System.out.println("Your enemy has used a Special Attack.");
                    hitComputerSpecial();
                    break;
            }

        } else {
            System.out.println("Enemy defeated.");
        }
    }

    public void resetGame(){
        player.setHpPlayer(50);
        player.setCountSpecialAttack(5);
        level = 1;
    }

    public void levelUp(){
        level ++;
        if(level > 10 && player.getHpPlayer() > 0){
            player.restoreLife();
            player.setCountSpecialAttack(player.getCountSpecialAttack() + 1);
        }
    }
}

