public class Third {
    public static void main(String[] args) {
        double first = Double.parseDouble(args[0]);
        double second = Double.parseDouble(args[2]);
        String op = args[1];

        switch(op)
        {
            case "+":
                System.out.printf("Result > %.2f", first + second);
                break;

            case "-":
                System.out.printf("Result > %.2f", first - second);
                break;

            case "*":
                System.out.printf("Result > %.2f", first * second);
                break;

            case "/":
                System.out.printf("Result > %.2f", first / second);
                break;

            default:
                System.out.printf("Operator '%s' is unknown.", op);
                break;
        }
    }
}
