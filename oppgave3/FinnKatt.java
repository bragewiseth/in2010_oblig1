import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FinnKatt {
    
    public static void main(String[] args) throws IOException
    {
        FinnKatt f = new FinnKatt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linje = br.readLine();
        String[] data = linje.split(" ");
        int c = Integer.parseInt(linje);
        Node z = new Node(c,c);
        
        f.settInn(z);
        
        while (true)
        {
            data = br.readLine().split(" ");
            if (data[0].equals("-1")) { break; }
            for (int i = 0; i < data.length; i++)
            {
                Node n = new Node(Integer.parseInt(data[0]),Integer.parseInt(data[i]));
                f.settInn(n);
            }
        }
        f.printVei(f.tre[z.element]);
    }
    
    Node[] tre = new Node[100];
    
    void settInn(Node z)
    {   
        if (tre[z.element] == null) 
        {     
            tre[z.element] = z;
            return; 
        }
        if (tre[z.element].element == z.element & z.element == z.parrent) { return; }
        tre[z.element] = z;
    }
    
    void printVei(Node z)
    {
        System.out.print(z.element + " ");
        if (z.parrent == z.element) { return; }
        printVei(tre[z.parrent]);
    }
        
    static class Node
    {
        int element;
        int parrent;
    
        Node(int p, int e)
        {
            parrent = p;
            element = e;
    
        }
    }
}
