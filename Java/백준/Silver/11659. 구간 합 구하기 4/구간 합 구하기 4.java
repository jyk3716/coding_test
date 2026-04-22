import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCount = Integer.parseInt(st.nextToken());
        int sumCount = Integer.parseInt(st.nextToken());

        int[] SumArr = new int[numCount + 1];
        st = new StringTokenizer(br.readLine());
        for (int p = 1; p <= numCount; p++) {
            SumArr[p] = SumArr[p - 1] + Integer.parseInt(st.nextToken());
        }
        for (int q = 0; q < sumCount; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(SumArr[j] - SumArr[i - 1]);
        }
    }
}
