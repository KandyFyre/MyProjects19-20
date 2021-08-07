/* 
 *  The following code sees as to whether a given
 *  date is in the past, present, or future.
 * 
 *  @user J Hardy
 */


public class FractionDriver {
	public static void main (String args[])
	{
		Fraction first = new Fraction(1,2);
		Fraction another = new Fraction(1,2);
		Fraction next = new Fraction(1,2);
		
		System.out.println(first.addTwoFractions(another,next));
	}
}



public class Fraction {

	//data members
	private int numerator;
	private int denominator;
	private static int count;
	
	//constructors
	public Fraction()
	{
		numerator=1;
		denominator=1;
		count++;
		reduce();
	}
	
	public Fraction(int myNumerator, int myDenominator)
	{
		numerator=myNumerator;
		denominator=myDenominator;
		count++;
		reduce();
	}
	
	public Fraction(Fraction copy)
	{
		numerator=copy.numerator;
		denominator=copy.denominator;
		count++;
		reduce();
	}
	
	private void reduce()
	   {
			      int common;
			      int top = Math.abs(numerator);
			      int bottom = Math.abs(denominator);
		
			      if (top > bottom)
			         common = common(top, bottom);
			      else
			      {
			    	  if (top < bottom)
			    		  common = common(bottom, top);  
			    	  else
			    		  common = top;
			      }
			      
			      //Both are divided by the same amount to reduce.
			      numerator = numerator / common;
			      denominator = denominator / common;
	   }
	
	private int common(int larger, int smaller)
	   {
	      int factor = smaller;
	      while (smaller != 0) //When smaller is 0, the bottom number is checked.
	      {
	         factor = smaller;
	         smaller = larger % smaller;
	         larger = factor;
	      }
	      return larger; //This returns back to "common" which is what I'm dividing both by this common factor.
	   }
	
	//Here I can make sure I get a common denominator.
	 private int lcd(int denom1, int denom2)
	   {
	      int factor = denom1;
	      while ((denom1 % denom2) != 0)
	         denom1 += factor;
	      return denom1;
	   }

	
	public boolean equals(Object obj)
	{
		Fraction temp = (Fraction) obj;
		return (numerator==temp.numerator)&&
				(denominator==temp.denominator);
	}
	
	//Two fractions are added here:
	public Fraction addFraction(Fraction another)
	{
		Fraction result = new Fraction();
		int denom1 = this.denominator;
		int denom2 = another.denominator;
		int num1 = this.numerator;
		int num2 = another.numerator;
		int common;
		
		//I'm trying to find a common denominator so I can add the fraction.
		if (denom1 > denom2)
	         common = lcd(denom1, denom2);
	      else
	      {
	    	  if (denom1 < denom2)
	    		  common = lcd(denom2, denom1);  
	    	  else
	    		  common = denom1;
	      }
		num1*=common;
		num2*=common;
		result.numerator= num1 + num2;
		result.denominator=common;
		result.reduce();
		return result;
	}
	
	//Two fractions are subtracted here:
	public Fraction subtractFraction(Fraction another)
	{
		Fraction result = new Fraction();
		int denom1 = this.denominator;
		int denom2 = another.denominator;
		int num1 = this.numerator;
		int num2 = another.numerator;
		int common;
		
		//I'm trying to find a common denominator so I can subtract the fraction.
		if (denom1 > denom2)
	         common = lcd(denom1, denom2);
	      else
	      {
	    	  if (denom1 < denom2)
	    		  common = lcd(denom2, denom1);  
	    	  else
	    		  common = denom1;
	      }
		num1*=common;
		num2*=common;
		result.numerator= num1 - num2;
		result.denominator=common;
		result.reduce();
		return result;
	}
	
	//Three fractions are added here:
	public Fraction addTwoFractions(Fraction another, Fraction next)
	{
		Fraction addfirst = new Fraction();
		int denom1 = this.denominator;
		int denom2 = another.denominator;
		int num1 = this.numerator;
		int num2 = another.numerator;
		int common;
		
		//I'm trying to find a common denominator so I can add the fraction.
		if (denom1 > denom2)
	         common = lcd(denom1, denom2);
	      else
	      {
	    	  if (denom1 < denom2)
	    		  common = lcd(denom2, denom1);  
	    	  else
	    		  common = denom1;
	      }
		num1*=common;
		num2*=common;
		addfirst.numerator= num1 + num2;
		addfirst.denominator=common;
		
		Fraction result = new Fraction();
		int denom3 = next.denominator;
		int resultDenom=addfirst.numerator;
		int num3 = next.numerator;
		int resultNum=addfirst.denominator;
		
		//I'm trying to find a common denominator so I can add the fraction.
				if (denom3 > resultDenom)
			         common = lcd(denom3, resultDenom);
			      else
			      {
			    	  if (denom3 < resultDenom)
			    		  common = lcd(resultDenom, denom3);  
			    	  else
			    		  common = denom3;
			      }
		num3*=common;
		resultNum*=common;
		result.numerator= num3 + resultNum;
		result.denominator=common;
		
		result.reduce();
		return result;
	}
	
	//Two fractions are multiplied here:
	public Fraction multiplyFraction(Fraction another)
	{
		Fraction result = new Fraction();
		result.numerator = this.numerator*another.numerator;
		result.denominator = this.denominator*another.denominator;
		result.reduce();
		return result;
	}
		
	//Two fractions are divided here:
	public Fraction divideFraction(Fraction another)
	{
		Fraction result = new Fraction();
		//To divide fractions, you multiply by the reciprocal.
		result.numerator = this.denominator*another.numerator;
		result.denominator = this.numerator*another.denominator;
		result.reduce();
		return result;
	}
	
	public String toString()
	{
		return numerator + "/" + denominator;
	}
	
	public static int returnCount()
	{
		return count;
	}
	
	public int returnNumerator()
	{
		return numerator;
	}
	
	public int returnDenominator()
	{
		return denominator;
	}
	
	public void printProperly()
	{
		if(numerator>denominator)
		{
			int whole;
			whole = numerator/denominator;
			int newnumerator = numerator%denominator;
			if(newnumerator==0)
				System.out.println(whole);
			else
				System.out.println(whole + " " + newnumerator + "/" + denominator);
		}

		else
		{
			if(numerator==denominator)
				System.out.println(numerator/denominator);
			else
				System.out.println(numerator + "/" + denominator);
		}
	}
}
