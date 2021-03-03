//Time complexity-O()
//Space complexity-O()
//Ran on leetcode-NO
//Solution with comments-couldn't figure the closest distance method
class OptimalUtilization{
    int closest;
    public int[][] pathlist(int target, int[][] forwardPath, int[][] backwardPath){
        int f=forwardPath.length;
        int b= backwardPath.length;
        closest=target;
        if(f>=b){
            for(int i=0;i<b;i++){
                int index=findclosest(forwardPath,backwardPath[i][1],target, i);
            }
        }
        else{
            for(int i=0;i<f;i++){
                int index=findclosest(backwardPath,forwardPath[i][1],target, i);
            }

        }

    }
    public int findclosest(int[][] arr, int val, int target, int avoid){
        int low=0;int high=arr.length;
        int index=0;
        while(low<high){
            int mid=(low+high)/2;
            if(mid !=avoid && (arr[mid][1]+val)>target)
                low=mid+1;
            else if(mid!=avoid && (arr[mid][1]+val<target)){
                    if(arr[mid][1]+val>arr[index][1]+val){
                        index=mid;
                    }
            }
            else if(mid!=avoid && (arr[mid][1]+val==target)
                return mid;

        }
        return index;
    }

    public static void main(String args[]){
       int[][] a = new int[][] {{1, 2}, {2, 4}, {3, 6}};
       int[][] b = new int[][]{{1, 2}};
       int target = 7;

       OptimalUtilization obj = new OptimalUtilization();
      int[][] result= obj.pathlist(target, a, b);
      for(int i=0;i<result.length;i++){
                for(int j: result[i]){
                System.out.print(j +" ");
            }
            System.out.println();
        }
     

    }

}
