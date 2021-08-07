public class Student
{  private double GPA;
   private String name;
 
   public Student ()
   { 	GPA = 0.0;
     	name = “empty”;}
 
   public Student (String nomer, double gradePoint)
   { 	GPA = gradePoint;
     	name = nomer;}
 
   public Student (Student copy)
   { 	GPA = copy.GPA;
     	name = copy.name;}
 
   public double getGPA ()
   { 	return GPA;}
 
   public String getName ()
   { 	return name;}
 
   public void setGPA (double gradePoint)
   { 	GPA = gradePoint;}
 
   public void setName (String nomer)
   { 	name = nomer;}
 
   public String toString ()
   { 	return name + “ “ + GPA;}}

/* 
 *  The following code sees as to whether a given
 *  date is in the past, present, or future.
 * 
 *  @user J Hardy
 */

public class Freshmen {
	Student [] students;
	int count;
	
	public Freshmen()
	{
		students = new Student[100];
		for (int k = 0; k < students.length; k++)
		{
			students[k] = new Student();
		}
		count = 0;
	}
	
	public Freshmen(int howMany, String [] names, double [] GPAS)
	{
		students = new Student [howMany];
		for (int k = 0; k < students.length; k++)
		{
			students[k] = new Student(names[k],GPAS[k]);
		}
		count = howMany;
	}
	public Freshmen(Freshmen same)
	{	
		students = new Student[same.students.length];
		for (int k = 0; k < students.length; k++)
		{
			students[k] = new Student(same.students[k]);
		}
		count = same.count;
	}
	
	public void changeStudent(int index, String newName, double newGPA)
	{
		students[index]= new Student(newName, newGPA);
	}
	
	public double returnGPA()
	{
		double sum = 0.0;
		for (Student temp: students )
		{
			sum+=temp.getGPA();
		}
		return sum/students.length;
	}
	
	public void honorRoll()
	{
		String honors = "Honor Roll: \n\n";
		for (Student temp: students )
		{
			if(temp.getGPA() >= 3.5)
			{
				honors += temp.getName() + "\n";
			}
		}
		System.out.print(honors);
	}
	
	public void printFreshmanClass()
	{
		String classmates = "";
		for (Student temp: students )
		{
			classmates += "Name: " + temp.getName() +
					"\n" + "GPA: " + temp.getGPA() +
					"\n\n";
		}
		
		System.out.print(classmates);
	}
}



public class FreshmenDriver {
	public static void main (String args[])
	{
		String [] nomers = {"Mary Jane", "Samantha Carson", "Robin Ruth", "Rebecca Snyder","Jackie Hue", "Jack Rabbit", "Roe Wade", "Rube Goldberg", "Ada Lovelace","Sam Whiley", "Jamie Harmon", "Daniel Chavez"};
		double [] gradePoints = {3.5, 3.7, 3.4, 3.2, 3.8, 3.1, 2.0, 3.3, 4.0, 3.2, 3.6, 1.0};
		
		Freshmen mauldinFreshmen = new Freshmen(12, nomers, gradePoints);
		
		mauldinFreshmen.printFreshmanClass();
		System.out.println(mauldinFreshmen.returnGPA() + "\n");
		mauldinFreshmen.honorRoll();
		
		Freshmen temp = new Freshmen(mauldinFreshmen);
		temp.changeStudent(4,"John Smith", 3.7);
		System.out.println(" ");
		temp.printFreshmanClass();
	}
}
