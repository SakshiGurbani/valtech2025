package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VowelCount {
   
	public int vowelCount(String sentence) {
		
		int count=0;
		String caseSensitive=sentence.toLowerCase();
		for(int i=0;i<caseSensitive.length();i++) {
			char ch= caseSensitive.charAt(i);
			
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				count++;
			}
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		List<String> sentences=new ArrayList<String>();
		sentences.add("Hello Everyone");
		sentences.add("I am a Software Engineer");
		sentences.add("You can do it");
		sentences.add("Dont Stop Yourself");
		
		System.out.println(sentences);
		
		SortingSentencesByVowelCount sc=new SortingSentencesByVowelCount();
		Map<String,Integer>sentenceWithCount=new HashMap<String,Integer>();
		 for(String sent:sentences) {
			 sentenceWithCount.put(sent,sc.vowelCount(sent));
		 }
		 
    Map<String,Integer> sentencesAfterSorting=sentenceWithCount.entrySet().stream()
		.sorted(Map.Entry.<String,Integer>comparingByvalue().reversed()
		.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1))));
		 
    
	   
				 
		
		
		
		
	}
}
