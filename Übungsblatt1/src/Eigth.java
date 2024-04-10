public class Eigth {
    public static void main(String[] args) {
        System.out.println("> Wie lang sollen die Arrays werden?");
        System.out.print("> ");
        int length = new java.util.Scanner(System.in).nextInt();

        System.out.println("> Array 1");
        Integer[] array1 = new Integer[length];
        array1 = getArray(length);

        System.out.println("> Array 2");
        Integer[] array2 = new Integer[length];
        array2 = getArray(length);

        Integer[] compute = new Integer[length];
        double result = 0;

        for(int i = 0; i < length; i++)
        {
            compute[i] = array2[i] - array1[i];
            compute[i] = compute[i] * compute[i];
            result += compute[i];
        }
        
        result = Math.sqrt(result);

        System.out.printf("> Result is %.2f.", result);

    }

    public static Integer[] getArray(int length)
    {
        Integer[] array = new Integer[length];

        for(int i = 0; i < length; i++)
        {
            System.out.printf("%d. > ", i + 1);
            int num = new java.util.Scanner(System.in).nextInt();

            array[i] = num;
        }

        return array;
    }
}
