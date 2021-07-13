#TC : O(nlogn)
#SC : O(n)

import heapq
class Solution():
    def minRooms(self,arr):
        arr.sort()
        c = 1
        result = []
        end = arr[0][1]
        heapq.heappush(result,end)
        for i in range(1,len(arr)):
            start = arr[i][0]
            endtime = arr[i][1]
            if start< result[0]:
                c+=1
            else:
                heapq.heappop(result)
            heapq.heappush(result,endtime)
            
        return len(result)







obj  = Solution()
arr = [[0,30],[15,20],[5,10],[20,22]]
print(obj.minRooms(arr))