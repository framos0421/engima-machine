public class Swap {
    int counter;
    int counter2 = 0;
    static int counter3 = 0; // static, is a class variable

    public int swap(int[] arr, int start_index) {
        while (start_index < arr.length - 1) {
            int counter = 0;
            if (arr[start_index] > arr[start_index + 1]) {
                counter = counter + 1;
                int temporary = arr[start_index];
                arr[start_index] = arr[start_index + 1];
                arr[start_index + 1] = temporary;
                //this.counter = counter;
                //counter = counter + 1;
                //counter2 = counter2 + 2;
                //counter3 = counter3 + 1;
            }
            this.counter = counter;
            start_index = start_index + 1;
        }
        System.out.println("Swapped " + this.counter + " times.");
        return this.counter;
    }

    public static void main(String[] args) {
        Swap s = new Swap();
        int[] arr = {3, 2, 6, 1, 4};
        s.swap(arr, 0); // Should be 3
        s.swap(arr, 0); // Should be 1
    }
}

