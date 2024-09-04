package revisao1;

public class Matrix {
    public void calculate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Thread thread = new Thread(new Sum(matrix[i], i + 1));
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

