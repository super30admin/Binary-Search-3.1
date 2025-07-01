//time complexity- O(log(n))
//space complexity- O(1)
public class HIndexTwo {
    static int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(citations[mid] == n-mid) return n-mid;

            if(citations[mid] < n-mid) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return n-low;
    }
    public static void main(String[] args) {
        int[] citations = {0,1,3,5,6};

        System.out.println("The H-index is:" + hIndex(citations));
    }
}
