package org.academiadecodigo.sshpecials.ModesOfTransportation;

public class ModesOfTransportationPlay {

    public static void main(String[] args) {

        ModesOfTransportation porsche = new Car();

        ModesOfTransportation airbus = new Plane();

        System.out.println("Car: " + porsche.TryToFly());
        System.out.println("Plane: " + airbus.TryToFly());

        porsche.setFlyingAbility(new CanFly());

        System.out.println("Car: " + porsche.TryToFly());

    }
}
