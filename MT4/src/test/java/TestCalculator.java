import result.Calculator.CalculatorParser;

import java.text.ParseException;

public class TestCalculator {
    public static void main(String[] args) throws ParseException {
//        test("1");
//        test("1 + 1");
//        test("13 + 3 * 2");
//        test("(11 - 1) /  2");
//        test("((1))");
//        testNeg("");
//        testNeg("asdasdasd - 1");
//        test("123 - 121");
        test("81 lg 3");
        test("64 lg 81 lg 3");
        test("3 lg 81");
        test ("-1");
        test ( "64 lg 2 * 81 lg 3");
        test("-- 1");
    }

    private static void test(String str) throws ParseException {
        CalculatorParser parser = new CalculatorParser();
        System.out.println(str + " = " + parser.parse(str).val);
    }

    private static void testNeg(String str) {
        try {
            test(str);
            throw new RuntimeException("WRONG");
        } catch (ParseException e) {
            System.out.println("not parse: " + str);
        }
    }
}
