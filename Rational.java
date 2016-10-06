
public class Rational {

	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator) 
			throws Exception
	{
		this.setNumerator(numerator);
		this.setDenominator(denominator);
		
		if (this.numerator < 0 && this.denominator < 0)
		{
			this.numerator = Math.abs(this.numerator);
			this.denominator = Math.abs(this.denominator);
		}
		
		
		if (this.denominator < 0)
		{
			this.denominator = -this.denominator;
			this.numerator = -this.numerator;
		}
		
		reduce();
		
		if (this.denominator == 0)
			throw new Exception("you can't have zero as your denom. :/");
	}


	@Override
	public String toString() {
		return denominator == 1 ? new Integer(numerator).toString() : numerator + "/" + denominator;
	}


	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	
	public boolean equals(Rational r)
	{
		reduce();
		r.reduce();
		
		return r.numerator == numerator && r.denominator == denominator;
	}
	
	public Rational getReciprocal() throws Exception
	{
		return new Rational(denominator, numerator);
	}
	
	public Rational add(Rational r) throws Exception
	{
		return new Rational(numerator * r.denominator + r.numerator * denominator, r.denominator * denominator);
	}
	
	public Rational subtract(Rational r) throws Exception
	{
		return new Rational(numerator * r.denominator - r.numerator * denominator, r.denominator * denominator);
	}
	
	public Rational multiply(Rational r) throws Exception
	{
		return new Rational(numerator * r.numerator, r.denominator * denominator);
	}
	
	public Rational divide(Rational r) throws Exception
	{
		return new Rational(numerator * r.denominator, r.numerator * denominator);
	}
	
	private int gcf(int a, int b)
	{
		while(a != b) 
		{
	        if(a > b)
	            a -= b;
	        else
	            b -= a;
	    }
		
		return a;
	}
	
	public void reduce()
	{
		int factor = numerator < 0 ? gcf(denominator, -numerator) : gcf(denominator, numerator);
		numerator /= factor;
		denominator /= factor;
	}
	
	public int compareTo(Rational r)
	{
		if (equals(r))
			return 0;
		
		return (((double)numerator / denominator) - ((double)r.numerator / r.denominator)) < 0.0 ? -1 : 1;
	}
	
	
	public static void main(String[] args) throws Exception
	{
		//System.out.println(new Rational(3, 2).add(new Rational(5, 3)));
		Rational r = new Rational(3,-6);
		r.reduce();
		System.out.println(r);
	}
	
}
