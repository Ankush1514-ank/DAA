class CountingSort
{
    static void countingSort(int arr[])
    {
        int count[] = new int[101];

        for(int i = 0; i < arr.length; i++)
        {
            count[arr[i]]++;
        }

        int index = 0;

        for(int i = 0; i <= 100; i++)
        {
            while(count[i] > 0)
            {
                arr[index] = i;
                index++;

                count[i]--;
            }
        }
    }

    public static void main(String args[])
    {
        int marks[] = {78, 45, 90, 67, 45, 100, 89, 78};

        System.out.println("Before Sorting:");

        for(int x : marks)
        {
            System.out.print(x + " ");
        }

        countingSort(marks);

        System.out.println("\n\nAfter Sorting:");

        for(int x : marks)
        {
            System.out.print(x + " ");
        }
    }
}