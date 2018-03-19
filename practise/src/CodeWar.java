import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeWar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        int m = s.nextInt();
        int a[][] = new int [n][m];
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                a[i][j] = s.nextInt();
            }
        }

        System.out.println(sumZero(a,n,m));
    }

    private static int sumZero(int[][] a, int row, int col) {

        int up = 0, dwn = 0, l = 0, r = 0;
        int res[] = new int[2];
        int max = Integer.MIN_VALUE;

        for (int k = 0; k < col; k++)
        {
            int temp[] = new int[row];
            for (int j = k; j < col; j++)
            {
                for (int i = 0; i < row; i++) {
                    temp[i] += a[i][j];
                }
                boolean sum = sumZero(temp, res, row);
                int e = (res[1] - res[0] + 1) * (j - k + 1);
                if (sum && e > max)
                {
                    up = res[0];
                    dwn = res[1];
                    l = k;
                    r = j;
                    max = e;
                }
            }
        }

        int k =0;

        if (!(up == 0 && dwn == 0 && l == 0 &&
                r == 0 && a[0][0] != 0)) {
            k = (dwn - up + 1) * (r - l + 1);
        }
        return k;
    }

    static boolean sumZero(int temp[],int res[], int n)
    {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0,ml = 0;

        for (int i = 0; i < n; i++)
        {
            sum += temp[i];
            if (temp[i] == 0 && ml == 0)
            {
            res[0] = i;
            res[1] = i;
                ml = 1;
            }
            if (sum == 0)
            {
                if (ml < i + 1)
                {
                    res[0] = 0;
                    res[1] = i;
                }
                ml = i + 1;
            }
            if (map.containsKey(sum))
            {
                int old = ml;
                ml = Math.max(ml, i -map.get(sum));
                if (old < ml)
                {
                res[1] = i;
                res[0] = map.get(sum)+ 1;
                }
            }
            else
                map.put(sum,i);
        }
        return ml != 0;
    }
}