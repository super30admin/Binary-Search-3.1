"""
TC: O(nlogn+mlogm) for sorting, O(N log M) for finding the optimal routes, hence O(N log N+ M log M+ O(N log M)
SC: O(1) since no extra space is used
Logic:
We sort both the arrays and then using the forward array find the maximum possible distance that can be covered using
rem = max_dist-forward[i][1]
Then do a binary search on backward array.
In the binary search, find greatest smaller value than the rem and return
Then figure out if this new value is equal/greater than previously computed values
"""
def max_air_time(forward, backward, max_dist):
    forward.sort(key=lambda x: x[1])
    backward.sort(key=lambda x: x[1])
    res = []
    max_sum = 0
    for i in range(len(forward)):
        rem = max_dist-forward[i][1]
        temp = find_nearest(rem, backward)
        if temp != -1:
            v1 = forward[i][1]
            v2 = backward[temp][1]
            temp_sum = v1 + v2
            if temp_sum > max_sum:
                max_sum = temp_sum
                res = [[forward[i][0], backward[temp][0]]]
            elif temp_sum == max_sum:
                res.append([forward[i][0], backward[temp][0]])
    return res if len(res)>0 else [[]]


def find_nearest(val, backward):
    l = 0
    h = len(backward) - 1
    curr = -1
    while (l <= h):
        m = l + (h - l) // 2
        if backward[m][1] <= val:
            curr = m
            l = m + 1
        else:
            h = m - 1
    return curr

if __name__=='__main__':
    f = [[1,2000],[2,4000],[3,6000]]
    b = [[1,2000]]
    maxD = 7000
    print(max_air_time(f,b,maxD))
    maxTravelDist = 10000
    forwardRouteList = [[1, 3000], [2, 5000], [3, 7000], [4, 10000]]
    returnRouteList = [[1, 2000], [2, 3000], [3, 4000], [4, 5000]]
    print(max_air_time(forwardRouteList, returnRouteList, maxTravelDist))
    maxTravelDist = 10000
    forwardRouteList = []
    returnRouteList = [[1, 5000]]
    print(max_air_time(forwardRouteList, returnRouteList, maxTravelDist))
