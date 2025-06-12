interface Shape {
    double area();
}

public class JavaProgramtouselambdafunctionwithinterface {
    public static void main(String[] args) {
        double radius = 5.0;
        double side = 4.0;
        double base = 6.0;
        double height = 3.0;

        // Lambda expression for Circle
        Shape circle = () -> {
            double area = Math.PI * radius * radius;
            return area;
        };

        // Lambda expression for Square
        Shape square = () -> {
            double area = side * side;
            return area;
        };

        // Lambda expression for Triangle
        Shape triangle = () -> {
            double area = 0.5 * base * height;
            return area;
        };

        System.out.println("Area of Circle: " + circle.area());
        System.out.println("Area of Square: " + square.area());
        System.out.println("Area of Triangle: " + triangle.area());
    }
}



