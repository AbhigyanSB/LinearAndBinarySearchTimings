/* This program will determine the time taken
 * by the Binary search and the Linear search */

public class LinearAndBinarySearchTimings {

    public static void main(String[] args) {
    	
    	/* creating an array of 100000 with randomly generated numbers */
        int[] numbers = new int[100000];
        int key = (int)(Math.random() * 100000);
        for (int i = 0; i < 100000; i++) {
            numbers[i] = (int)(Math.random() * 100000);
        }
        
        /* To obtain the total time for the Linear search by calling the method "linearSearch(numbers, key)" */
        long start = System.currentTimeMillis();
        int index1 = linearSearch(numbers, key);
        long finalTime = System.currentTimeMillis() - start;
        
        //Displaying the total time taken for the linear search to complete
        System.out.println("Linear Search: The total time of the Linear search is: " + finalTime + " and the index is: " + index1);

        /* To obtain the total time for the Binary search by calling the method "binarySearch(number, key)" */
        start = System.currentTimeMillis();
        System.out.println("Sorting array... Please wait...");	//displaying the sorting statement while the numbers are being sorted in the binary search
        sort(numbers); 		//calling the method to sort the numbers in binary search
        System.out.println("Finished sorting!"); //displaying the finish sorting statement, when the sorting is finished in the binary search
        int index2 = binarySearch(numbers, key);
        finalTime = System.currentTimeMillis() - start;
       
        //Displaying the total time taken for the binary search to complete
        System.out.println("Binary Search: The total time of the Binary search is: " + finalTime+ " and the index is: " + index2);

    
    }
    /* method to sort the numbers in the binary search */
    public static int[] sort(int[] numbers) {
    	/* loop for sorting the numbers in the array "numbers" */
        for (int i = 0; i < numbers.length - 1; i++) {
        	/* swapping the numbers inside the array "numbers" */
            int swapIndex = i;
            int low = numbers[i];
            for (int k = i + 1; k < numbers.length; k++) {

                if (low > numbers[k]) {
                    low = numbers[k];
                    swapIndex = k;
                }
            }
            if (swapIndex != i) {
               numbers[swapIndex] = numbers[i];
               numbers[i] = low;
            }

        }
        return numbers;
    }

    /* Method for sorting the array "numbers" by linear search */
    public static int linearSearch(int[] numbers, int key) {

    	//comparing the key with the elements inside the array for the linear search
        for (int i = 0; i < numbers.length; i++) {
             if (numbers[i] == key) return i;
        }

        return -1;
    }
    
    /* Method for sorting the array "numbers" by binary search */
    public static int binarySearch(int[] numbers, int key) {
        int low = 0;
        int high = numbers.length;


        while (high >= low) {
            int mid = (high + low) / 2;
            
            //comparing the key with the elements inside the array for the binary search
            if (key > numbers[mid]) {

                low = mid + 1;
 
            } else if (key == numbers[mid]) {
                return mid;
            } else {
                high = mid - 1;
            }
        }

        return -low - 1;
    }


}