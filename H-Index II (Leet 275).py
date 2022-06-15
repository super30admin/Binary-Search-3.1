# Linear Appraoch
# Time: O(n)
# Space: O(1)

class Solution:
    def hIndex(self, citations):
        
        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        
        for i in range(n):
            diff = n - i
            if citations[i] >= diff:
                return diff
        return 0


# Binary Search Approach
# Time: O(logn)
# Space: O(1)

class Solution:
    def hIndex(self, citations):
        
        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        l = 0
        r = n - 1
        
        while l <= r:
            m = l + (r-l)//2
            diff = n - m
            if citations[m] == diff:
                return diff
            elif citations[m] > diff:
                r = m - 1
            else:
                l = m + 1
        return n - l