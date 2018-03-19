import javax.print.DocFlavor;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Elevator {

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        int t= s.nextInt();

        while(t--!=0){
            int n= s.nextInt();
            int p = s.nextInt();
            long w=s.nextLong();
            int a[]= new int[n-1];
            for(int v=0;v<n-1;v++){
                a[v]=s.nextInt();
            }
            Map<Integer,ArrayList<Integer>> out = new HashMap<>();
            int i=0;
            for( i=0;i<n-1;i++){
                p=p-a[i];
                int fl[]=new int[a[i]];
                int we[]=new int[a[i]];
                for(int l=0;l<a[i];l++){
                    fl[l]=s.nextInt();
                }
                for(int l=0;l<a[i];l++){
                    we[l]=s.nextInt();
                    w=w-we[l];

                }
                for(int l=0;l<a[i];l++){
                    if(out.containsKey(fl[l])){
                        ArrayList<Integer> integers = out.get(fl[l]);
                        integers.add(we[l]);
                        out.replace(fl[l],integers);
                    }
                    else{
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(we[l]);
                        out.put(fl[l],integers);
                    }
                }
                if(out.containsKey(i+1)){
                    ArrayList<Integer> integers = out.get(i+1);
                    p=p+integers.size();
                    long wei=0;
                    for(Integer j : integers){
                        wei = wei+j;
                    }
                    w=w+wei;

                }
                if(w<0||p<0){
                    System.out.println(i+1);
                    break;

                }
            }
            if(i==n-1){
                System.out.println(i+1);
            }
        }

    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}