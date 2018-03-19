import java.util.Scanner;

/**
 * Created by priyanka on 14/7/17.
 */
public class Matrix {

    public static void main(String[] args) {
        Matrix m = new Matrix();
        Scanner s = new Scanner(System.in);
        int p = s.nextInt();
        int q = s.nextInt();
        int a[][] = new int[p][q];
        System.out.println(a.length);
        System.out.println(a[0].length);
        for(int i=0;i<p;i++){
            for(int k =0;k<q;k++){
                a[i][k] = s.nextInt();
            }
        }
        m.zeroMatrixWithoutEXtraSpace(a);
    }

    public void zeroMatrixWithoutEXtraSpace(int a[][]){
        boolean rowHasZero=false;
        boolean columHasZero = false;

        for(int i=0;i<a[0].length;i++){
            if(a[0][i]==0){
                rowHasZero=true;
                break;
            }
        }

        for(int i=0;i<a.length;i++){
            if(a[i][0]==0){
                columHasZero =true;
                break;
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    a[i][0]=0;
                    a[0][j]=0;
                }
            }
        }

        for(int i=0;i<a.length;i++){
            if(a[i][0]==0){
                nullifyRow(a,i);
            }
        }
        for(int j=0;j<a[0].length;j++){
            if(a[0][j]==0){
                nullifyCol(a,j);
            }
        }

        if(rowHasZero){
            nullifyRow(a,0);
        }
        if(columHasZero){
            nullifyCol(a,0);
        }
        print(a);
    }

    private void nullifyCol(int[][] a, int i) {
        for(int j=0;j<a.length;j++){
            a[j][i]=0;
        }
    }

    private void nullifyRow(int[][] a, int i) {
        for(int j=0;j<a[0].length;j++){
            a[i][j]=0;
        }
    }

    public void zeroMatrix(int a[][],int m,int n) {
        int row[] = new int[m];
        int column[] = new int[n];
        int x = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0 && x < m && x < n) {
                    row[x] = i;
                    column[x] = j;
                    x++;
                }
            }
        } 

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < n; j++) {
                a[row[i]][j] = 0;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < m; j++) {
                a[j][column[i]] = 0;
            }
        }
        print(a);
    }

    public void print(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
