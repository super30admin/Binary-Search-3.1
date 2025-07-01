// ## Problem1
// Optimize Air Routes (https://leetcode.com/discuss/interview-question/1025705/Amazon-or-OA-or-Prime-Air-time/824897) 

function optimizeRoutes(forwardRoutes, returnRoutes, maxTravelDist) {
    // Sort both lists by cost
    //O(N log M) = TC
    // O(1) = SC
    forwardRoutes.sort((a, b) => a.cost - b.cost);
    returnRoutes.sort((a, b) => a.cost - b.cost);

    let maxSum = -Infinity;
    let result = [];

    function binarySearch(target) {
        let low = 0, high = returnRoutes.length - 1;
        let bestIdx = -1;
        while (low <= high) {
            let mid = Math.floor((low + high) / 2);
            if (returnRoutes[mid].cost <= target) {
                bestIdx = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return bestIdx;
    }

    for (let i = 0; i < forwardRoutes.length; i++) {
        let forward = forwardRoutes[i];
        let target = maxTravelDist - forward.cost;

        let idx = binarySearch(target);
        if (idx !== -1) {
            let total = forward.cost + returnRoutes[idx].cost;

            if (total > maxSum) {
                maxSum = total;
                result = [ [forward.id, returnRoutes[idx].id] ];
            } else if (total === maxSum) {
                result.push([forward.id, returnRoutes[idx].id]);
            }
        }
    }

    return result;
}

// function optimizeRoutes(forwardRoutes, returnRoutes, maxTravelDist) {
//**Two Pointer Sol */
//TC : O(N + M)
//SC : O(1)
//     forwardRoutes.sort((a, b) => a.cost - b.cost);
//     returnRoutes.sort((a, b) => a.cost - b.cost);

//     let i = 0;
//     let j = returnRoutes.length - 1;
//     let maxSum = -Infinity;
//     let result = [];

//     while (i < forwardRoutes.length && j >= 0) {
//         const sum = forwardRoutes[i].cost + returnRoutes[j].cost;

//         if (sum > maxTravelDist) {
//             j--; // reduce sum
//         } else {
//             if (sum > maxSum) {
//                 maxSum = sum;
//                 result = [ [forwardRoutes[i].id, returnRoutes[j].id] ];
//             } else if (sum === maxSum) {
//                 result.push([forwardRoutes[i].id, returnRoutes[j].id]);
//             }

//             // check for duplicates in returnRoutes with same cost
//             let k = j - 1;
//             while (k >= 0 && returnRoutes[k].cost === returnRoutes[j].cost) {
//                 if (forwardRoutes[i].cost + returnRoutes[k].cost === maxSum) {
//                     result.push([forwardRoutes[i].id, returnRoutes[k].id]);
//                 }
//                 k--;
//             }

//             i++; // try next forward route
//         }
//     }

//     return result;
// }
