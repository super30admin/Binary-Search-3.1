# S30 Problem #89 Optimization of routes
#LeetCode # https://leetcode.com/discuss/post/1025705/amazon-oa-prime-air-time-by-anonymous_us-y1gu/

# Playground https://leetcode.com/playground/CcvEfjKf

# Author : Akaash Trivedi
# Time Complexity : O(n+m)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

def optimizeAirRoutes(maxDist: int, forwardRouteList: List[List[int]], returnRouteList: List[List[int]]) -> List[List[int]]:
    # TODO: Implement this function
    # first pointer on forward start
    start = 0
    #second pointer on end of return
    end = len(returnRouteList) - 1
    res = []
    # track max dist so far
    maxUsed = -1
    while start < len(forwardRouteList) and end >= 0:
        currDist = forwardRouteList[start][1] + returnRouteList[end][1]
        
        if currDist > maxDist:
            end -= 1
        else: # currDist <= maxDist
            if currDist > maxUsed:
                # if we find new optimal distance
                res = [] # clear the existing result
                res.append([forwardRouteList[start][0], returnRouteList[end][0]]) # add new
                maxUsed = currDist # update new optimal distance
            elif currDist == maxUsed:
                res.append([forwardRouteList[start][0], returnRouteList[end][0]])
            start +=1

    return res if res else [[]]

# === Test Cases ===

print(optimizeAirRoutes(
    7000,
    [[1, 2000], [2, 4000], [3, 6000]],
    [[1, 2000]]
))  # Expected: [[2, 1]]

print(optimizeAirRoutes(
    10000,
    [[1, 3000], [2, 5000], [3, 7000], [4, 10000]],
    [[1, 2000], [2, 3000], [3, 4000], [4, 5000]]
))  # Expected: [[2, 4], [3, 2]]

print(optimizeAirRoutes(
    5000,
    [[1, 8000]],
    [[1, 2000]]
))  # Expected: [[]]

print(optimizeAirRoutes(
    10000,
    [[1, 7000]],
    [[1, 3000], [2, 3000]]
))  # Expected: [[1, 1], [1, 2]]
