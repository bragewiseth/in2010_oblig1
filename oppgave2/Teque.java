import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Teque {

    int[] f,b;
    int f_front, f_back, b_front, b_back;
    int f_size, b_size;
    Teque(int N)
    {
        f = new int[N/2];
        b = new int[N/2];
        f_front = 1;
        f_back = 0;
        b_front = 1;
        b_back = 0;
        f_size = 0;
        b_size = 0;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Teque t = new Teque(N);
        for (int i=0; i<N; i++) 
        {
            String[] data = br.readLine().split(" ");
            if (data[0].equalsIgnoreCase("push_front")) { t.push_front(Integer.parseInt(data[1])); }
            if (data[0].equalsIgnoreCase("push_back")) { t.push_back(Integer.parseInt(data[1])); }
            if (data[0].equalsIgnoreCase("push_middle")) { t.push_middle(Integer.parseInt(data[1])); }
            if (data[0].equalsIgnoreCase("get")) { System.out.println(t.get(Integer.parseInt(data[1]))); }
        }

        // for (int i = 0; i < t.f_size+1; i++)
        // {
        //     System.out.println(t.f[i]);
        // }
        // System.out.println("######");
        // for (int i = 0; i < t.b_size+1; i++)
        // {
        //     System.out.println(t.b[i]);
        // }
    }
    

    int get(int i) 
    {
        if (i < f_size)
        {
            int j = (f_front-1)-i;
            if (j < 0) { return f[(f.length) + j];}
            else { return f[j]; }
        }
        else 
        {   
            int j = (b_front-1) - (i - f_size);
            if (j < 0) { return b[(b.length) + j]; }
            else {return b[j];}
        }
    }


    void push_middle(int x) 
    {
        if (f_size < b_size) 
        {
            f[f_back] = b[b_front-1];
            b[b_front-1] = x;
            f_size++;
            f_back--;
            if (f_back < 0) { f_back = (f.length-1); }
        }
        else 
        {   
            b[b_front] = x;
            b_size++;
            b_front++;
            if (b_front > (b.length-1)) { b_front = 0; }
        }
    }


    void push_back(int x) 
    {
        b[b_back] = x;
        b_back--; b_size++;
        if (b_back < 0) { b_back = (b.length-1); }
        balanser();
    }

    void push_front(int x) 
    {
        f[f_front] = x;
        f_front++; f_size++;
        if (f_front > (f.length -1)) { f_front = 0; }
        balanser();
    }
    
    void balanser()
    {
        int d = f_size - b_size;
        if (d > 1) 
        {
            f_back++;
            b[b_front] = f[f_back];
            f[f_back] = 0;
            b_front++;
            if (b_front > (b.length-1)) { b_front = 0; }
            f_size--;
            b_size++;
        }
        if (d < -1)
        {
            b_front--;
            f[f_back] = b[b_front];
            b[b_front] = 0;
            f_back--;
            if (f_back < 0) { f_back = (f.length-1); }  
            b_size--;
            f_size++;  
        }
    }
}