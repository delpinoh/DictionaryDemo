package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.Dictionary.Dictionary;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

public class DictionaryTest {
  @Test
  public void getCharacterCountMapTest() {
	  String testLetter="ABC";
  	  Map<Character,Integer> wordMap=Dictionary.getCharacterCountMap(testLetter);
  	  Map<Character,Integer> verificationMap= new HashMap<Character,Integer>();
  	  verificationMap.put('A', 1);
  	  verificationMap.put('B', 1);
  	  verificationMap.put('C', 1);
  	  System.out.println(wordMap);
  	  System.out.println(verificationMap);
	  Assert.assertEquals(wordMap, verificationMap, "Map entries not matching");
  }
  
  @Test
  public void isEnglishWordMatchFoundTest() throws IOException {
	
	  Dictionary dct= new Dictionary();
	  dct.lettersCountMap= new HashMap<Character,Integer>();
	  dct.lettersCountMap.put('B', 1);
	  dct.lettersCountMap.put('L', 1);
	  dct.lettersCountMap.put('A', 1);
	  dct.lettersCountMap.put('C', 1);
	  dct.lettersCountMap.put('K', 1);
	  
	  ArrayList<String> verifyingList= new ArrayList<String>();
	  verifyingList.add("BLACK");
	  verifyingList.add("LACK");
	  verifyingList.add("ACK");
	  verifyingList.add("BACK");
	  
  	  ArrayList wordList = Dictionary.isEnglishWord();
  	  System.out.println("no of words:"+wordList);
  	  System.out.println("verifying list:"+verifyingList);
  	  Assert.assertEquals(wordList, verifyingList);
  }
  
  @Test
  public void isEnglishWordNoMatchTest() throws IOException {
		
	  Dictionary dct= new Dictionary();
	  dct.lettersCountMap= new HashMap<Character,Integer>();
	  dct.lettersCountMap.put('X', 1);
	  dct.lettersCountMap.put('Y', 1);
	  dct.lettersCountMap.put('Z', 1);
	  	 
  	  ArrayList wordList = Dictionary.isEnglishWord();
  	  Assert.assertEquals(wordList.size(), 0);
  	   
  	}
  
}
