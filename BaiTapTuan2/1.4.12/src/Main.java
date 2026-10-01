import javax.sound.midi.MidiFileFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc .nextInt();

        int[] a  = new int[n];
        int[] b  = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;

        while (i < n && j < n) {
            if (a[i] < b[j]) {
                i++;
            }
            else if (a[i] > b[j]) {
                j++;
            }
            else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        sc.close();
    }
}