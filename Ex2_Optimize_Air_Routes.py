   # ----------------------------------------------------
    # Intuition:
    # Given two arrays of pairs [id, value], find pairs whose values sum up
    # to less than or equal to the target and are as close to target as possible.
    #
    # 1. Optimal Two Pointers:
    #    Sort both arrays by value.
    #    Use two pointers: one at start of arr1, one at end of arr2.
    #    Move pointers to find sums ≤ target and track max sum and pairs.
    #    → Time: O(n log n + m log m + n + m)
    #    → Space: O(k), k = number of pairs in result
    #
    # 2. Brute Force (Naive):
    #    Check all possible pairs and track max sum ≤ target.
    #    → Time: O(n*m)
    #    → Space: O(k)
    # ----------------------------------------------------

    # ----------------------------------------------------
    # Optimal Two Pointers Approach (Uncommented)
    # ----------------------------------------------------


from typing import List

class Solution:

    def closestPairs(self, arr1: List[List[int]], arr2: List[List[int]], target: int) -> List[List[int]]:
        arr1.sort(key=lambda x: x[1])
        arr2.sort(key=lambda x: x[1])

        res = []
        max_sum = float("-inf")

        i, j = 0, len(arr2) - 1

        while i < len(arr1) and j >= 0:
            val1 = arr1[i][1]
            val2 = arr2[j][1]
            total = val1 + val2

            if total > target:
                j -= 1
            else:
                if total > max_sum:
                    max_sum = total
                    res = [[arr1[i][0], arr2[j][0]]]
                elif total == max_sum:
                    res.append([arr1[i][0], arr2[j][0]])
                i += 1

        return res

    # ----------------------------------------------------
    # Brute Force Approach (Commented)
    # ----------------------------------------------------
    # def closestPairs(self, arr1: List[List[int]], arr2: List[List[int]], target: int) -> List[List[int]]:
    #     max_sum = float("-inf")
    #     res = []
    #
    #     for id1, val1 in arr1:
    #         for id2, val2 in arr2:
    #             total = val1 + val2
    #             if total <= target:
    #                 if total > max_sum:
    #                     max_sum = total
    #                     res = [[id1, id2]]
    #                 elif total == max_sum:
    #                     res.append([id1, id2])
    #
    #     return res


# ----------------------------------------------------
# Example Usage:
# ----------------------------------------------------
if __name__ == "__main__":
    sol = Solution()

    print(sol.closestPairs([[1, 1000], [2, 2000], [3, 3000]],
                           [[1, 2000], [2, 1000], [3, 3000]],
                           4000))  # Expected: [[1, 3], [2, 1], [3, 2]]

    print(sol.closestPairs([[1, 3000], [2, 2000], [3, 4000], [4, 2000]],
                           [[1, 2000], [2, 3000], [3, 1000], [4, 2000]],
                           5000))  # Expected: multiple pairs

    print(sol.closestPairs([[1, 7000], [2, 8000]],
                           [[1, 9000], [2, 8500]],
                           10000))  # Expected: []

    print(sol.closestPairs([[1, 3000]], [], 5000))  # Expected: []

    print(sol.closestPairs([[1, 3000], [2, 3000], [3, 3000]],
                           [[1, 2000], [2, 2000]],
                           5000))  # Expected: all combinations of 3000 + 2000
