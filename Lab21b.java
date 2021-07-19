class Lab21b{

   public static void main(String[] args){
      


   
   
   }
   
   public static int FindSum(int[] array, int k){
      
      //the sum to find
      int sum = 0;
      
      //stores the length of elements
      int length = Integer.MAX_VALUE;
      
      //the start of the array
      int start = 0;
      
      for(int end = 0; start < array.length; end++){
         //add the element value to the sum
         sum += array[end];
         
         //if the sum exceeds the given value of k
         while(sum > k && start <= right){
            
            //set length to new value if there is a minimum value of length found
            length = Integer.min(length, end - start + 1);
            
            //remove elements from the start of the array
            sum -= array[start];
            start++;
         
         } 
      
      }
      return len;
   }
   
   
}