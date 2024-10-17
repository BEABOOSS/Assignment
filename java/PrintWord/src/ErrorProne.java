import java.util.Scanner;

public class ErrorProne {
    //.\ErrorProne.java:8: error: <identifier> expected
    //    private static int public;
    // .\ErrorProne.java:8: error: illegal start of type
    //    private static int public;
    private int public;



    private long Temp2;



    //.\ErrorProne.java:19: error: ';' expected
    //    private String my-variable;
    //                            ^
    //.\ErrorProne.java:19: error: <identifier> expected
    //    private String my-variable;
    //                                     ^
    //.\ErrorProne.java:19: error: cannot find symbol
    //    private String my-variable;
    //                             ^
    //  symbol:   class variable
    //  location: class ErrorProne
    private String my-variable;


    // These are just funny that I had to include
    private char ಠ_ಠ;
    private boolean ____________________;
    private float thisIsAVeryLongVariableNameThatKeepsGoingAndGoingAndNeverSeeminglyStopsUntilItEventuallyDoes;


}
