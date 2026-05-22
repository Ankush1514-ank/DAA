import java.util.*;

class MergeSort{
    static void divide(int a[], int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;

            divide(a,low,mid);
            divide(a,mid+1,high);

            merge (a,low,mid,high);
        }
    }

    static void merge (int a[],int low, int mid, int high){
        int temp[]=new int[high+1];

        int i=low;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=high) {
            if(a[i]<=a[j])
                temp[k++]=a[i++];
            else 
                temp[k++]=a[j++];
        }

        while (i<=mid){
            temp[k++]=a[i++];
        }

        while (j<=high){
            temp[k++]=a[j++];
        }

        for (int x=0;x<k;x++){
            a[low++]=temp[x];
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter size :");
        int n=sc.nextInt();

        Random r=new Random();
        int a[]=new int[n];

        System.out.println("Elemnts in the array :");

        for (int i=0;i<n;i++){
            a[i]=r.nextInt(1000);
            System.out.print(a[i]+" ");
        }

        long start=System.nanoTime();
        divide(a,0,n-1);
        long end=System.nanoTime();

        double time=(end-start)/1e6;

        System.out.println("Sorted List :");
        for(int i : a){
            System.out.print(i+" ");
        }
        

        System.out.println("\nTime taken :"+time);
        sc.close();
    }
}