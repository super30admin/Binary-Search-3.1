# Approach:
# Optimal Two Pointers:
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

def closestPairs(arr1,arr2,target):
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
