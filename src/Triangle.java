
public class Triangle implements Comparable {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("Sides must be positive.");

        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IllegalArgumentException("The sum of any two sides must be greater than the third one.");

        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    public boolean isRightTriangle(){
        return (a*a + b*b == c*c) || (a*a + c*c == b*b) || (b*b + c*c == a*a);
    }

    public String toString(){
        return "<Triangle: a=" + a + ", b=" + b + ", c=" + c + ">";
    }

    public static void main(String[] args) {
        Triangle t1 = new Triangle(3, 4, 5);
        System.out.println(t1);
        System.out.println("Area: " + t1.getArea());
        System.out.println("Perimeter: " + t1.getPerimeter());
        System.out.println("Is right triangle: " + t1.isRightTriangle());

        try{
            Triangle t2 = new Triangle(3, 4, 10);
        } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
        }

        try{
            Triangle t3 = new Triangle(3, 1, -1);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        Triangle t4 = new Triangle(3, 4, 3);
        System.out.println("Area: " + t4.getArea());
        System.out.println("Perimeter: " + t4.getPerimeter());
        System.out.println("Is right triangle: " + t4.isRightTriangle());

    }
}
