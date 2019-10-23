import java.lang.ref.Cleaner;

public class BasicAlgoTest{
    public static void main(String[] args){
        BasicAlgo test = new BasicAlgo();

        test.printToFiftyFive(255);
        test.printAllOdds(255);
        test.printSum(10);

        int[] myarr = new int[]{1,2,3,-4,5,-1,8};
        test.iterArray(myarr);

        test.findMax(myarr);
        System.out.println("All ods: " + test.arrayOfOdds(10));
        System.out.println("All gr than Y: " + test.arrGrThanY(myarr,2));
        System.out.println("Square the vals: " + test.squareTheVals(myarr));
        System.out.println("no negatives" + test.noNegatives(myarr));
        System.out.println("min max ave " + test.maxMinAve(myarr));
        System.out.println("shifted: " + test.shiftArrLeft(myarr));
    }
}