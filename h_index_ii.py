# Time Complexity : O(log n), where n is the number of papers
# Space Complexity : O(1), since I used constant extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Since the citations array is sorted, I used binary search to find the h-index.
# The key idea is that at position i, there are (n - i) papers with at least citations[i] citations.
# I looked for the lowest index where citations[i] >= n - i, which gives the maximum valid h.

from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left, right = 0, n - 1

        while left <= right:
            mid = (left + right) // 2
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                left = mid + 1
            else:
                right = mid - 1

        return n - left
