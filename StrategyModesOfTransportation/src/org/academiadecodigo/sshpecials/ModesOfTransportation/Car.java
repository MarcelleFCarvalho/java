package org.academiadecodigo.sshpecials.ModesOfTransportation;

public class Car extends ModesOfTransportation{

    public Car(){
        super();
        flyingType = new CannotFly();
    }

    public void StartTheEngine(){
        System.out.println("Vrum! Vrum!"); //It's not an electric car...
    }

}
