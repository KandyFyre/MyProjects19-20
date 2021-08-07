/* 
 *  The following code sees as to whether a given
 *  date is in the past, present, or future.
 * 
 *  @user J Hardy
 */

import java.util.Scanner;
import java.util.Date;

public class pastPresentFuture {
	public static void main (String args[])
	{
		//Scanner.
		Scanner sc = new Scanner (System.in);
		
		//input variables
		int year;
		int month;
		int day;
		
		//Current date.
		Date current = new Date();
		String currentTime = new String(current.toString());
		
		//Current year.
		int temp1 = currentTime.indexOf(":");
		String currentYear = currentTime.substring(temp1+1);
		temp1 = currentYear.indexOf(" ");
		currentYear = currentYear.substring(temp1+1);
		temp1 = currentYear.indexOf(" ");
		currentYear = currentYear.substring(temp1+1);
		
		//Current month.
		int temp2 = currentTime.indexOf(" ");
		String currentMonth = currentTime.substring(temp2+1, temp2+4);
		
	    	if(currentMonth.equals("Jan"))
		    currentMonth="1";
		    
		    if(currentMonth.equals("Feb"))
		    currentMonth="2";
		    
		    if(currentMonth.equals("Mar"))
		    currentMonth="3";
		    
		    if(currentMonth.equals("Apr"))
		    currentMonth="4";
		    
		    if(currentMonth.equals("May"))
		    currentMonth="5";
		    
		    if(currentMonth.equals("Jun"))
		    currentMonth="6";
		    
		    if(currentMonth.equals("Jul"))
		    currentMonth="7";
		    
		    if(currentMonth.equals("Aug"))
		    currentMonth="8";
		    
		    if(currentMonth.equals("Sep"))
		    currentMonth="9";
		    
		    if(currentMonth.equals("Oct"))
		    currentMonth="10";
		    
		    if(currentMonth.equals("Nov"))
		    currentMonth="11";
		    
		    if(currentMonth.equals("Dec"))
		    currentMonth="12";
		
		//Current Day
		int temp3 = currentTime.indexOf(" ");
		String currentDay = currentTime.substring(temp1+1);
		temp3 = currentTime.indexOf(" ");
		currentDay = currentDay.substring(temp1+1, temp1+3);
		
		// Converting all strings to Integers.
		int thisYear = new Integer (currentYear);
		int thisMonth = new Integer (currentMonth);
		int thisDay = new Integer(currentDay);
		
		//Months ( They are assigned numbers. )
		int january = 1;
		int february = 2;
		int march = 3;
		int april = 4;
		int may = 5;
		int june = 6;
		int july = 7;
		int august = 8;
		int september = 9;
		int october = 10;
		int november = 11;
		int december = 12;
		
		//Validity
		boolean valid = true;
		
		//The following is receiving and testing the validity of the user inputs.
		
		//This asks for the year.
		System.out.println("What is the year you wish to choose? Ex: 2000");
		year = (int)sc.nextInt();
		
		//This is if the user decides to put something below 0, which is invalid.
		if(year<0 || year>=10000)
			valid=false;
			
		//This asks for the month.
		System.out.println("What is the number of the month you wish to choose (1-12?)");
		month = (int)sc.nextInt();
			
		//This is if the user decides to put something below 0 or above 12, which is invalid.
		if(month>12 || month<0)
				valid=false;
		
		//This asks for the day.
		System.out.println("What is the number of the day you wish to choose (Assume it is a leap year.)?");
		day = (int)sc.nextInt();
				
		//This is in case the month is February We always assume it is a leap year.
		if(month==february)
		{
		//This is if the user decides to put something below or equal to 0
		// or greater than 29, which is invalid.
		if(day>29 || day<=0)
				valid=false;
		}
		else
		{
			if(month==january || month==march || month==may || month==july || month==august || month==october || month==december)
			{
				//This is if the user decides to put something below or equal to 0
				// or greater than 31, which is invalid.
				if(day>31 || day<=0)
				        valid=false;
			}
			if(month==april || month==june || month==september || month==november)
			{
				//This is if the user decides to put something below or equal to 0
				// or greater than 30, which is invalid.
				if(day>30 || day<=0)
						valid=false;
			}
		}
		
		//This makes sure the code doesn't run and prints an error message if the date is invalid.
		if (valid==true)
		{
			if (year<thisYear) // Here, the year is in the past.
			    System.out.println("The date is from a past year.");
			else
				if (year>thisYear) // Here, the year is in the future.
					 System.out.println("The date is from a future year.");
				else
					if (month<thisMonth)  // Here, the month is in the past.
						 System.out.println("The date is from this year, but in a past month.");
					else
						if (month>thisMonth)  // Here, the month is in the future.
								System.out.println("The date is from this year, but in a future month.");
						else
							if (day<thisDay)  // Here, the day is in the past.
								System.out.println("The date is from this year and this month, but a past day.");
							else
								if (day>thisDay) // Here, the day is in the future.
					            System.out.println("The date is from this year and this month, but is a future day.");
					            else
					                System.out.println("The date is the current day.");
			            
	    }
	    else
    		{
    			System.out.println("The date is invalid.");
    		}
	}
}
