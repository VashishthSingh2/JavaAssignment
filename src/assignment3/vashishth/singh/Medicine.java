package assignment3.vashishth.singh;

public class Medicine {
	public void displayLabel() {
		System.out.println("Name = R Medicine Comp, Address = Allahabad Uttar Pradesh");
	}
}
class Tablet extends Medicine{
	public void displayLabel() {
		System.out.println("Name = R Medicine Comp, Address = Allahabad Uttar Pradesh");
		System.out.println("Tablet: store in a cool dry place");
	}
}
class Syrup extends Medicine{
	public void displayLabel() {
		System.out.println("Name = R Medicine Comp, Address = Allahabad Uttar Pradesh");
		System.out.println("Syrup: Two Times In A Day");
	}
}
class Ointment extends Medicine{
	public void displayLabel() {
		System.out.println("Name = R Medicine Comp, Address = Allahabad Uttar Pradesh");
		System.out.println("Ointment: for external use only");
	}
}
