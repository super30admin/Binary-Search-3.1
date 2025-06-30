# TC: O(nlogn + mlogm)
# SC: O(mn)
def airRoutes(arr1, arr2, capacity):
    arr1.sort(key=lambda x: x[1])
    arr2.sort(key=lambda x: x[1])

    p1 = 0
    p2 = len(arr2) - 1
    closest = -1
    res = []

    while p1 < len(arr1) and p2 >= 0:
        a_id, a_dist = arr1[p1]
        b_id, b_dist = arr2[p2]
        total = a_dist + b_dist

        if total > capacity:
            p2 -= 1
        else:
            if total > closest:
                closest = total
                res = []

            if total == closest:
                temp_p2 = p2
                while temp_p2 >= 0 and arr2[temp_p2][1] == b_dist:
                    res.append((a_id, arr2[temp_p2][0]))
                    temp_p2 -= 1

            p1 += 1

    return res
