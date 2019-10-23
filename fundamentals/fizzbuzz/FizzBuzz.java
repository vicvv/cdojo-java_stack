public class FizzBuzz{
    public static void main(String[] args){
        int[] arr = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 
        for (int i = 0; i < arr.length; i++){
            if (arr[i]% 3 == 0){
                System.out.println("Buzz");
            }
            else if(arr[i]%5 == 0){
                System.out.println("Fuzz");
            } 
            else if(arr[i]%5 == 0 && arr[i]% 3 == 0){
                System.out.println("FuzzBuzz");
            } else {System.out.println("Element at index " + i +  " : "+ arr[i]);}
    
        }
        
    }
}