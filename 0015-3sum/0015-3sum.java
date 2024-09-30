class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int i1 = 0;
        while (i1 <= nums.length - 3) {
            int i2 = i1 + 1;
            int i3 = nums.length - 1;
            
            while (i2 <= nums.length - 2&& i2 < i3) {
                int sum = nums[i1] + nums[i2] + nums[i3];
                if (sum == 0) {
                    List<Integer> validRes = new ArrayList<>();
                    validRes.add(nums[i1]);
                    validRes.add(nums[i2]);
                    validRes.add(nums[i3]);
                    res.add(validRes);
                    i2++;
                    i3--;
                    while (i2 <= nums.length - 2&& nums[i2] == nums[i2 - 1]) i2++;
                    while (i2 <= nums.length - 2&& nums[i3] == nums[i3 + 1]) i3--;
                } else if (sum < 0) {
                    i2++;
                } else if (sum > 0) {
                    i3--;
                }
            }

            i1++;
            while (i1 <= nums.length - 3 && nums[i1] == nums[i1 - 1]) i1++;
        }

        return res;
    }
}