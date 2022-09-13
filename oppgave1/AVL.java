import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class  AVL {

    class Node 
    {
        int element;
        Node left;
        Node right;
        // int høyde; 

        Node(int e) { element = e; }
    }

    
    int size;
    Node root;
    AVL() { size = 0; }

    Node insert(Node v, int x) 
    {
        if (v == null) 
        { 
            v = new Node(x); 
            this.size++;
        }
        else if (x < v.element) { v.left = insert(v.left, x); }
        else if (x > v.element) { v.right = insert(v.right, x); }
        return v;
    }    

    Boolean contains(Node v, int x)
    {
        if (v == null) { return false; }
        if (x == v.element) { return true; }
        if (x < v.element) { return contains(v.left, x); }
        if (x > v.element) { return contains(v.right, x); }
        return null;
    }

    Node remove(Node v, int x) 
    {
        if (v == null) { return null; }
        if (x < v.element) 
        { 
            v.left = remove(v.left, x); 
            return v;
        }
        if (x > v.element) 
        {
            v.right = remove(v.right, x);
            return v;
        }
        if (v.left == null) 
        {
            this.size--;
            return v.right; 
        }
        if (v.right == null) 
        { 
            this.size--;
            return v.left; 
        }
        Node u = finnMinste(v.right);
        v.element = u.element;
        v.right = remove(v.right, u.element);
        return v;
    }
   
    int size() 
    {
         return this.size; 
    }

    Node finnMinste(Node v)
    {
        if (v.left == null) { return v; }
        else { return finnMinste(v.left); }
    }

    // int høyde(Node v) 
    // {
    //     if (v == null) { return -1; }
    //     return 0;
    // }

    public static void main(String[] args) throws IOException
    {
        AVL tre = new AVL();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) 
        {
            String[] data = br.readLine().split(" ");
            if (data[0].equalsIgnoreCase("insert")) { tre.root = tre.insert(tre.root, Integer.parseInt(data[1])); }
            if (data[0].equalsIgnoreCase("contains")) { System.out.println(tre.contains(tre.root, Integer.parseInt(data[1]))); }
            if (data[0].equalsIgnoreCase("remove")) { tre.root = tre.remove(tre.root, Integer.parseInt(data[1])); }
            if (data[0].equalsIgnoreCase("size")) { System.out.println(tre.size()); }
        }
    }
}