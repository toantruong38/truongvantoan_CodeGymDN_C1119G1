public class GenericDemo
{
    private static class Test<G>
    {
        private Object elements[]=new Object[10];

        private int length=0;

        public G get(int i)
        {
            return (G)this.elements[i];
        }
        public void add(G ele)
        {
            this.elements[length++]=ele;
        }
    }
    public static void main(String[]args)
    {
        Test<Integer> test=new Test<>();

        test.add(3);
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        for(int i=0;i<test.length;i++)
        {
            System.out.println(test.get(i));
        }
    }
}
