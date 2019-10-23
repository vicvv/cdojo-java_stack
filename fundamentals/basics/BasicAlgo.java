import java.util.List;
import java.util.ArrayList;

public class BasicAlgo{

    public Integer printToFiftyFive(int mynum){
        //List<Integer> myList = new ArrayList<Integer>();
        for (int i=0; i < mynum +1; i++){
           // myList.add(i);
            System.out.println(i);
        }
        return mynum;
       
    }

    public Integer printAllOdds(int mynum){

        for (int i = 0; i< mynum+1; i++){
            if (i%2 == 1){
                System.out.println(i);
            }
        }
        return mynum;
    }

    public Integer printSum (int mynum){
        int sum = 0;
        for (int i = 0; i< mynum+1; i++){
            sum += i;
            System.out.println("New number: " + i + " Sum: "+ sum);
            
        }
        return sum;
    }
// iterate array
    public static int[] iterArray(int[] myarr){

        for (int i=0 ; i < myarr.length; i++){
            System.out.println(myarr[i]);
        }
        return myarr;
    }

    public void findMax(int[] myarr){
        int max = myarr[0];
        for (int i=0 ; i < myarr.length; i++){
            if (myarr[i] > max){
                max = myarr[i];
            }
        }

        System.out.println("Max: " + max);
    }

    public  ArrayList arrayOfOdds(int myint){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < myint+1; i++){
            if (i%2 == 1){
                list.add(i);
            }
        }

        return list;
    }

    public Integer arrGrThanY(int[] myarr , int mynum){
        int count = 0;

        for (int i = 0; i < myarr.length; i++){
            if (mynum > myarr[i]){
                count++;
            }
        }
        return count;
    }

    public ArrayList squareTheVals(int[] myarr){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < myarr.length; i++){
            int sq = (int)Math.pow(myarr[i],2);
            //System.out.println(myarr[i] + " = " + sq);
            list.add(sq);
        }
        return list;
    }

    public ArrayList noNegatives(int[] myarr){
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < myarr.length; i++){
            if (myarr[i] > 0){
                list.add(myarr[i]);
            }
            else{
                list.add(0);
            }
        }
        return list;
    }

    public ArrayList maxMinAve(int[] myarr){
        ArrayList<Integer> list=new ArrayList<Integer>();
        int sum = 0;
        int min = myarr[0];
        int max = myarr[0];

         for (int i = 0; i < myarr.length; i++){
             sum += myarr[i];

             if (myarr[i] > max){
                max = myarr[i];
             }
             else if (min < myarr[i]){
                 min= myarr[i];
             }
        }
        list.add(min);
        list.add(max);
        list.add(sum/myarr.length);
        
        return list;
    }  
    
    public ArrayList shiftArrLeft(int[] myarr){
        ArrayList<Integer> list=new ArrayList<Integer>();
        
        myarr[myarr.length - 1] = 0;
        for (int i = 1; i > 0 ; i--){
            myarr[i-1] = myarr[i];
        }
        
        for (int i = 0; i < myarr.length; i++){
            list.add(myarr[i]);
        }
        return list;
    }

} 