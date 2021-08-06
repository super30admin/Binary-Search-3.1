// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int hIndex(int[] citations) {
        if(citations==null || citations.length==0) return -1;
        int len = citations.length;
        for(int i=0; i<len; i++){
            if(citations[i]>=len-i)
                return len-i;
        }
        return 0;
    }
}