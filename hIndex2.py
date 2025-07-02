"""
Approach: we can solve using binary index, go left if citations[mid] > (n - mid) i.e. possibility that we can
find greater hindex to left with where the condition holds else definitely go right since citations[mid] < (n - mid)
as we can for sure find better citations[i] to right
t.c. = O(lg n)
s.c. =O(1)
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        l, r = 0, n - 1
        while l < r:
            mid = l + (r - l)//2
            if citations[mid] < (n - mid):
                l = mid + 1
            else:
                r = mid
        return n - l