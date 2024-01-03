/// Time Complexity :O (log(n)) where n is the length of the citations array
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
public class HIndexII {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }

        int low = 0;
        int high = citations.length-1;

        while(low<high){
            int mid = low + (high-low)/2;
            int reverseIndex = citations.length - mid;
            if(citations[mid] == reverseIndex){
                return citations[mid];
            }
            else if(citations[mid] > reverseIndex){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return Math.min(citations[low], citations.length-low);
    }
}
