//time complexity- O((m+n)log(m)) where m is the length of backward and n is the length of forward
//space complexity- O(1)

import java.util.*;
public class OptimizeAirRoutes {
    static List<int[]> optimalAirRoute(int[][]forward,int[][] backward, int target){
        List<int[]> sol = new ArrayList<>();

        int max = 0;
        Arrays.sort(backward,(a,b)->(a[1]-b[1]));
        for(int i = 0; i < forward.length; i++) {
            int ind = binarySearch(backward, target - forward[i][1]);
            if(ind != -1 && forward[i][1]+backward[ind][1] >= max) {
                if(forward[i][1]+backward[ind][1] > max) {
                    sol = new ArrayList<>();
                }
                max = Math.max(max, forward[i][1]+backward[ind][1]);
                sol.add(new int[] {forward[i][0], backward[ind][0]});
            }
        }

        return sol;
    }
    private static int binarySearch(int[][] backward, int target) {
        int start = 0;
        int end = backward.length - 1;
        int ind = -1;
        while (start <= end) {
            int mid  = start + (end - start) / 2;
            if(backward[mid][1] <=  target) {
                ind = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ind;
    }
    public static void main(String[] args) {
        int[][] forward = {{0, 1000}, {1, 2500}, {2,3500}, {3, 4000}, {4, 5000}, {5, 6000}};
        int[][] backward = {{0, 500}, {1, 1500}, {2, 2000}, {3, 4500}, {4, 5000}, {5, 5500}, {6, 7000}};
        int target = 7000;

        System.out.println("Optimized Routes can be:" );
        List<int[]> routes = optimalAirRoute(forward, backward, target);
        for(int [] r : routes) {
            System.out.println(Arrays.toString(r));
        }
    }
}
