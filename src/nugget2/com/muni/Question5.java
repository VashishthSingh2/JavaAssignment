package nugget2.com.muni;

import java.util.Scanner;

public class Question5 {
	static void printArray(char ar[][]){
	    int i,j;
	    for(i=0;i<3;i++){
	        System.out.print("-------------\n|");
	        for(j=0;j<3;j++){
	        	System.out.print(" "+ar[i][j]+" |"); //" %c |"
	        }
	        System.out.println();
	    }
	    System.out.print("-------------\n");
	}
	static int validate(char ar[][]){
	    int i;
	    int a0[]=new int[8];
	    int ax[]=new int[8];
	    for(i=0;i<3;i++){
	        if(ar[0][i]=='0'){ a0[0]++; }
	        if(ar[1][i]=='0'){ a0[1]++; }
	        if(ar[2][i]=='0'){ a0[2]++; }

	        if(ar[i][0]=='0'){ a0[3]++; }
	        if(ar[i][1]=='0'){ a0[4]++; }
	        if(ar[i][2]=='0'){ a0[5]++; }

	        if(ar[i][i]=='0'){ a0[6]++; }
	        if(ar[i][2-i]=='0'){ a0[7]++; }
	    }
	    for(i=0;i<3;i++){
	        if(ar[0][i]=='x'){ ax[0]++; }
	        if(ar[1][i]=='x'){ ax[1]++; }
	        if(ar[2][i]=='x'){ ax[2]++; }

	        if(ar[i][0]=='x'){ ax[3]++; }
	        if(ar[i][1]=='x'){ ax[4]++; }
	        if(ar[i][2]=='x'){ ax[5]++; }

	        if(ar[i][i]=='x'){ ax[6]++; }
	        if(ar[i][2-i]=='x'){ ax[7]++; }
	    }
	    for(i=0;i<8;i++){
	        if(a0[i]==3){
	            return(1);
	        }
	    }
	    for(i=0;i<8;i++){
	        if(ax[i]==3){
	            return(2);
	        }
	    }
	    return(0);
	}
	public static void main(String []args) {
		char matrix[][]={{'-','-','-'},{'-','-','-'},{'-','-','-'}};
		char ch;
		int flag=0,indexI=0,indexJ=0,winner,winner0=0,winnerX=0,draw=0;
		Scanner sc=new Scanner(System.in);
		while(true) {
			while(true) {
				if(flag==1)
					System.out.println("\nYou Entered Other Char, Try Again : ");
				System.out.println("\nEnter 0/x Only : ");
				ch=sc.next().charAt(0);
				if(ch=='0' || ch=='x') {
					break;
				}
				flag=1;
			}
			flag=0;
			
			matrix[indexI][indexJ]=ch;
			printArray(matrix);
			winner=validate(matrix);
			
			if(indexJ==2 && indexI!=2) {
				indexI++;
				indexJ=-1;
			}
			if(winner==1) {
				System.out.println("\n0 Wins");
				winner0=1;
				break;
			}
			if(winner==2) {
				System.out.println("\nx Wins");
				winnerX=1;
				break;
			}
			if(indexI==2 && indexJ==2) {
				draw=1;
				break;
			}
			indexJ++;
		}
		if(draw==1 && winner0==0 && winnerX==0) {
			System.out.println("\nDraw");
		}
		System.out.println("\n:Program End:");
	}
}
