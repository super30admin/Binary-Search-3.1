"""
Approach: since the input is sorted we can solve it using 2 pointers and move the pointers to get the min diff result.
t.c. => O(m + 1)
s.c. => O(1)
"""
def main():
    maxTravelDist = 7000 
    forwardRouteList = [[1,2000],[2,4000],[3,6000]] 
    returnRouteList = [[1,2000]]
    fLen, rLen = len(forwardRouteList), len(returnRouteList)
    l,r = 0, rLen - 1
    
    minDiff = float("inf")
    lIdx, rIdx = -1, -1
    while r >= 0 and l <= fLen:
        sums = (forwardRouteList[l][1] + returnRouteList[r][1])
        if sums == maxTravelDist:
            return [forwardRouteList[l][0], returnRouteList[r][0]]
        
        diff = abs(sums - maxTravelDist)
        if diff < minDiff:
            lIdx, rIdx = forwardRouteList[l][0], returnRouteList[r][0]
            minDiff = diff

        if sums < maxTravelDist:
            l += 1
        else:
            r -= 1
    return [lIdx, rIdx]
if __name__ == "__main__":
    print(main())