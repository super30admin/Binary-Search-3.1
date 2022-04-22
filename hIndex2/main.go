// worst problem desc ever...
// time: o(logn)
// space: o(1)
func hIndex(citations []int) int {
    left := 0
    right := len(citations)-1
    n := len(citations)
    for left <= right {
        mid := left+(right-left)/2
        if n-mid == citations[mid] {
            return n-mid
        } else if citations[mid] > n-mid {
            right = mid-1
        } else {
            left = mid+1
        }
    }
    return n-left
}
