package org.academiadecodigo.sshpecials.ModesOfTransportation;

public class ModesOfTransportation {
    private String name;
    private int weight;
    private double speed;
    private String model;

    public Fly flyingType;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String TryToFly(){
        return flyingType.fly();
    }

    public void setFlyingAbility(Fly newFlyingType){
        flyingType = newFlyingType;
    }
}
