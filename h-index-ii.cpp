// Using Binary Search
class Solution {
public:
    int hIndex(vector<int>& citations) {
        int low = 0;
        int high = citations.size()-1;
        while(low <= high) {
            int mid = low + ((high-low)/2);
            int diff = citations.size()-mid;
            if(diff == citations[mid])
                return diff;
            else if(diff < citations[mid])
                high = mid-1;
            else 
                low = mid+1;
        }
        return citations.size()-low;
    }
};

class Solution {
public:
    int hIndex(vector<int>& citations) {
        if(citations.size() == 0) return 0;
        for(int i = 0; i < citations.size(); i++) {
            int diff = citations.size()-i;
            if(diff <= citations[i])
                return diff;
        }
        return 0;
    }
};
