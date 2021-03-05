package assignmnet1.vashishth.singh;

public class Question10 {
	
	static void displayMultiplicationMatrix(int matrix[][]) {
		int a,b;
		for(a=0;a<=12;a++) {
			if(a==0)
				System.out.print("  ");
			else
				System.out.print("    |"+a);
		}
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		
		for(a=1;a<=12;a++) {
			System.out.print("|"+a+"    ");
			for(b=1;b<=12;b++) {
				System.out.print("|"+matrix[a][b]+"    ");
			}
			System.out.println("\n---------------------------------------------------------------------------------------------");
		}
	}
	public static void main(String []rags) {
		int a,b;
		int matrix[][]=new int[13][13];
		for(a=1;a<=12;a++) {
			for(b=1;b<=12;b++) {
				matrix[a][b]=a*b;
			}
		}
		displayMultiplicationMatrix(matrix);
	}
}
