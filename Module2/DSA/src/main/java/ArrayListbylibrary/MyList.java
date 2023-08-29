package ArrayListbylibrary;

public class MyList {
    private int size=0;
    private static final int DEFAULT_CAPACITY=10;
    private Object elements[];

    public MyList() {
    }

    public MyList(int size, Object[] elements) {
        this.size = size;
        this.elements = elements;
    }
}
