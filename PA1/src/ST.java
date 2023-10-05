public class ST extends Thread {
    private int start;
    private int end;
    private int[] array;

    ST(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    public void run() {
        sort();
    }

    private void sort() {
        int size = this.array.length;

        for (int i = 0; i < size-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < size; j++) {
                if (this.array[j] < this.array[i]) {
                    minIdx = j;
                }
            }

            int temp = this.array[minIdx];
            this.array[minIdx] = this.array[i];
            this.array[i] = temp;
            
        }
    }

}
