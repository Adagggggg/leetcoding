class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        // right pointer will find all 0's and move them to the left
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                swap(nums, left, right);
                left++;
            }
        }

        // right pointer will find all 1's and move them to the left
        for (int right = left; right < nums.length; right++) {
            if (nums[right] == 1) {
                swap(nums, left, right);
                left++;
            }
        }
    }

    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}