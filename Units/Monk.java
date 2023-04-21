package OOP_Java_Seminar_1.Units;

public class Monk extends Mage {

    public Monk(String name) {
        super(name, 1, 100, 30, 1000, new int[] { 1, 5 }, 1, 3, 3, 5, 20);

    }

    public void getInfoType() {
        System.out.println(super.getInfo());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}