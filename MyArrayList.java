package MyArrayList;

public class MyArrayList<T> {
    private int length;
    private Object[] data;

    public MyArrayList() {
        length = 0;
        data = new Object[10];
    }

    public MyArrayList(int capacity) throws NegativeArraySizeException {
        length = 0;
        data = new Object[capacity];
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return data.length;
    }

    public void ensureCapacity(int capacity) {
        if (capacity > data.length) {
            Object[] newData = new Object[capacity];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public void shrinkToFit() {
        Object[] newData = new Object[length];
        for (int i = 0; i < length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void set(int index, T value) throws IndexOutOfBoundsException {
        if (index >= length) throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    public void add(T value) {
        if (length == data.length) {
            Object[] newData = new Object[(int)(data.length*1.5)];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[length] = value;
        length++;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= length) throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index >= length) throw new IndexOutOfBoundsException();

        Object[] newData = new Object[data.length];
        int diff = 0; // when i > index, indexes in array changes by 1
        for (int i = 0; i < data.length; i++) {
            if (i == index) {
                diff = 1;
                continue;
            }
            newData[i-diff] = data[i];
        }
        data = newData;
        length--;
    }

    public void clear() {
        for (int i = 0; i < length; i++) {
            data[i] = null;
        }
        length = 0;
    }

    public void printAll() {
        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayList<String> arr = new MyArrayList<String>();
        arr.add("HDD");
        //arr.set(0, "DFD");
        System.out.println(arr.get(0));
        arr.add("FFF");
        arr.printAll();
        System.out.println(arr.getCapacity());
        arr.ensureCapacity(15);
        System.out.println(arr.getCapacity());
        arr.add("SSS");
        arr.printAll();

        arr.remove(1);

        arr.printAll();
        System.out.println(arr.getLength());
        System.out.println(arr.getCapacity());
        arr.add("Hello");
        arr.shrinkToFit();
        arr.printAll();
        System.out.println(arr.getLength());
        System.out.println(arr.getCapacity());
    }
}
