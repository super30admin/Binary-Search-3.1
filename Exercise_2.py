# S30 Problem #90 
#LeetCode #275 https://leetcode.com/problems/h-index-ii/description/

# Author : Akaash Trivedi
# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# h papers should have atleast h citation
# Arrays is sorted, calculate the diff: all the paper to right would have citations greater than current paper
# check the first index of citations[i] >= n-i that gives H index
# Time Complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        for i in range(n):
            diff = n - i
            if diff <= citations[i]:
                return diff
        return 0
    
# binary search solution

# h papers should have atleast h citation
# Arrays is sorted, perform binary search to find the correct citation
# check the index of citations[i] >= n-i (i.e. mid) that gives H index
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low = 0
        high = n - 1
        while low <= high:
            # to avoid interger overflow
            mid = low + (high - low) // 2
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                low = mid + 1
            else:
                high = mid - 1
        # low is the smallert index where cit[low] >= n -low (this is max h)
        return n - low