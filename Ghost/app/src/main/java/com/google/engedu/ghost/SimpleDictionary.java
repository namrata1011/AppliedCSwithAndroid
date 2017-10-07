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

package com.google.engedu.ghost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class SimpleDictionary implements GhostDictionary {
    private ArrayList<String> words;

    public SimpleDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        words = new ArrayList<>();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
              words.add(line.trim());
        }
    }

    @Override
    public boolean isWord(String word) {
        return words.contains(word);
    }

    @Override
    public String getAnyWordStartingWith(String prefix) {

        if (prefix.equalsIgnoreCase("")) {
            Random r = new Random();
            return words.get(r.nextInt(words.size()-1));
        }

        int start = 0,end = words.size(), mid=(start+end)/2;
        while (start<end ) {
            String midWord = words.get(mid);
            if (midWord.startsWith(prefix)) {
                return midWord;
            } else {
                if (prefix.compareToIgnoreCase(midWord)<0) {
                    end = mid - 1;
                    mid = (start+end)/2;
                } else if (prefix.compareToIgnoreCase(midWord)>0) {
                    start=mid + 1;
                    mid = (start+end)/2;
                }
            }
        }
        return null;
    }

    @Override
    public String getGoodWordStartingWith(String prefix) {
        String selected = null;
        Random r = new Random();
        ArrayList<String> goodWords = new ArrayList<>();
        String thisWord = getAnyWordStartingWith(prefix);
        if (thisWord=="") return null;
        else {
            while (thisWord.startsWith(prefix)) {
                goodWords.add(thisWord);
            }
        }
        return selected;
    }
}
