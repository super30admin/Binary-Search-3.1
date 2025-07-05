# Approach:
# ----------
# This function calculates the h-index from a sorted list of citation counts (ascending).
# h-index is defined as the maximum h such that the researcher has published at least h papers
# that have each been cited at least h times.

# Since the array is sorted in ascending order, we can use **binary search**:
# - At any index `mid`, the number of papers with citations ≥ citations[mid] is `n - mid`.
# - If citations[mid] == n - mid, we've found the h-index.
# - If citations[mid] < n - mid, we need to move right (more papers left to check).
# - If citations[mid] > n - mid, we need to move left (too few papers with high enough citations).

# Time Complexity: O(log n), where n = number of papers
# Space Complexity: O(1), uses constant space


class Solution:
    def hIndex(self, citations):
        n = len(citations)
        left, right = 0, n-1
        
        while left <= right:
            mid = (left + right) // 2
            diff = n - mid
            if diff == citations[mid]:
                return diff
            elif diff > citations[mid]:
                left = mid + 1
            else:
                right = mid - 1
        return n - left

def main():
    sol = Solution()

    # Test case 1
    citations = [0, 1, 3, 5, 6]
    print("Citations:", citations)
    print("H-Index:", sol.hIndex(citations))  # Expected: 3

    # Test case 2
    citations = [0, 2, 4, 6, 8, 10]
    print("\nCitations:", citations)
    print("H-Index:", sol.hIndex(citations))  # Expected: 4

    # Test case 3
    citations = [0, 0, 0, 0]
    print("\nCitations:", citations)
    print("H-Index:", sol.hIndex(citations))  # Expected: 0

    # Test case 4
    citations = [1, 2, 100]
    print("\nCitations:", citations)
    print("H-Index:", sol.hIndex(citations))  # Expected: 2

if __name__ == "__main__":
    main()