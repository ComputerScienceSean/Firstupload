import static java.util.Arrays.copyOf;

public class MyArrayList<T> implements MyList {
    private int size = 0;

    private T[] data = (T[]) new Object[10];

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object T) {
        if (size == data.length) {
            T[] array = copyOf(data, data.length + 10);
            data = array;
        }
        data[size] = (T) T;
        size++;
    }

    @Override
    public Object get(int index) {
        if (data[index] != null) {
            return data[index];
        } else {
            return "Invalid input";
        }
    }

    @Override
    public Object remove(int index) {
        Object tempObject = "Invalid input";
        if (index > 0 && index < size) {
            tempObject = data[index];
            for (int i = index; i < size; i++) {
                data[i] = data[i + 1];
            }
        }
        size--;
        return tempObject;
    }


    public String toString() {
        String temp = "";
        for (int i = 0; i > size - 1; i++) {
            temp += data[i];
        }
        temp += data[size - 1];
        return "MyArrayList(" + temp + ")";
    }
}
