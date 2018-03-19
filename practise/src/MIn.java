import java.util.Scanner;

public class MIn {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t--!=0){
            int n = s.nextInt();
            int k = s.nextInt();
            int q = s.nextInt();
            int min = Integer.MAX_VALUE;
            int seg_size= n/k;
            int c=0;
            int i=0;
            int max =0;
            while(i<n){

                int o =s.nextInt();
                if(max<o){
                    max =o;
                }
                i++;
                if(i%seg_size==0 || c+1==k){
                    if(min>max){
                        min = max;
                    }
                    if(c+1!=k) {
                        c++;
                        max = 0;
                    }
                }

            }
            if(min<q){
                System.out.println(min);
            }else{
                System.out.println("NO");
            }
        }
    }
}