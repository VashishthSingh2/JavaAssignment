package assignment08.vashishth.singh.question1;

public class SortingThread extends Thread{
	public void run(){  
		int arr[]= {111,22,3,44,555,60,7,82,92,10};
		System.out.println("Sorting Array Element:");
		int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]){ 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
		System.out.println("Sorted Array:");  
		for (int i = 0; i < n-1; i++) 
			System.out.print(arr[i]+" ");
		System.out.println();
	}  
}