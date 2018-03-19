import java.util.*;

/**
 * Created by priyanka on 16/5/17.
 */
public class Anagram {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int a[] = new int[t];
        ArrayList<Integer> prime = new ArrayList<>();
        ArrayList<Integer> nonPrime = new ArrayList<>();

        while(t--!=0){
            Integer k =scanner.nextInt();
            if(isPrime(k)){
                prime.add(k);
            }else{
                nonPrime.add(k);
            }

        }

        Object p[]= prime.toArray();
        Object np[]= (nonPrime.toArray());
        Arrays.sort(p);
        Arrays.sort(np);
        for(int i=0;i<p.length;i++){
            System.out.print(p[i]+" ");
        }

        for(int i=np.length-1;i>=0;i--){
            System.out.print(np[i]+" ");
        }






    }

    static void rvereseArray(Integer arr[], int start, int end)
    {
        int temp;
        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        rvereseArray(arr, start+1, end-1);
    }

    private static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1)  return false;
        if (n <= 3)  return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n%2 == 0 || n%3 == 0) return false;

        for (int i=5; i*i<=n; i=i+6)
            if (n%i == 0 || n%(i+2) == 0)
                return false;

        return true;
    }




}
