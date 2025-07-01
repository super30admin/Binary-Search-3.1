// https://leetcode.com/discuss/interview-question/1025705/Amazon-or-OA-or-Prime-Air-time/824897


// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we know the input is sortted so like we use two pinters and try to bring sum as close to input distance as possible 

import java.util.*;

public class Problem1 {
    public List<List<Integer>> getOptimalRoutePairs(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList) {
        List<List<Integer>> result = new ArrayList<>();
        int maxSoFar = Integer.MIN_VALUE;

        int i = 0; 
        int j = returnRouteList.length - 1; 

        while (i < forwardRouteList.length && j >= 0) {
            int sum = forwardRouteList[i][1] + returnRouteList[j][1];

            if (sum > maxTravelDist) {
                j--;
            } else {
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                    result.clear(); 
                    result.add(Arrays.asList(forwardRouteList[i][0], returnRouteList[j][0]));
                } else if (sum == maxSoFar) {
                    result.add(Arrays.asList(forwardRouteList[i][0], returnRouteList[j][0]));
                }

                // if there are enteries with same distance
                int temp = j;
                while (temp - 1 >= 0 && returnRouteList[temp - 1][1] == returnRouteList[j][1]) {
                    if (sum == maxSoFar) {
                        result.add(Arrays.asList(forwardRouteList[i][0], returnRouteList[temp - 1][0]));
                    }
                    temp--;
                }

                i++;
            }
        }

        return result;
    }
}
