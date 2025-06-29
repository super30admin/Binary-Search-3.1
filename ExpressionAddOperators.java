
//Approach: Brute force recursion

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, 0, "", 0l,0l,target, result);
        return result;
    }

    private void helper(String num, int pivot, String path, long calc, long tail, int target, List<String> result){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(path);
            }
            return;
        }

        //logic
        for(int i = pivot; i < num.length(); i++){
            //preceding 0;
            if(num.charAt(pivot) == '0' && i != pivot)
                return;
            long curr = Long.parseLong(num.substring(pivot, i+1));
         
            if(pivot == 0){ //at this level i.e first level, we don't have option to add operator
                helper(num, i+1, path + curr, curr, curr, target, result);
            }else{
                //+
                helper(num, i+1, path +"+"+curr, calc + curr, +curr, target, result);

                //-
                helper(num, i+1, path +"-"+curr, calc - curr, -curr, target, result);

                //*
                helper(num, i+1, path +"*"+curr, calc -tail+tail* curr, tail*curr, target, result);
            }
        
        }
    }
}

//Approach: Using backtrack solution
//Time Complexity: O(4^n)
//Space Complexity: O(4^n *  n) here 4^n - number of expressions , n - avg length per expression

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, 0, new StringBuilder(), 0l,0l,target, result);
        return result;
    }

    private void helper(String num, int pivot, StringBuilder path, long calc, long tail, int target, List<String> result){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(path.toString());
            }
            return;
        }

        //logic
        for(int i = pivot; i < num.length(); i++){
            //preceding 0;
            if(num.charAt(pivot) == '0' && i != pivot)
                return;
            long curr = Long.parseLong(num.substring(pivot, i+1));
            int l = path.length();
         
            if(pivot == 0){ //at this level i.e first level, we don't have option to add operator
                //action
                path.append(curr);
                //recurse
                helper(num, i+1, path, curr, curr, target, result);
                //backtrack
                path.setLength(l);
            }else{
                //+
                //action
                path.append('+');
                path.append(curr);
                //recurse
                helper(num, i+1, path, calc + curr, +curr, target, result);
                //backtrack
                path.setLength(l);

                //-
                //action
                path.append('-');
                path.append(curr);
                //recurse
                helper(num, i+1, path, calc - curr, -curr, target, result);
                //backtrack
                path.setLength(l);

                //*
                //action
                path.append('*');
                path.append(curr);
                //recurse
                helper(num, i+1, path, calc -tail+tail* curr, tail*curr, target, result);
                //backtrack
                path.setLength(l);
            }
        
        }
    }
}