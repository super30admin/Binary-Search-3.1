// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// create an hashmap if sum and its pair
// Your code here along with comments explaining your approach
public class OptimalUtilization{
    public List<int[]> solution(List<int[]> a, List<int[]> b, int target){
        //key is sum , value is list of ids from a and b.
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < a.size(); i ++){
            for (int j = 0; j < b.size(); j ++){
                List<int[]> sums = map.getOrDefault(a.get(i)[1] + b.get(j)[1], new ArrayList<int[]>());
                sums.add(new int[] {a.get(i)[0], b.get(j)[0]});
                map.put(a.get(i)[1] + b.get(j)[1], sums);
            }
        }

        List<Integer> allSums = new ArrayList<>();
        for (Integer i : map.keySet()){
            if (i < target){
                allSums.add(i);
            } else if (i == target){
                return map.get(target);
            }
        }
        if (allSums.size() == 0){
            //target is less than every possible sums
            return new ArrayList<>();
        }
        return map.get(Collections.max(allSums));
    }
}