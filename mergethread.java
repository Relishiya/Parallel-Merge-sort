public class mergethread extends Thread {
    int [] a;
    int l,r;

    mergethread(int []a, int l, int r)
    {
        this.a=a;
        this.l=l;
        this.r=r;

    }
    public static int merge(int[]a, int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = a[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = a[m + 1+ j];

       int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                a[k] = L[i];
                i++;
            }
            else
            {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            a[k] = R[j];
            j++;
            k++;
        }
        return n1;
    }

    public void sort (int[] a, int l, int r)
    {
        if (l < r)
        {

            int m = (l+r)/2;

            sort(a,l,m);
            sort(a ,m+1, r);


            merge(a, l, m, r);
        }
    }

    @Override
    public void run(){
        try{
            sort(a,l,r);
            System.out.println(Thread.currentThread().getName());
        }
        catch(Exception e){
            System.out.println("Exception Handled");

        }

    }


}

