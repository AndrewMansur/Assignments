public class ReversibleArray<T> {

    private T[] array;
    private int count;

    public ReversibleArray(T[] arr) {
        array = arr;
        count = arr.length;
    }

    public void reverse() {
        int middle = count / 2;
        for (int i = 0; i < middle; i++) {
            int j = count - i - 1;
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(array[i]);
            if (i != count - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
