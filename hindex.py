"""
TC: O(log N)
SC: O(1)

Use binary search to find n-mid. if found return that. lese adjust l and h. If not found return n-l as that will be the h index
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        l = 0
        h = n - 1
        h_idx = 0
        while (l <= h):
            mid = l + (h - l) // 2
            if citations[mid] == n - mid:
                return n - mid
            elif citations[mid] < n - mid:
                l = mid + 1
            else:
                h = mid - 1
        return n - l

