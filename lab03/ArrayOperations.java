public class ArrayOperations {
    /**
     * Delete the value at the given position in the argument array, shifting
     * all the subsequent elements down, and storing a 0 as the last element of
     * the array.
     */
    public static void delete(int[] values, int pos) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
<<<<<<< HEAD
        for (int i = pos; i < values.length - 1; i += 1){
            values[i] = values[i + 1];
        }
        values[values.length - 1] = 0;
=======
        // TODO: YOUR CODE HERE
>>>>>>> 43ea2f46b4ca435c2dd816136bc9946bee998f18
    }

    /**
     * Insert newInt at the given position in the argument array, shifting all
     * the subsequent elements up to make room for it. The last element in the
     * argument array is lost.
     */
    public static void insert(int[] values, int pos, int newInt) {
        if (pos < 0 || pos >= values.length) {
            return;
        }
<<<<<<< HEAD
        for (int i = values.length - 1; i > pos ; i -= 1){
            values[i] = values[i - 1];
        }
        values[pos] = newInt;
=======
        // TODO: YOUR CODE HERE
>>>>>>> 43ea2f46b4ca435c2dd816136bc9946bee998f18
    }
}
