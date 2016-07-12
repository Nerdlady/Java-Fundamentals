package foods;

public abstract class Food {
    protected int points;

    protected void setPoints(int points){
        this.points = points;
    }
    public int getPoints() {
        return points;
    }
}
