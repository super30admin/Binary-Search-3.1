# Find the most efficient routes (max 7000)

# Similar to two sum but here we have two arrays and we can't use hashmap approach as it needs exact match (but we need nearest or exact match)

list1 = [[1,1000],[2,1500],[3,2000],[4,3500],[5,4500],[6,5000]]
list2 = [[1,2500],[2,3000],[3,3500],[4,4000],[5,4500],[6,5000]]

# Linear Approach
# Time: O(n^2)

maxim = 0
res = list()

for i in range(len(list1)):
    for j in range(len(list2)):
        val = list1[i][1] + list2[j][1]
        if val > maxim and val <= 7000:
            maxim = val
            res = list()
        
        if val == maxim:
            res.append([i+1,j+1])

print(res)




# Binary Search Approach
# Time: O(m logn), where m is the length of the list with lesser elements

maxim = 0
res = list()

# for closest element
def binary_search(target, li):
    l = 0
    r = len(li) - 1

    while l <= r:
        m = l + (r - l) // 2
        if li[m][1] == target:
            return m
        else:
            if li[m][1] > target:
                r = m - 1
            else:
                l = m + 1
    return l - 1 if l != 0 else l


for j in range(len(list1)):
    target = 7000 - list1[j][1]
    i = binary_search(target, list2)
    print(i)
    print(list2[i], target)


    val = list2[i][1] + list1[j][1]
    if val > maxim and val <= 7000:
        maxim = val
        res = list()

    if val == maxim:
        res.append([i + 1, j + 1])

print(res)
