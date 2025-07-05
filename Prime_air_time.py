# Approach:
# ---------
# 1. Sort both forwardRouteList and returnRouteList based on distance.
# 2. For each forward route:
#    a. Compute the remaining distance = maxTravelDist - forward_distance
#    b. Use binary search to find the return route with the highest distance ≤ remaining
# 3. Track the maximum total distance found so far.
# 4. If a new better pair is found, reset result list.
# 5. If a tie is found for the max, append to result list.

# Time Complexity: O(n log m + m log m)
# - n = len(forwardRouteList), m = len(returnRouteList)
# - O(log m) binary search for each of n elements + sorting
#
# Space Complexity: O(1) extra space (excluding output list)

class Solution:
    def OptimizeAir(self, maxTravelDist, forwardRouteList, returnRouteList):
        forwardRouteList.sort(key = lambda x: x[1])
        returnRouteList.sort(key = lambda x: x[1])
        
        maxDist = -1
        maxDistList = []
        
        for i in forwardRouteList:
            comp = maxTravelDist - i[1]
            nearest = self.getNearestDist(returnRouteList, comp)
            if nearest != -1:
                totalDist = i[1] + returnRouteList[nearest][1]
                if totalDist >= maxDist:
                    if totalDist > maxDist:
                        maxDistList = []
                        maxDist = totalDist
                    maxDistList.append((i[0], returnRouteList[nearest][0]))
        return maxDistList
    
    def getNearestDist(self, arr, target):
        l, h = 0, len(arr) - 1
        nearest = -1
        while l <= h:
            mid = l + (h - l)//2
            if arr[mid][1] == target:
                return mid
            elif arr[mid][1] > target:
                h = mid - 1
            else:
                nearest = mid
                l = mid + 1
        return nearest

def main():
    sol = Solution()

    print("Test Case 1:")
    print(sol.OptimizeAir(7000, [[1, 2000], [2, 4000], [3, 6000]], [[1, 2000]]))
    # Expected: [[2, 1]]

    print("\nTest Case 2:")
    print(sol.OptimizeAir(10000, [[1, 3000], [2, 5000], [3, 7000], [4, 10000]],
                        [[1, 2000], [2, 3000], [3, 4000], [4, 5000]]))
    # Expected: [[2, 4], [3, 2]]

    print("\nTest Case 3 (No pair possible):")
    print(sol.OptimizeAir(1000, [[1, 2000]], [[1, 2000]]))
    # Expected: []

if __name__ == "__main__":
    main()