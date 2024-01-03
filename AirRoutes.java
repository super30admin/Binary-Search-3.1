/// Time Complexity :O (m * log(n)) where m is the length of the shorter list and n is the length of the larger list
// Space Complexity :O(k) where k is size of the result list
// Did this code successfully run on Leetcode :N/A
// Any problem you faced while coding this :
import java.util.*;

public class AirRoutes {
    private HashMap<Integer, List<int[]>> map;
    private static class Route{
        private int key;
        private int distance;
        public Route(int key, int distance){
            this.key = key;
            this.distance = distance;
        }

        public int getDistance(){
            return distance;
        }

        public int getKey() {
            return key;
        }
    }

    public List<int[]> optimalAirRoutes(int maxTravelDist, List<Route> forwardRouteList, List<Route> returnRouteList){
        this.map = new HashMap<>();
        int optimalDistanceCovered = 0;
        List<int[]> optimalRoutes = new ArrayList<>();
        Collections.sort(forwardRouteList, Comparator.comparing(Route::getDistance));
        Collections.sort(returnRouteList, Comparator.comparing(Route::getDistance));

//        for(Route f : forwardRouteList){
//            System.out.println(f.getDistance());
//        }
//
//        for(Route r : returnRouteList){
//            System.out.println(r.getDistance());
//        }

       int l1 = forwardRouteList.size();
       int l2 = returnRouteList.size();
       if(l1 > l2){
           return optimalAirRoutes(maxTravelDist, returnRouteList, forwardRouteList);
       }

       //forwardRouteList is the smaller list
        for(Route currentRoute : forwardRouteList){
            int complement = maxTravelDist - currentRoute.getDistance();
            Route returnRoute = binarySearch(complement, returnRouteList);
            if(returnRoute == null){
                continue;
            }
            if(currentRoute.getDistance() + returnRoute.getDistance() >= optimalDistanceCovered){
                optimalDistanceCovered = currentRoute.getDistance() + returnRoute.getDistance();
                if(!map.containsKey(optimalDistanceCovered)){
                    map.put(optimalDistanceCovered, new ArrayList<>());
                }
                int[] newRoute = new int[] {currentRoute.getKey(),returnRoute.getKey()};
                map.get(optimalDistanceCovered).add(newRoute);
            }
        }

        return map.get(optimalDistanceCovered);
    }

    private Route binarySearch(int complement, List<Route> returnRouteList) {
        int[] distances = new int[returnRouteList.size()];
        for(int i=0; i<distances.length; i++){
            distances[i] = returnRouteList.get(i).getDistance();
        }
        int low = 0;
        int high = distances.length -1;

        while(low<high) {
            int mid = low + (high - low) / 2;
            if (distances[mid] == complement) {
                return returnRouteList.get(mid);
            } else if (distances[mid] > complement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(returnRouteList.get(low).getDistance() > complement){
            return null;
        }
        return returnRouteList.get(low);
    }

    public static void main(String[] args) {
        //Example 1: Input: maxTravelDist = 7000 forwardRouteList = [[1,2000],[2,4000],[3,6000]] returnRouteList = [[1,2000]]
        Route route1 = new Route(1, 2000);
        Route route2 = new Route(2, 6000);
        Route route3 = new Route(3, 4000);
        Route route7 = new Route(4, 2300);

        List<Route> forwardRouteList = new ArrayList<>();
        forwardRouteList.add(route1);
        forwardRouteList.add(route2);
        forwardRouteList.add(route3);
        forwardRouteList.add(route7);

        Route route4 = new Route(1, 3000);
        Route route5 = new Route(2, 6000);
        Route route6 = new Route(3, 5000);
        Route route8 = new Route(4, 4700);

        List<Route> returnRouteList = new ArrayList<>();
        returnRouteList.add(route4);
        returnRouteList.add(route5);
        returnRouteList.add(route6);
        returnRouteList.add(route8);

        AirRoutes ar = new AirRoutes();
        List<int[]> result = ar.optimalAirRoutes(9500, forwardRouteList, returnRouteList);
        System.out.println("Optimal routes are: ");

        for(int[] r : result){
            System.out.println(Arrays.toString(r));
        }

    }
}



