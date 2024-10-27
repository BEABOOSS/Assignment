import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main{
    public static void main(String[] args){
        // First Problem
        String url = "https://www.example.com/page/arst/arstars/ar";
        String extractedDomain = extractDomain(url);
        System.out.printf("%nFirst Problem%n%s%n", extractedDomain);

        // Second Problem
        String hashTag = "Excited to announce our new product #launch! #exciting #newbeginnings";
        // String hashTag = "Excited to announce our new product";
        String pattern = "#(\\w*)";
        List<String> extractedList = extractHashtag(hashTag, pattern);
        System.out.printf("%nSecond Problem%n");
        extractedList.forEach(x -> System.out.printf("%s%n", x));

        // Third Problem
        String lastWord = "The quick brown fox jumps over the lazy dog";
        String extractedLastWord = extractLastWord(lastWord);
        System.out.printf("%nThird Problem%nLast word:%s%n",extractedLastWord);
    }

    public static String extractDomain(String url){
        // remove 'https://'
        String cleanUrl = url.toLowerCase();
        if(cleanUrl.contains("://")){
            cleanUrl = cleanUrl.split("://")[1];
        }
        // removes www.
        if(cleanUrl.startsWith("www.")){
            cleanUrl = cleanUrl.substring(4);
        }
        // gets everything up to the first slash
        int slashIndex = cleanUrl.indexOf('/');
        if(slashIndex != -1){
            cleanUrl = cleanUrl.substring(0, slashIndex);
        }
        return cleanUrl;
    }


    public static List<String> extractHashtag(String input, String pattern){
        List<String> matches = new ArrayList<>();
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher m = pattern1.matcher(input);
        // adds any of the matches to the String array
        while(m.find()){
           matches.add(m.group(1));
        }

        return matches;
    }

    public static String extractLastWord(String input){
        Pattern pattern = Pattern.compile("\\w+\\Z");
        Matcher m = pattern.matcher(input);
        String output = "";
        // puts the last string to the output
        if(m.find()){
            output = m.group(0);
        }
        return output;
    }

}