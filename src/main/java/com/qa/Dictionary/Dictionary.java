package com.qa.Dictionary;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	public static Map<Character, Integer> lettersCountMap;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the word:");
		String letters= scan.nextLine().toUpperCase();
		lettersCountMap = getCharacterCountMap(letters);
		System.out.println("The words that can be formed are:"+isEnglishWord());
		scan.close();
		
		}
	
		public static Map<Character,Integer> getCharacterCountMap(String letters) {
		Map<Character, Integer> lettersCountMap=new HashMap<Character, Integer>();
		
			for(int i=0;i<letters.length();i++) {
			char currentChar=letters.charAt(i);
			int count = lettersCountMap.containsKey(currentChar) ? lettersCountMap.get(currentChar):0 ;
			lettersCountMap.put(currentChar, count+1);
		    }
			
			return lettersCountMap;
		}

		public static ArrayList<String> isEnglishWord() throws IOException {
			ArrayList<String> wordList = new ArrayList<String>();
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\delpi\\eclipse-workspace\\DictionaryDemo\\src\\main\\java\\com\\qa\\util\\DummyDictionary"));
						
			for(String currentWord=reader.readLine();currentWord!=null;currentWord=reader.readLine()) {
				Map<Character,Integer> currentWordMap= getCharacterCountMap(currentWord);
				
				boolean canMakeWord=true;
				for(Character character:currentWordMap.keySet()) {
					int currentWordCharCount = currentWordMap.get(character);
					int lettersCharCount = lettersCountMap.containsKey(character) ? lettersCountMap.get(character):0;
					if (currentWordCharCount>lettersCharCount) {
						canMakeWord=false;
						break;
					}
				}
				
				if(canMakeWord) {
					wordList.add(currentWord);
				}
			}
			reader.close();
			LinkedHashSet<String> hashSet = new LinkedHashSet<String>(wordList);
			ArrayList<String> wordsNoDuplicatesList= new ArrayList<String>(hashSet);
			return wordsNoDuplicatesList;
		}
		
}
