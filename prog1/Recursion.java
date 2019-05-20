
	
 class Recursion {

   static void reverseArray1(int[] X, int n, int[] Y) {
	  if(n>0){
		  Y[n-1] = X[X.length-n]; 
	     reverseArray1(X, n-1, Y);
	  }
    }

   static void reverseArray2(int[] X, int n, int[] Y){
	   if(n>0){     
           Y[Y.length-n] = X[n-1];  
           reverseArray2(X, n-1, Y); 
	   }
   }
  
   static void reverseArray3(int[] X, int i, int j){
       if(i<j){
    	   		int temp= X[j];
    	   		X[j]= X[i];
    	   		X[i]= temp;
           reverseArray3(X, i+1, j-1);   
       }
   }
   
   static int maxArrayIndex(int[] X, int p, int r){
      int mid=0;
      if (p<r) {
         mid = (p+r)/2; 
         int left = maxArrayIndex(X, p, mid);
         int right = maxArrayIndex(X, mid+1, r);
         
         if (X[left] > X[right]) {
        	 	mid = left;
         }
         else if (X[right] > X[left]) {
        	 	mid = right;
         }
      }
      return mid;
   }

   static int minArrayIndex(int[] X, int p, int r){
      int mid2 = 0;
      if (p<r) {
         mid2 = (p+r)/2; 
         int left2 = minArrayIndex(X, p, mid2);
         int right2 = minArrayIndex(X, mid2+1, r);
         if (X[left2] < X[right2]){
        	 	mid2 = left2;
         }
         else if (X[right2] < X[left2]) {
        	 	mid2 = right2;
         }
      }
      return mid2;
   }
   
   
   public static void main(String[] args){

	   int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
	   int[] B = new int[A.length];
	   int[] C = new int[A.length];
	   int minIndex = minArrayIndex(A, 0, A.length-1);
	   int maxIndex = maxArrayIndex(A, 0, A.length-1);

	   for(int x: A) System.out.print(x+" ");
	   System.out.println();

	   System.out.println( "minIndex = " + minIndex );
	   System.out.println( "maxIndex = " + maxIndex );
	   reverseArray1(A, A.length, B);
	   for(int x: B) System.out.print(x+" ");
	   System.out.println();

	   reverseArray2(A, A.length, C);
	   for(int x: C) System.out.print(x+" ");
	   System.out.println();

	   reverseArray3(A, 0, A.length-1);
	   for(int x: A) System.out.print(x+" ");
	   System.out.println();

   }
}


