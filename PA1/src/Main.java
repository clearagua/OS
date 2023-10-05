import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 20;
        int[] master = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            master[i] = rand.nextInt(1000) + 1;
            System.out.print(master[i] + " ");
        }
        System.out.println();

        ST st = new ST(0, master.length-1, master);
        st.start();

        for (int i = 0; i < size; i++) {
            System.out.print(master[i] + " ");
        }
    }
}