

// ● Generate an array with 10 random strings that are each 5 characters long


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


//import javax.print.DocFlavor.STRING;

public class PuzzlingCase {
    public static void main(String[] args) {
        
        int[] myArray = { 3,5,1,2,7,238,8,13,25,32 };

        System.out.println(printSum(myArray));
        System.out.println(shuffleAndFive());
        playWithAlphabeth();
        System.out.println("Array of random 5: " + randomArray(5));
        playArrayRanSorted();
        System.out.println("String 5 char long: " + getArrayofStrings());

        System.out.println("Array of 10 of 5 long strings: "+ arrOfStrings());
        // ArrayList<Integer> numbers = new ArrayList<Integer>();
        // for (int i=0; i < arr.length; i++){
        // }
        
        // Collections.shuffle(numbers);
        // System.out.println(numbers); // [1, 5, 2, 4, 3]
        // Collections.sort(numbers);
        // System.out.println(numbers); // [1, 2, 3, 4, 5]
                
        // Random r = new Random();
        // System.out.println(r.nextInt()); // without bounds
        // System.out.println(r.nextInt(5)); // with bounds 0 to 5
    }

    public static ArrayList printSum (int[] arr){
        // ● Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. 
        //Print the sum of all numbers in the array. Also have the function return an 
        //array that only includes numbers that are greater than 10 (e.g. when you pass 
        //the array above, it should return an array with the values of 13,25,32)
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int sum = 0;
        for (int i=0; i < arr.length; i++){
            sum += arr[i];
            //int val = arr[i] > 10 ? arr[i] : 0;
            if (arr[i] > 10) numbers.add(arr[i]);
        }
        System.out.println("Sum " + sum);
        return numbers;
    }
    public static ArrayList shuffleAndFive(){
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
        ArrayList<String> namesLongerThanFive = new ArrayList<>();
        // ● Create an array with the following values: 
        // Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. 
        // Shuffle the array and print the name of each person. Have the method also return 
        // an array with names that are longer than 5 characters.

        Collections.shuffle(names);
        System.out.println(names.get(1)); 

        for (int i = 0; i < names.size(); i++){
            //System.out.println(names.get(i).length()); 
            
            if (names.get(i).length() > 5)  {
                namesLongerThanFive.add(names.get(i));
            } 
        }
        return namesLongerThanFive;
    }
    public static void playWithAlphabeth(){

        // ● Create an array that contains all 26 letters of the alphabet 
        // (this array must have 26 values). Shuffle the array and, after shuffling, 
        // display the last letter from the array. Have it also display the first letter 
        // of the array. If the first letter in the array is a vowel, have it display a message.

        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //System.out.println(alphabet[0]);
        ArrayList<Character> alphabetList = new ArrayList<Character>();

        for (int i = 0; i < alphabet.length; i++){
            alphabetList.add(alphabet[i]);
        }
        Collections.shuffle(alphabetList);

        System.out.println("The last letter in the list: " + alphabetList.get(alphabetList.size() - 1));
        System.out.println("The first letter in the list: " + alphabetList.get(0));

        char mychar = alphabetList.get(0);

        if ("aeiou".indexOf(mychar) > 0){
            System.out.println("The character is vowel: " + mychar);
        }

    }

    private static ArrayList<Integer> randomArray(int n){ 

        // Generate and return an array with 10 random numbers between 55-100.
        // To get a random integer, you can use the nextInt method of the Random class. 
        // Random Class documentation
        ArrayList<Integer> arrayRandom = new ArrayList<Integer>(n);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < n; i++)
        {
            Integer r = rand.nextInt(256);
            arrayRandom.add(r);
        }
        return arrayRandom;
    }

    private static ArrayList<Integer> playArrayRanSorted(){ 
        // ● Generate and return an array with 10 random numbers between 55-100 and 
        // have it be sorted (showing the smallest number in the beginning). 
        // Display all the numbers in the array. Next, display the minimum value in the 
        // array as well as the maximum value.

        ArrayList<Integer> arrayRandom = new ArrayList<>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int min = 55;
        int max = 100;
        int count = 10;
        
        for(int i = 0; i <= count; i++){
            arrayRandom.add(rand.nextInt(46)+55);
        }

        Collections.sort(arrayRandom);
        System.out.println("Sorted: " + arrayRandom);
        System.out.println("Min: " + arrayRandom.get(0));
        System.out.println("Max: " + arrayRandom.get(arrayRandom.size() - 1));

        return arrayRandom;
    
    }

    private static String getArrayofStrings(){

        // ● Create a random string that is 5 characters long.

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int alphaLength = alphabet.length();
        String mystr = "";
        Random rand = new Random();
        for (int i = 0; i < 5; i++){
            mystr += alphabet.charAt(rand.nextInt(alphaLength));
        }
        return mystr;
    }

    public static ArrayList<String> arrOfStrings(){

        // ● Generate an array with 10 random strings that are each 5 characters long
        ArrayList<String> tenWords = new ArrayList<>();
       
        for(int i=0;i<10; i++){
            String randStr = getArrayofStrings();
            tenWords.add(randStr);
        }

        return tenWords;
    }

}