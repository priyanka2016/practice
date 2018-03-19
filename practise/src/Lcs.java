public class Lcs {

    public static void main(String[] args) {
       String s="atbdsfg";
       String k = "bzs";
      // lcs(s,k);
        StringBuilder h=new StringBuilder("");
        int l[][] = new int[s.length()+1][k.length()+1];

        System.out.println(lcsMemo(s,k,s.length(),k.length(),l));
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=k.length();j++){
                System.out.print(l[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        lcs(s,k);
    }

    private static int lcs(String s, String k, int n, int m,StringBuilder h) {
        if(n==0||m==0){
            return 0;
        }else if(s.charAt(n-1)==k.charAt(m-1)){
            h.append(s.charAt(n-1));
            return 1+lcs(s,k,n-1,m-1,h);

        }else{
            int t2 = lcs(s,k,n-1,m,h);
            int t1 = lcs(s,k,n,m-1,h);
            return t2>t1?t2:t1;
        }
    }
    private static int lcsMemo(String s, String k, int n, int m,int l[][]) {
        if(n==0||m==0){
            l[n][m]=0;
            return 0;
        }else if(s.charAt(n-1)==k.charAt(m-1)){
           if(l[n-1][m-1]==0) {
               l[n-1][m-1]=1+lcsMemo(s, k, n - 1, m - 1, l);
           }
           return l[n-1][m-1];

        }else{
            if(l[n-1][m]==0){
                l[n-1][m]= lcsMemo(s,k,n-1,m,l);
            }
           if(l[n][m-1]==0){
               l[n][m-1]=lcsMemo(s,k,n,m-1,l);
           }
            return l[n-1][m]>l[n][m-1]?l[n-1][m]:l[n][m-1];
        }
    }


    private static void lcs(String s, String k) {
        int a[][]= new int [s.length()+1][k.length()+1];
        for (int i=1;i<=s.length();i++){
            for(int j=1;j<=k.length();j++){
                if(s.charAt(i-1)==k.charAt(j-1)){
                    a[i][j]=a[i-1][j-1]+1;
                }
                else{
                    a[i][j]=a[i-1][j]>a[i][j-1]?a[i-1][j]:a[i][j-1];
                }
            }
        }
        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=k.length();j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }

    }
}