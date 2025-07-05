
// Time Complexity: O(log n)
// Space Complexity: O(1)
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int diff = n - mid;
            if (diff == citations[mid]) {
                return diff;
            } else if (diff > citations[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return n - left;
    }
}

// Time - O(n)
// Space - O(1)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int diff = n - i;
            if (diff <= citations[i]) {
                return diff;
            }
        }
        return 0;
    }
}
