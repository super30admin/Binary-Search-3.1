/**
 * Leetcode 275. H-Index II
 * Link: https://leetcode.com/problems/h-index-ii/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class HIndexII {
    /**
     * Linear solution - at a given index if no of citations become greater or equal to remaingPapers, that is h-index
     * Processing starts from beginning of the array
     *
     * TC: O(n) SC: O(1)
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int remainingPapers = n - i;
            if (citations[i] >= remainingPapers) {
                return remainingPapers;
            }
        }
        return 0;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class HIndexII2 {
    /**
     * Binary Search solution - same above solution can be converted to logn solution by ignoring left half if
     * hindex not found at mid. Or ignore right half if possible hindex is found but we need to find the maximum
     * possible h-index.
     *
     * TC: O(logn) SC: O(1)
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int remainingPapers = n - mid;

            if (citations[mid] == remainingPapers) {
                return remainingPapers;
            } else if (citations[mid] > remainingPapers) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return n - low;
    }
}