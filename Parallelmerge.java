public class Parallelmerge {

    public static void main(String[] args) throws InterruptedException {
        int []arr= {10,6,4,7,3,1,4,15,7,9,11,5,13,4,0,2,8,7,3,9,2,4,5,16,12,20,1};

        mergethread obj=new mergethread(arr,0,arr.length/2);
        mergethread obj2 = new mergethread(arr,(arr.length/2)+1,arr.length-1);


        obj.start();
        obj2.start();

        obj.join();
        obj2.join();
        mergethread.merge(arr,0,arr.length/2,arr.length-1);

        for (int i = 0 ; i<arr.length; i++){
            System.out.println(arr[i]);
        }


    }
}
