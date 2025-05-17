public class EvalUtil {
    public static String eval(String expression) {
        class Parser {
            private final String s = expression;
            private int pos = -1;
            private int ch;

            private void nextChar() {
                pos++;
                ch = (pos < s.length()) ? s.charAt(pos) : -1;
            }

            private boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            private double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < s.length()) {
                    throw new RuntimeException("Unexpected character: '" + (char) ch + "'");
                }
                return x;
            }

            private double parseExpression() {
                double x = parseTerm();
                while (true) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            private double parseTerm() {
                double x = parseFactor();
                while (true) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) {
                        double denominator = parseFactor();
                        if (denominator == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        x /= denominator;
                    } else return x;
                }
            }

            private double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;

                if (eat('(')) {
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing closing parenthesis ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    String numberStr = s.substring(startPos, this.pos);
                    x = Double.parseDouble(numberStr);
                } else {
                    throw new RuntimeException("Unexpected character: '" + (char) ch + "'");
                }

                return x;
            }
        }

        try {
            double result = new Parser().parse();
            if (result == (long) result) {
                return Long.toString((long) result);
            } else {
                return Double.toString(result);
            }
        } catch (Exception e) {
            return "Error";
        }
    }
}
