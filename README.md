# Binary-Search-3.1

## Problem1

Optimize Air Routes (https://leetcode.com/discuss/interview-question/318918/amazon-online-assessment)

There are 3 things to be known before attempting this problem:
maxTravelDist, it is an integer which represents the maximum operating travel distance of the given aircraft;
forwardRouteList, it is a list of pairs of integers where the first integer represents the unique identifier of a forward shipping route and the second integer represents the amount of travel distance required by this shipping route;
returnRouteList, a list of pairs of integers where the first integer represents the unique identifer of a return shipping route
and the second integer represents the amount of travel distance required by this shipping route.

These three things will be given as an input to you. you need to return a list of pairs of integers representing the pairs of IDs of forward and also return the shipping routes that optimally utilize the given aircraft. If no route is possible, return a list with empty pair.

Example 1:
Input:
maxTravelDist = 7000
forwardRouteList = [[1,2000],[2,4000],[3,6000]]
returnRouteList = [[1,2000]]

Output:
[[2,1]]

Explanation:
There are only three combinations [1,1],[2,1],and [3,1], which have a total of 4000, 6000, and 8000 miles, respectively. Since 6000 is the largest use that does not exceed 7000, [2,1] is the optimal pair.

//Time Complexity = mlogn
//Space Complexity = O(1)

// "static void main" must be defined in a public class.
public class Main {
private static List<List<Integer>> optimalRoutes(int target, int[][] a, int[][] b) {
List<List<Integer>> result = new ArrayList<>();
Arrays.sort(a, (x,y) -> (x[1]-y[1]));
Arrays.sort(b, (x,y) -> (x[1]-y[1]));
int maxDistance = 0;
for(int i =0; i < a.length; i++) {
int r = target - a[i][1];
int index = binarySearch(b,r);
if(index == -1) {
continue;
}
int total = a[i][1] + b[index][1];
if(total > maxDistance) {
maxDistance = total;
result = new ArrayList<>();
}
if(maxDistance == total) {
result.add(new ArrayList<>(Arrays.asList(a[i][0],b[index][0])));
}
}
return result;
}

    private static int binarySearch(int[][] route, int target) {
        int low = 0;
        int high = route.length - 1;

        while(low <= high) {
            int mid = low + (high-low) / 2;

            if(route[mid][1] == target) {
                return mid;
            } else if(route[mid][1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{2,4},{3,6}};
        int[][] b = new int[][]{{1,2}};

        List<List<Integer>> result = optimalRoutes(7,a,b);

        if(result.size()!=0) {
            for(int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i).get(0)+ ", " +result.get(i).get(1));
            }
        }
    }

}

## Problem2

H-Index II (https://leetcode.com/problems/h-index-ii)

//Time Complexity = logn
//Space Complexity = O(1)

class Solution {
public int hIndex(int[] citations) {
int result = 0;
if(citations == null || citations.length == 0) {
return result;
}
int n = citations.length;
int low = 0;
int high = citations.length -1;

        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(citations[mid] == n-mid) {
                return n-mid;
            } else if(citations[mid] < n-mid) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return n-low;
    }

}
