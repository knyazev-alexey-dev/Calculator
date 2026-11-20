import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern INPUT = Pattern.compile("^\\s*([+-]?(?:\\d+(?:[.,]\\d*)?|[.,]\\d+))\\s*([+*/-])\\s*([+-]?(?:\\d+(?:[.,]\\d*)?|[.,]\\d+))\\s*$");
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Введите выражение (например, 2 * 6.5): ");
            Matcher m = INPUT.matcher(in.nextLine());
            if (!m.matches()) { System.out.println("Ошибка формата. Используйте +, -, *, /."); return; }
            double a = number(m.group(1)), b = number(m.group(3)), result;
            switch (m.group(2)) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/": if (b == 0) { System.out.println("Деление на ноль."); return; } result = a / b; break;
                default: throw new AssertionError();
            }
            System.out.println("Результат: " + result);
        }
    }
    private static double number(String value) { return Double.parseDouble(value.replace(',', '.')); }
}
