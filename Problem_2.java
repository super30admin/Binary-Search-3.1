// Time Complexity : O()
// Space Complexity :O()
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// condition to check
// here n is total length of an array - index
// check n number of paper who is having more than its n number of its citations
// And N-n numbers of paper is having less then or equal to n citations
// here N is total lenght of an array - (n which is total lenght of an array - index)
// actual method
// find the mid and check the condition and if n is more then its number( whose value is n, the  number at that index) then move right(low = mid + 1). and if n is less then its number the  move to left (high = mid - 1)
// Your code here along with comments explaining your approach

// using binary  search
class Solution {
    public int hIndex(int[] citations) {
        if( citations == null || citations.length == 0) return 0;
        int n = citations.length;
        int low = 0; int high = n-1;
        while( low <= high ){
            int mid = low + (high-low) / 2;
            if(citations[mid] == n-mid){
                return n-mid;
            }else if(citations[mid] > n-mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return n - low;
    }
}


// using linear search

// class Solution {
//     public int hIndex(int[] citations) {
//         if( citations == null || citations.length == 0) return 0;
//         int n = citations.length;
//         for(int i = 0; i < n; i++){
//             if(citations[i] >= n-i){
//                 return n-i;
//             }
//         }
//         return 0;
//     }
// }