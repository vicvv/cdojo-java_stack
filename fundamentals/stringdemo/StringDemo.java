public class StringDemo{
    public static void main(String[] args){
        String myString = "Hello Vicky,";
        int mylen = myString.length();
        System.out.println(mylen);
        //concatenate
        String friendName = "This is Laura";
        String sconcat = myString.concat(friendName);
        System.out.println(sconcat);

        //string format

        String whatEver = String.format("Hello %s, you won $%.2f !", "Vicky", 20.1);
        System.out.println(whatEver);

        //IndexOf
        String someString = "this is fucking Saturday! Yay!";
        int a = someString.indexOf("is");
        System.out.println(a);

        //trim
        String ihaveSpaces = "      ha ha I have spaces  !  ";
        System.out.println(ihaveSpaces.trim());

        //Uppercase and Lowercase
        String hello = "HELLO";
        String world = "world";
        System.out.println(hello.toLowerCase());
        System.out.println(world.toUpperCase());

        //Equality
        String newa = new String("word");
        String newb = new String("word");
        System.out.println(newa == newb);
        System.out.println(newa.equals(newb));








    }
}