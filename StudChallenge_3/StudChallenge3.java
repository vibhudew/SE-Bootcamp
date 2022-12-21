import java.util.Arrays;

class StudChallenge3{

    public static void main(String[] args) { 

        int givenArray[] = new int[]{47,84,75,21,14,14,79};

        System.out.println("Given Array : ");

        // method 1 to display an array using Arrays.toString()
        //System.out.println(Arrays.toString(givenArray) + "\n");

        // method 2 to display an array using for loop
        for( int i=0; i < givenArray.length ; i++){

            System.out.print(givenArray[i]);
            System.out.print(" ");
            
        }

        System.out.println();

        int temp = 0;

        // sorting logic - Bubble Sort
        for( int i=0; i < givenArray.length ; i++){

            for( int j=i + 1; j < givenArray.length ; j++){

                if(givenArray[i] > givenArray[j]){

                    temp = givenArray[i];
                    givenArray[i] = givenArray[j];
                    givenArray[j] = temp;    
                }
            }
        }

        System.out.println();
        System.out.println("After sorting : \n");
       
        
        for( int i=0; i < givenArray.length ; i++){
            
		    System.out.print(givenArray[i]);
            System.out.print(" ");
            
        }


        // --------------------------------Median---------------------------------------

        float median_res = getMedian(givenArray.length , givenArray);
        System.out.println("\n\nMedian :"+ median_res);

        // -------------------------------Highest Value----------------------------------

        int highValue = getMaxValue(givenArray);
        System.out.println("\n\nHighest Value :"+ highValue);

        // ---------------------------------Mode-----------------------------------------
        int mode = getMode(givenArray , givenArray.length);
        System.out.println("\n\nMode :"+ mode);

        // ----------------------------------Prime Number--------------------------------
        System.out.println("\n\nThe Prime Numbers : ");
        for(int i=0;i<givenArray.length;i++) {

            boolean isPrime =true;  // setting it to true before checking for every numbers

            for(int j=2;j*j<givenArray[i];j++) {
                if(givenArray[i]%j ==0) {
                    isPrime =false ;  // will become false only when not an prime
                    break;  
                }
            }

            // isPrime will remain true if numbers[i] is a prime number. So print the prime number
            if(isPrime) {
                System.out.println(givenArray[i]+" ");
            }
        }
    }

    public static float getMedian(int n , int arr[]){

        float median = 0;
        if( n %2 == 1){
            median = arr[(n+1)/2-1];
        }
        else{
            median = ( arr[n/2-1] + arr[n/2] ) /2;

        }

        return median;

    }

    public static int getMaxValue(int arr[]){

        int max = arr[arr.length-1];

        return max;


    }

    public static int getMode(int a[],int n) {
        int maxValue = 0;
        int maxCount = 0;
  
        for (int i = 0; i < n; ++i) {
           int count = 0;
           for (int j = 0; j < n; ++j) {
              if (a[j] == a[i])
              ++count;
           }
  
           if (count > maxCount) {
              maxCount = count;
              maxValue = a[i];
           }
        }
        return maxValue;
    }    
}




