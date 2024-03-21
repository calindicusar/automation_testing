import java.util.*;

public class Main
{
    public static void main(String[] args) {
        String sentence = "a b c -  b;a"; //string to be processed.
        //String sentence = "a b c"; //string to be processed. Throws exception
        boolean noWordsAppearingMultipleTimes = true;
        
        String[] arrOfWords = sentence.split("\\W+");
        
        Hashtable<String, Integer> countWordAppearance = new Hashtable<String, Integer>();
        
        for (String word : arrOfWords) {
            System.out.println(word);
            Integer nrAppearances = countWordAppearance.get(word);
            
            if (nrAppearances == null) {
                countWordAppearance.put(word, 1);
            } else {
                countWordAppearance.put(word, nrAppearances + 1);
                noWordsAppearingMultipleTimes = false;
            }
        }

        System.out.println(countWordAppearance);
        
        try {
            if (noWordsAppearingMultipleTimes == true) {
                throw new CustomException("Exception:");
            }
        
        } catch(CustomException E) {
            System.out.println(E + " No repeated words"); 
        }   
    }
}

class CustomException extends Exception  
{  
    public CustomException (String str)  
    {  
       super(str);  
    }  
} 
