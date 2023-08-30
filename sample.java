//Problem 1 Optimization of Routes
// Time Complexity :O()
// Space Complexity :O()
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

//Problem 2 H Index 1
// Time Complexity :O(2n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//Use bucket sort to sort citations array. check where we have an overlap of number of papers and citations. that is our H index
class Solution {
    //O(2n) //O(n)
    public int hIndex(int[] citations) {
        int n=citations.length;

        int[] bucket= new int[n+1];

        for(int el: citations){
            if(el>=n)
                bucket[n]++;
            else
                bucket[el]++;
        }

        int sum=0;

        for(int i=n;i>=0;i--){
            sum+=bucket[i];

            if(i<=sum)
                return i;
        }

        return 0;
    }
}