bool compare(vector<int> a, vector<int> b){
    return a[1]<b[1];
}
vector<vector<int>> getPairs(vector<vector<int>> a, vector<vector<int>> b, int target){
vector<vector<int>> res;
sort(a.begin(),a.end(),compare);    //O(nlogn)
sort(b.begin(),b.end(),compare);
int left=0,right=b.size()-1;
int maxSum=INT_MIN;
while(left<a.size() && right>=0){    // O(m+n)
    int tmp=a[left][1]+b[right][1];
    if(tmp>target){
        right--;
    } else{
        if(maxSum<=tmp){
            if(maxSum<tmp){  // move as close as possible to target
                maxSum=tmp;
                res.clear();  // rest res since find new closer pair
            }
          // push current closer pair to result
            res.push_back({a[left][0],b[right][0]});
          // check duplicate of vector b
            int index=right-1;
            while(index>=0 && b[index][1]==b[right][1]){
                res.push_back({a[left][0],b[index--][0]});
            }
        }
        left++;
    }
}
return res;
  }