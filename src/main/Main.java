package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        double a = 0.7;
        double b = 0.005;
        double x = 0.5;
        double R = calculateR(a,b,x);
        double s = calculateS(a,b,x);
        print(R, s);
        printDate();
    }

    private void printDate() {
        LocalDate now = LocalDate.now();
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MMMM-dd cccc").format(now));
    }

    private void print(double r, double s) {
        System.out.println("r = " + r);
        System.out.println("s = " + s);
        System.out.printf("r = %6.3f\n", r);
        System.out.printf("s = %-6.2f\n", s);
    }

    private double calculateS(double a, double b, double x) {
        double t = x+b;
        double cos = Math.cos(t*t*t);
        return Math.sqrt(x*b/a)+cos*cos;
    }

    private double calculateR(double a, double b, double x) {
        double sin = Math.sin(x+a);
        return x*x*(x+1)/b-sin*sin;
    }
}
