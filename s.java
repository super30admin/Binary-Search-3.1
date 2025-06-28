import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int h = n - mid;
            if (citations[mid] == h) {
                return h;
            } else if (citations[mid] < h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return n - left;
    }

    //
    public List<List<Integer>> optimizeAirRoutes(int maxTravelDist, List<List<Integer>> forwardRouteList,
            List<List<Integer>> returnRouteList) {
        List<List<Integer>> result = new ArrayList<>();

        if (forwardRouteList == null || returnRouteList == null ||
                forwardRouteList.isEmpty() || returnRouteList.isEmpty()) {
            return result;
        }

        // Sort both lists by distance for efficient searching
        forwardRouteList.sort((a, b) -> a.get(1) - b.get(1));
        returnRouteList.sort((a, b) -> a.get(1) - b.get(1));

        int maxSum = -1;

        // Try each forward route
        for (List<Integer> forward : forwardRouteList) {
            int forwardId = forward.get(0);
            int forwardDist = forward.get(1);

            // Find the best return route for this forward route
            int targetReturnDist = maxTravelDist - forwardDist;

            if (targetReturnDist < 0) {
                continue; // This forward route is too long
            }

            // Binary search to find the largest return route <= targetReturnDist
            int bestReturnIndex = binarySearch(returnRouteList, targetReturnDist);

            if (bestReturnIndex != -1) {
                int returnId = returnRouteList.get(bestReturnIndex).get(0);
                int returnDist = returnRouteList.get(bestReturnIndex).get(1);
                int totalDist = forwardDist + returnDist;

                if (totalDist > maxSum) {
                    // Found a better combination
                    maxSum = totalDist;
                    result.clear();
                    result.add(Arrays.asList(forwardId, returnId));
                } else if (totalDist == maxSum) {
                    // Found another combination with the same optimal distance
                    result.add(Arrays.asList(forwardId, returnId));
                }
            }
        }

        return result;
    }

    // Binary search to find the largest distance <= target
    private int binarySearch(List<List<Integer>> routeList, int target) {
        int left = 0;
        int right = routeList.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentDist = routeList.get(mid).get(1);

            if (currentDist <= target) {
                result = mid;
                left = mid + 1; // Try to find a larger one
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
//
