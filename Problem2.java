// https://leetcode.com/problems/h-index-ii

// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// used binary search cause when n-h == citations we have our h index else
// we keep moving our low and high and n-low at the end becomes our hindex.

public class Problem2 {
    // class Solution {
//     public int hIndex(int[] citations) {
//         if(citations == null || citations.length ==0) return 0;
//         int n = citations.length;
//         for(int i=0; i<n;i++){
//             int dif=n-i;
//             if(citations[i]>=dif) return dif;
//         }
//         return 0;
//     }
// }
    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0) return 0;
        int n = citations.length;
        int high = n-1;
        int low =0;
        while(low<=high){
            int mid =(low + (high-low)/2);
            if(citations[mid]==n-mid) return n-mid;
            else if(citations[mid]>=n-mid) high=mid-1;
            else low=mid+1;
        }
        return n-low;
    }
}
