package revisao1;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        Matrix matrixSum = new Matrix();
        matrixSum.calculate(matrix);
    }
}