# ----------------------------------------------------
# Intuition:
# We are given a sorted list of citations. The h-index is the highest number h
# such that the researcher has at least h papers with at least h citations each.
#
# 1. Brute Force (Naive):
#    For every possible h from 0 to n, count how many citations are ≥ h.
#    If that count ≥ h, it's a valid h-index.
#    → Time: O(n²), Space: O(1)
#
# 2. Optimal (Binary Search):
#    Since citations are sorted in ascending order, we can binary search the
#    first index where citations[mid] ≥ n - mid.
#    That means there are (n - mid) papers with at least citations[mid] citations.
#    → h-index = n - left
#    → Time: O(log n), Space: O(1)
# ----------------------------------------------------

from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        left, right = 0, n - 1
        
        while left <= right:
            mid = (left + right) // 2
            if citations[mid] >= n - mid:
                right = mid - 1
            else:
                left = mid + 1
        
        return n - left

# ----------------------------------------------------
# Brute Force (Commented):
# Time: O(n^2), Space: O(1)
# ----------------------------------------------------

# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         n = len(citations)
#         res = 0
#         for i in range(1, n + 1):
#             count = 0
#             for j in range(n):
#                 if citations[j] >= i:
#                     count += 1
#             if count >= i:
#                 res = i
#         return res

# ----------------------------------------------------
# Example Usage:
# ----------------------------------------------------

if __name__ == "__main__":
    sol = Solution()
    print(sol.hIndex([0, 1, 3, 5, 6]))     # Output: 3
    print(sol.hIndex([1, 2, 100]))         # Output: 2
    print(sol.hIndex([0, 0, 0]))           # Output: 0
    print(sol.hIndex([0, 1, 2, 4, 5, 6]))  # Output: 3
