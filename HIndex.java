public class HIndex {
    //https://leetcode.com/problems/h-index-ii/
    /*PS
    array of  citations is given find the index of that citation which satisfies 2 conditions
    1 for h index there should be h or more citations
    2 n-h papers should  have no more than h citations
    Brute Force
    TC - O(n)
    SC - O(1)

Binary Search
array is sorted and we need to search one number therefore BS
if arr.length-index == arr[index] then return arr.length -mid

TC - O(logn)
SC - O(1)
     */
    public static void main(String[] args) {
int[] citations = {0,1,3,5,6};
        System.out.println(hIndex(citations));
    }
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int low =0 ;
        int high = citations.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(citations[mid]== citations.length-mid) return citations.length-mid;
            else if (citations[mid]<citations.length-mid)  low=mid+1;
            else high = mid-1;
        }
        return citations.length-low;
    }



}
