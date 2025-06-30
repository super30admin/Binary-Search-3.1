//Brute force: Compare all elements one by one from Array1 with all elements from Array2
//(0,0), (0,1) ...(0,6) //(m*n)
//(1,0), (1,1) ...(1,6) //(m*n)......
//TC = O(m*n)

//Two poinetrs: 1 pointer on Array1, second pointer on Array2
//TC = O(m+n)

//Binary Search: Closest to target
//TC = O(m*logn)
import java.util.*;

class Solution {

    public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target) {
        List<int[]> output = new ArrayList<>();

        if (forward.length == 0 || backward.length == 0 || target == 0) {
            return output;
        }

        // Sort backward list by distance so we can binary search
        Arrays.sort(backward, (a, b) -> a[1] - b[1]);

        int max = 0;

        for (int i = 0; i < forward.length; i++) {
            int remaining = target - forward[i][1];
            int index = binarySearch(backward, remaining);

            if (index != -1) {
                int sum = forward[i][1] + backward[index][1];

                if (sum >= max) {
                    if (sum > max) {
                        output = new ArrayList<>(); // reset for new max
                    }
                    max = sum;
                    output.add(new int[] { forward[i][0], backward[index][0] });
                }
            }
        }

        return output;
    }

    // binary search: find largest backward distance <= target
    public int binarySearch(int[][] backward, int target) {
        int left = 0;
        int right = backward.length - 1;
        int res = -1; // store best index found

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (backward[mid][1] == target) {
                return mid; // perfect match
            } else if (backward[mid][1] < target) {
                res = mid; // candidate, but look for bigger one
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] forward = { {1, 2000}, {2, 4000}, {3, 6000} };
        int[][] backward = { {1, 2000} };
        int target = 7000;

        List<int[]> res = s.optimalAirRoute(forward, backward, target);

        if (res != null) {
            for (int[] pair : res) {
                System.out.println(pair[0] + "," + pair[1]);
            }
        }
    }
}