package OOP_Java_Seminar_1.Units;

public class Witch extends Mage {

    public Witch(String name) {
        super(name, 1, 100, 30, 1000, new int[] { 2, 5 }, 1, 3, 3, 4, 15);

    }

    public void getInfoType() {
        System.out.println(super.getInfo());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}