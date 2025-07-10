
# Approach:
# 1. Brute Force (Naive):
#    For every possible h from 0 to n, count how many citations are ≥ h.
#    If that count ≥ h, it's a valid h-index.
#    →Time: O(n²), Space: O(1)

# Since citations are sorted in ascending order, we can binary search the
#    first index where citations[mid] ≥ n - mid.
#    That means there are (n - mid) papers with at least citations[mid] citations.
#     h-index = n - left
#    Time: O(log n), Space: O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        ans=0
        l=len(citations)
        for i in range(l):
            if l-i<=citations[i]:

                return  l-i
        
        return 0
