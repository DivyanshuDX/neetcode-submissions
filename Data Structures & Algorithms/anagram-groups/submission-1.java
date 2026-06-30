

// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if(strs == null || strs.length == 0) return new ArrayList<>();

//         Map<String , List<String>> map = new HashMap<>();

//         for(String s : strs){
//             // Convert string to char array, sort it, then back to string
//             char[] chars = s.toCharArray();
//             Arrays.sort(chars);
//             String key = new String(chars);

//             // Add to map
//             if(!map.containsKey(key)){
//                 map.put(key , new ArrayList<>());
//             }
//             map.get(key).add(s);
//         }

//         return new ArrayList<>(map.values());
//     }
// }

// 🔑 Optimized Approach
// Each string can be represented by a 26-length frequency array (for lowercase English letters).

// Convert that array into a unique key (like "a1b0c0...z0").

// Use this key in a HashMap to group anagrams.

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            // Frequency array for 26 lowercase letters
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            // Build a key from frequency counts
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#'); // delimiter
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            // Add to map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}
