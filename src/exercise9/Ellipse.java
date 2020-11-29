package exercise9;

public class Ellipse {
   private Point startPoint;
   private double a;
   private double b;

   public Ellipse() {
     startPoint = new Point();
     a = 1;
     b = 1;
   }

   public Ellipse(Point startPoint, double a, double b) {
     this.startPoint = startPoint;
     this.a = a;
     this.b = b;
   }

   public Ellipse(Ellipse ellipse) {
     startPoint = ellipse.startPoint;
     a = ellipse.a;
     b = ellipse.b;
   }

   public boolean isValid() {
     return a > 0 && b > 0;
   }

   public void initialize() {
     do {
       startPoint.initialize();
       a = Utils.INPUT.nextDouble();
       b = Utils.INPUT.nextDouble();
     } while(!isValid());
   }

   public double calculatePerimeter() {
     return Math.PI * (3*(a+b) - Math.sqrt((3*a + b) * (a + 3*b)));
   }

   public double calculateArea() {
     return Math.PI * a * b;
   }

   public String getType() {
     return (a == b) ? "Cycle" : "Ellipse";

   }

   public String toString() {
     return String.format("%s-[%s, %s], %s, P=%s, A=%s", startPoint, a, b, getType(), calculatePerimeter(), calculateArea());
   }

   public boolean equals(Ellipse otherEllipse) {
     boolean sameA = Utils.equals(a,otherEllipse.a);
     boolean sameB = Utils.equals(b, otherEllipse.b);
     boolean sameAReversed = Utils.equals(a, otherEllipse.b);
     boolean sameBReversed = Utils.equals(b, otherEllipse.a);

     return (sameA && sameB) || (sameAReversed && sameBReversed);
   }
}
