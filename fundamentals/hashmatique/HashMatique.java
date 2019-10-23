// Map of the Hashmatique
// A band from Teignmouth, Devon has contracted your company to organize their song list. Part of this is that they don't want to use song numbers in storing the lyrics until they are certain of the order. They insist that you be able to immediately retrieve the lyrics based on the song name, and your PM has asked you to implement this.
// To demonstrate to the band how it would work, use a HashMap with the track titles as keys and some sample lyrics as the values. Add at least 4 songs to your trackList HashMap and then pull one out by its name. They also want to be able to see all the tracks with the lyrics immediately following them.
// Objectives:
// ● Create your first HashMap.
// ● Iterate over a HashMap.
// Tasks:
// ● Create a trackList of type HashMap
// ● Add in at least 4 songs that are stored by title
// ● Pull out one of the songs by its track title
// ● Print out all the track names and lyrics in the format Track: Lyrics



import java.util.HashMap; 
import java.util.Map;
import java.util.Set;
public class HashMatique{
    public static void main (String[] args){
        HashMap<String,String> songMap = new HashMap<>();
        songMap.put("first", "about life");
        songMap.put("first1", "about life1");
        songMap.put("first2", "about life2");
        songMap.put("first3", "about life3");
        Set<String> keys = songMap.keySet();
        for(String key : keys) {
            System.out.println(key + " " + songMap.get(key));
            //System.out.println(songMap.get(key));  
        }
    }
}