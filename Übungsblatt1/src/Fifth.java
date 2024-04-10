public class Fifth {
    public static void main(String[] args) {
        int count = 3000;

        while(count != 4001)
        {
            if((count - 3000) % 9 == 0) System.out.printf("\n");
            System.out.printf("%d ", count++);
        }
    }
}
