class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        left, right = 0,n-1
        while left <= right:
            mid = right-left
            if citations[mid] == n-mid:
                return n-mid
            if citations[mid] < n-mid:
                left = mid + 1
            else:
                right = mid  - 1 
        return n-left
    
#TC: O(log(n))