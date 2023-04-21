package OOP_Java_Seminar_1.Units;

public class Barbarian extends Infantryman {

    public Barbarian(String name) {
        super(name, 1, 100, 60, 1000, new int[] { 1, 6 }, 1, 6, 2, 1, 1);
    }

    public void getInfoType() {
        System.out.println(super.getInfo());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}