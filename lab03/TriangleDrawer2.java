public class TriangleDrawer2 {
    public static void main(String[] args) {
        int row = 0;
        int SIZE = 10;
        int col = 0;
        for (row = 0, SIZE = 10; row < SIZE; row += 1) {
            for (col = 0; col <= row; col += 1) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}