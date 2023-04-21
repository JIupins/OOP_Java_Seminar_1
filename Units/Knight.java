package OOP_Java_Seminar_1.Units;

public class Knight extends Infantryman {

    public Knight(String name) {
        super(name, 1, 100, 50, 1000, new int[] { 1, 4 }, 2, 4, 3, 2, 1);
    }

    public void getInfoType() {
        System.out.println(super.getInfo());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}