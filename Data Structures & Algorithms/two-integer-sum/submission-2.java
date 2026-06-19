// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i =0 ;i<nums.length ;i++){
//             for(int j=i+1 ; j<nums.length ; j++){
//                 if(nums[i] + nums[j] == target){
//                     return new int[]{i,j};
//                 }
//             }
//         }
//         return new int[]{};
//     }
// }

// Also 1 more approach using Hashmap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Use a HashMap to store value -> index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If complement exists in map, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Store current number with its index
            map.put(nums[i], i);
        }
        
        // If no solution found (problem guarantees one), return empty
        return new int[] {};
    }
}
