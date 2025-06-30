# Time Complexity: O(nlogn + mlogm + nlogm)
# Space Complexity: O(n + m)
# where n is the number of forward routes and m is the number of return routes.

class Solution:
    def OptimizedAir(self, maxTravelDist, forwardRouteList, returnRouteList):
        forwardRouteList.sort(key=lambda x: x[1])  # Sort by travel distance
        returnRouteList.sort(key=lambda x: x[1])  # Sort by travel distance
        maxDist = -1
        maxDistList = []

        for forwardRoute in forwardRouteList:
            compliment = maxTravelDist - forwardRoute[1]
            nearest = self.getNearestDist(returnRouteList, compliment)

            if nearest != -1:
                totalDist = forwardRoute[1] + returnRouteList[nearest][1]
                if totalDist >= maxDist:
                    if totalDist > maxDist:
                        maxDistList = []
                        maxDist = totalDist
                    maxDistList.append([forwardRoute[0], returnRouteList[nearest][0]])
        return maxDistList
    def getNearestDist(self, returnRouteList, compliment):
        low = 0
        high = len(returnRouteList) - 1
        nearest = -1

        while low <= high:
            mid = (low + high) // 2
            if returnRouteList[mid][1] == compliment:
                return mid
            elif returnRouteList[mid][1] < compliment:
                nearest = mid
                low = mid + 1
            else:
                high = mid - 1

        return nearest

if __name__ == '__main__':
	oa = Solution()


	print(oa.OptimizedAir(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
	print(oa.OptimizedAir(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))
	print(oa.OptimizedAir(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
	print(oa.OptimizedAir(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))
	print(oa.OptimizedAir(7000, [[1,2000],[2,4000],[3,6000]], [[1,2000]]))
	print(oa.OptimizedAir(10000, [[1,3000],[2,5000],[3,7000],[4,10000]], [[1,2000],[2,3000],[3,4000],[4,5000]]))