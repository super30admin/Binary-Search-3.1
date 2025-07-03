/*
  Time complexity: O(log n)
  Space complexity: O(1)

*/

public class Solution {
    public int HIndex(int[] citations) {
        int low = 0;
        int n = citations.Length;
        int high = n-1;
        int mid = 0;

        while(low<=high)
        {
            mid = low+(high-low)/2;
            int diff = n - mid;
            if(diff==citations[mid])
                return diff;
            else
                if(diff>citations[mid])
                    low=mid+1;
                else    
                    high = mid-1;
        }
        return n-low;
    }
}
