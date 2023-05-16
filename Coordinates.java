package OOP_Java_Seminar_1;

public class Coordinates {
    protected int x;
    protected int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public float findDistance (Coordinates coordinatesEnemy){
        float dx = this.x-coordinatesEnemy.x;
        float dy = this.y - coordinatesEnemy.y;
        return (float)Math.sqrt(Math.pow(dx,2)+(Math.pow(dy,2)));
    }
    
}
