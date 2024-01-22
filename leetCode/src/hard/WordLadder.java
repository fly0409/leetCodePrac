package hard;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
//        String beginWord = "hit";
        String beginWord = "red";
//        String endWord = "cog";
        String endWord = "tax";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String> wordList = Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee");
        int ans = ladderLength(beginWord, endWord, wordList);
        System.out.println(ans);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> wordsQueue = new LinkedList<>();
        Set<String> visitedWord = new HashSet<>();

        wordsQueue.offer(beginWord);
        visitedWord.add(beginWord);
        int ans = 1;
        while (wordsQueue.size() > 0) {
            int size = wordsQueue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = wordsQueue.poll();
                if (currentWord.equals(endWord)) {
                    return ans;
                }

                for (int j = 0; j < currentWord.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        char[] charArray = currentWord.toCharArray();
                        charArray[j] = k;
                        String diffWord = new String(charArray);
                        if (set.contains(diffWord) && !visitedWord.contains(diffWord)) {
                            wordsQueue.offer(diffWord);
                            visitedWord.add(diffWord);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }


    //TLE
    public static int ladderLengthTLE(String beginWord, String endWord, List<String> wordList) {

        Queue<String> wordsQueue = new LinkedList<>();
        Map<String, Boolean> wordsRecord = new HashMap<>();
        wordsQueue.offer(beginWord);
        int ans = 0;
        while (!wordsQueue.isEmpty()) {
            int size = wordsQueue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                String currentWord = wordsQueue.poll();

                for (String word : wordList) {


                    if (twoWordDiffInOneWord(currentWord, word)) {
                        //match的情況
                        if ((endWord.equals(word))) {
                            return ans + 1;
                        }
                        if (wordsRecord.get(word) != null && wordsRecord.get(word)) {
                            continue;
                        }
                        wordsQueue.offer(word);
                        wordsRecord.put(word, true);
                    }
                }
            }
        }
        return 0;
    }

    private static Boolean twoWordDiffInOneWord(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (!a.substring(i, i + 1).equals(b.substring(i, i + 1))) {
                count++;
            }
            if (count > 1) return false;
        }
        return true;
    }

}
