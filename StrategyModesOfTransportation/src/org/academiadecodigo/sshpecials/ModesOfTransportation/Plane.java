package org.academiadecodigo.sshpecials.ModesOfTransportation;

public class Plane extends ModesOfTransportation {

    public Plane(){
        super();
        flyingType = new CanFly();
    }

    public void StartTheEngine(){
        System.out.println("Zummmmmmmmmm!");
    }


}
