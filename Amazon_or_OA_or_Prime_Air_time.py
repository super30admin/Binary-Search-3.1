# Time Complexity : O(m log m + n log n), for sorting the two lists
# Space Complexity : O(k), where k is the number of optimal pairs found
# Did this code successfully run on Leetcode : Not directly available, but passed all test cases from discussion
# Any problem you faced while coding this : Handling duplicate distances correctly and collecting all valid pairs

# I sorted both route lists by distance and used a two-pointer approach.
# For each valid sum (≤ maxTravelDist), I kept track of the max found so far.
# I collected all pairs that matched this max total distance, including handling duplicates on both sides.

from typing import List

class Solution:
    def optimalUtilization(self, maxTravelDist: int,
                           forwardRouteList: List[List[int]],
                           returnRouteList: List[List[int]]) -> List[List[int]]:
        
        # Sort both lists by distance
        forwardRouteList.sort(key=lambda x: x[1])
        returnRouteList.sort(key=lambda x: x[1])

        i = 0
        j = len(returnRouteList) - 1
        max_sum = float('-inf')
        result = []

        while i < len(forwardRouteList) and j >= 0:
            sum_dist = forwardRouteList[i][1] + returnRouteList[j][1]

            if sum_dist > maxTravelDist:
                j -= 1
            else:
                if sum_dist > max_sum:
                    max_sum = sum_dist
                    result = []

                if sum_dist == max_sum:
                    # Handle duplicates in returnRouteList
                    index = j
                    while index >= 0 and returnRouteList[index][1] == returnRouteList[j][1]:
                        result.append([forwardRouteList[i][0], returnRouteList[index][0]])
                        index -= 1

                i += 1

        return result if result else [[]]


s = Solution()
print(s.optimalUtilization(
    7000,
    [[1, 2000], [2, 4000], [3, 6000]],
    [[1, 2000]]
))
# Output: [[2, 1]]
