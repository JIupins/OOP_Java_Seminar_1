package OOP_Java_Seminar_1.Units;

public class Arbalester extends Shooter {

    public Arbalester(String name) {
        super(name, 1, 100, 30, 1000, new int[] { 2, 6 }, 1, 3, 3, 4, 20);
    }

    public void getInfoType() {
        System.out.println(super.getInfo());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}