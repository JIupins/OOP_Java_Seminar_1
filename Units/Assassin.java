package OOP_Java_Seminar_1.Units;

public class Assassin extends Infantryman {

    public Assassin(String name) {
        super(name, 1, 100, 40, 1000, new int[] { 1, 3 }, 1, 2, 5, 3, 1);
    }

    public void getInfoType() {
        System.out.println(super.getInfo());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    
    
}