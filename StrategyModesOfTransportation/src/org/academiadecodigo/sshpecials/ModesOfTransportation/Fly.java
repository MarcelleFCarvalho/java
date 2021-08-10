package org.academiadecodigo.sshpecials.ModesOfTransportation;

public interface Fly {

    String fly();
}

class CanFly implements Fly{

    @Override
    public String fly() {
        return "I can fly!";
    }
}

class CannotFly implements Fly{

    @Override
    public String fly() {
        return "I can't fly!";
    }
}


