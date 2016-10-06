public class RationalTester {

public static void main(String[] args) throws Exception {
Rational r1 = new Rational(3, -12);
Rational r2 = new Rational(11, 22);

Rational rSum, rDiff, rProd, rQuot, rRecip;
System.out.println("First rational number: " + r1);
System.out.println("Second rational number: " + r2);

if (r1.equals(r2))
System.out.println("r1 and r2 are equal.");
else
System.out.println("r1 and r2 are not equal.");

if (r1.compareTo(r2) < 0)
System.out.println("r1 is less than r2.");
else if (r1.compareTo(r2) > 0)
System.out.println("r1 is greater than r2.");
else
System.out.println("r1 and r2 are equal.");

rRecip = r1.getReciprocal();
System.out.println("The reciprocal of r1 is: " + rRecip);

rSum = r1.add(r2);
rDiff = r1.subtract(r2);
rProd = r1.multiply(r2);
rQuot = r1.divide(r2);

System.out.println("r1 + r2: " + rSum);
System.out.println("r1 - r2: " + rDiff);
System.out.println("r1 * r2: " + rProd);
System.out.println("r1 / r2: " + rQuot);
}
}