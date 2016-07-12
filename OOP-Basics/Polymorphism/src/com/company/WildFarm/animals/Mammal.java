package com.company.WildFarm.animals;

public abstract class Mammal extends Animal {
    protected String livingRegion;
    protected Mammal(String name ,double weight, String livingRegion) {
        super(name,weight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        StringBuilder num = new StringBuilder();
        num.append("").append(this.weight).append("");
        if (num.toString().endsWith(".0")){
           num =num.delete(num.length() -2,num.length());
        }
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getSimpleName())
                .append("[").append(this.name)
                .append(", ").append(num)
                .append(", ").append(this.livingRegion)
                .append(", ").append(this.foodEaten).append("]");
        return builder.toString();
       // return String.format("%s[%s, %s, %s, %d]",this.getClass().getSimpleName(),this.name, this.weight,this.livingRegion,this.foodEaten);
    }
}
