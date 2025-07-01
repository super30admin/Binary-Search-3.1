// ## Problem2
// H-Index II (https://leetcode.com/problems/h-index-ii)

var hIndex = function(citations) {
    //Tc: log n
    //sc : constant
    const n = citations.length;
    let left = 0;
    let right = n - 1;
    
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        const h = n - mid;
        
        if (citations[mid] >= h) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    
    return n - left;
};

console.log(hIndex([1,4,5,6]))

// var hIndex = function(citations) {
//     //TC : O(N)
//     //SC : O(1)
//     const n = citations.length;
//     let hIndex = 0;
    
//     for (let i = n - 1; i >= 0; i--) {
//         const currentH = n - i; // Number of papers from i to end
//         if (citations[i] >= currentH) {
//             hIndex = currentH;
//         } else {
//             break; // No need to check further
//         }
//     }
    
//     return hIndex;
// };