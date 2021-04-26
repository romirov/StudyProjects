package TestMap;
import java.util.*;
public class TestMap{
	public static void main(String[] args){
		HashMap<String,Integer> scores = new HashMap<String,Integer>();
		scores.put("Katty", 42);
		scores.put("Bert", 323);
		scores.put("Skyler", 420);

		System.out.println(scores);
		System.out.println(scores.get("Bert"));
	}
}
