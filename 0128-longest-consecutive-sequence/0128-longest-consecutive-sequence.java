class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int longestLen = 0;

        for (int num: set) { // iterate over the set not the nums is faster
            if (!set.contains(num - 1)) {
                int currLen = 0;
                while (set.contains(num)) {
                    currLen++;
                    num++;
                }
                longestLen = Math.max(longestLen, currLen);
            }
        }

        return longestLen;
    }
}