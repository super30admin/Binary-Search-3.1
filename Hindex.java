
// 0 logn
// 0(1)
class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0 || citations==null)
        {
            return 0;
        }
        int low=0;
        int n =citations.length;
        int high = n-1;
        int mid=0;
        while(low<=high)
        {
            mid =low+(high-low)/2;
            if(n-mid<=citations[mid])
            {
                high=mid-1;;
            }
            else
            {
                low=mid+1;
            }
        }
        return n-low;
    }
}