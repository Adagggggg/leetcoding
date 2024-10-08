class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0]) return k;

        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int foundUntilMid = arr[mid] - mid - 1;

            if (foundUntilMid >= k) {
                end = mid;
            } else {
                start = mid + 1;
            } 
        }

        int startIndex = start - 1;
        int foundUntilStart = arr[startIndex] - startIndex - 1;
        return arr[startIndex] + (k - foundUntilStart);
    }
}