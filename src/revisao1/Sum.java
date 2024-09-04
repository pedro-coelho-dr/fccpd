package revisao1;

public class Sum implements Runnable {
    private int[] row;
    private int rowIndex;

    public Sum(int[] row, int rowIndex) {
        this.row = row;
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int num : row) {
            sum += num;
        }
        System.out.println("Soma da linha " + rowIndex + ": " + sum);
    }
}
