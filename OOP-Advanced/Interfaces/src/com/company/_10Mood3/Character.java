package com.company._10Mood3;

public class Character<T> implements GameObject<T> {
    private String name;
    private String password;
    private int level;
    private T points;

    public Character(String name, String password, int level, T points) {
   this.setName(name);
        this.setPassword(password);
        this.setLevel(level);
        this.setPoints(points);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setPoints(T points) {
        this.points = points;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getHasedPassword() {
        return this.password;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public T getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"").append(this.getName()).append("\" | \"")
                .append(this.getHasedPassword()).append("\" -> ").append(this.getClass().getSimpleName());
        return builder.toString();
    }
}
