import java.util.Scanner;

public class Rational {
    private int num;
    private int denom;

    public Rational(int num, int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int gcd = gcd(num, denom);
        this.num = num / gcd;
        this.denom = denom / gcd;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    public String toString() {
        if (denom == 1) {
            return Integer.toString(num);
        } else {
            return num + "/" + denom;
        }
    }

    public double toDouble() {
        return (double) num / denom;
    }

    public Rational abs() {
        return new Rational(Math.abs(num), Math.abs(denom));
    }

    public Rational add(Rational other) {
        int num = this.num * other.denom + this.denom * other.num;
        int denom = this.denom * other.denom;
        return new Rational(num, denom);
    }

    public Rational subtract(Rational other) {
        return this.add(other.negate());
    }

    public Rational multiply(Rational other) {
        int num = this.num * other.num;
        int denom = this.denom * other.denom;
        return new Rational(num, denom);
    }

    public Rational divide(Rational other) {
        if (other.num == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int num = this.num * other.denom;
        int denom = this.denom * other.num;
        return new Rational(num, denom);
    }

    public Rational negate() {
        return new Rational(-num, denom);
    }

    public boolean equals(Rational other) {
        return this.num == other.num && this.denom == other.denom;
    }

    public boolean lessThan(Rational other) {
        return this.num * other.denom < other.num * this.denom;
    }

    public boolean greaterThan(Rational other) {
        return this.num * other.denom > other.num * this.denom;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter denominator 1: ");
        int denom1 = scanner.nextInt();
        System.out.print("Enter numerator 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter denominator 2: ");
        int denom2 = scanner.nextInt();
        Rational r1 = new Rational(num1, denom1);
        Rational r2 = new Rational(num2, denom2);
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r1 + r2 = " + r1.add(r2));
        System.out.println("r1 - r2 = " + r1.subtract(r2));
        System.out.println("r1 * r2 = " + r1.multiply(r2));
        System.out.println("r1 / r2 = " + r1.divide(r2));
        System.out.println("|r1| = " + r1.abs());
        System.out.println("r1 < r2 ? " + r1.lessThan(r2));
        System.out.println("r1 > r2 ? " + r1.greaterThan(r2));
        scanner.close();
    }
}
