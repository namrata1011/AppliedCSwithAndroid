/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    HashSet<String> wordSet = new HashSet<>();
    HashMap<String, ArrayList<String>> lettrsToWord = new HashMap<>();
    HashMap<Integer, ArrayList<String>> sizeToWords = new HashMap<>();
    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);

            if(lettrsToWord.containsKey(sortWord(word))) {
                ArrayList<String> temp = lettrsToWord.get(sortWord(word));
                temp.add(word);
                lettrsToWord.put(sortWord(word),temp);
            }
            else {
                ArrayList<String> newWord = new ArrayList<>();
                newWord.add(word);
                lettrsToWord.put(sortWord(word),newWord);
            }
        }
        Log.e("Hashmap structure", lettrsToWord.toString());
    }

    public boolean isGoodWord(String word, String base) {
        return !word.contains(base)&&wordSet.contains(word);
    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> interResult = new ArrayList<>();
        for (char i='a';i<='z';i++){
            String anagram = word+i;
            if (lettrsToWord.containsKey(sortWord(anagram))) {
                interResult = lettrsToWord.get(sortWord(anagram));
                for (String s: interResult) {
                    if (isGoodWord(s,word))
                    result.add(s);
                }
            }
        }
        return result;
    }

    public String pickGoodStarterWord() {
        int wordLength = 3;
        Random r = new Random(); // Intialize a Random Number Generator with SysTime as the seed
        StringBuilder sb = new StringBuilder(wordLength);
        for(int i = 0; i < wordLength; i++) { // For each letter in the word
            char tmp = (char) ('a' + r.nextInt('z' - 'a')); // Generate a letter between a and z
            sb.append(tmp); // Add it to the String
        }
        return sb.toString();
    }

    public String sortWord(String source) {
        char[] chars = source.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
