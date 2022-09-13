import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BinerDeling {
   
    int[] A = new int[24];  // størrelsen avhenger av størrelsen på input

    public static void main (String[] args) throws IOException
    {
        BinerDeling binerdeling = new BinerDeling();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int i = 0;
        while (input != null)
        {
            int z = Integer.parseInt(input);
            binerdeling.A[i] = z;
            i++;
            input = br.readLine();
        }

        binerdeling.dele(binerdeling.A, 0, binerdeling.A.length - 1);
    }

    void dele(int[] A, int bakerste, int fremste)
    {
        if ((fremste - bakerste) < 2)
        {
            System.out.println(A[fremste]);
            System.out.println(A[bakerste]);
            return;
        }
        System.out.println(A[(fremste + bakerste) / 2]);
        int nyBak = ((bakerste + fremste) / 2) + 1;
        dele(A, nyBak, fremste);
        nyBak = bakerste;
        fremste = ((bakerste + fremste) / 2) - 1;
        dele(A, nyBak, fremste);
    }
}