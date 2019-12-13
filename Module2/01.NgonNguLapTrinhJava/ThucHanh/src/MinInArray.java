public class MinInArray {
    public static void main(String[] args) {
        int int_arr[]=new int[10];
        String result="";
        for(int i=0;i<int_arr.length;i++)
        {
            int_arr[i]=(int)Math.floor(Math.random()*101);
            result+=int_arr[i]+"\n";
        }
        System.out.println(result);
        int index=findMinInArray(int_arr);
        System.out.println("Found "+int_arr[index]+" is min in array, position "+index);
    }
    public static int findMinInArray(int[] array)
    {
        int min=array[0];
        int index=0;
        //String result="";
        for(int i=1;i<array.length;i++)
        {
            if(array[i]<min)
            {
                min=array[i];
                //result="Found "+min+" min in array,position at "+i;
                index=i;
            }
        }
        return index;
    }
}
