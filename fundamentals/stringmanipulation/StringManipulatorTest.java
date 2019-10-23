public class StringManipulatorTest{
    public static void main(String[] args){
        StringManipulator sM = new StringManipulator();
        
        String trimAndConcat = sM.trimAndConcat("  vicky is" , "  an idiot   ");
        System.out.println(trimAndConcat);

        Integer test = sM.getIndexOrNull("Vicky", 'p');
        System.out.println(test);

        Integer test1 = sM.getIntegerOrNull("Vicky is an idiot", "is");
        System.out.println(test1);

        String test2 = sM.concatSubstring("fname", 2, 5, "lname");
        System.out.println(test2);

    }
}