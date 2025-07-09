/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Approach - Binary search
Time Complexity  - O(logN)
Space Complexity - O(1)
*/
public class H_IndexII_LC_275 {
        public int hIndex(int[] citations) {
            int start = 0;
            int end = citations.length-1;
            int n = citations.length;
            while(start <= end) {
                int mid =  start + (end-start) /2;
                if(citations[mid] == n-mid) return citations[mid];
                if(citations[mid] < n-mid) start = mid+1;
                if(citations[mid] > n-mid) end = mid-1;
            }
            return n-start;
        }
}


/* Linear
Time Complexity  - O(N)
Space Complexity - O(1)
 */
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int i = 0; i<n; i++) {
            int diff = n-i;
            if(diff <= citations[i]) {
                return diff;
            }
        }
        return 0;
    }
}


