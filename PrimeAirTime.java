import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAirTime {
    /**
     * Two pointer solution: Since both the forward and return routes are sorted, we can efficiently visit all
     * the pairs which can give us maximum route distance covered at or under given maximum travel distance (maxTravelDist).
     * take low pointer at forwardRoute start and high pointer at returnRoute end and calculate its total distance.
     * Also maintain a maximum fuel (maxFuel) for each pair which is a potential result. This will always be at or under maxTravelDist.
     * If total distance for current pair is above given maxTravelDist reduce high pointer, otherwise increase low pointer.
     * In this otherwise case if total fuel is same as previous maxFuel add to the result list, if it is
     * greater than previous maxFuel update maxFuel with it; clear result list to remove previous pairs for lower maxFuel
     * value and add new pair.
     *
     * TC: O(m + n) m -> number of rows in forwardRouteList and n -> number of rows in returnRouteList
     * SC: O(1)
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[][] forwardRouteList = {{1,2000},{2,3000},{3,4000}, {4,6000}};
        int[][] returnRouteList = {{1,1001}, {2,2500}, {3,3500}, {4,4500}, {5,6000}};
        int maxTravelDist = 7000;
        List<List<Integer>> result = findPrimeAirTime(forwardRouteList, returnRouteList, maxTravelDist);
        System.out.println(result);
    }

    private static List<List<Integer>> findPrimeAirTime(int[][] forwardRouteList, int[][] returnRouteList,
                                                        int maxTravelDist) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int maxFuel = 0;

        int low = 0;
        int high = returnRouteList.length - 1;

        while (low < forwardRouteList.length && high >= 0) {
            int forwardRoute = forwardRouteList[low][0];
            int returnRoute = returnRouteList[high][0];
            int forwardFuel = forwardRouteList[low][1];
            int returnFuel = returnRouteList[high][1];

            if (forwardFuel + returnFuel > maxTravelDist) { //skip processing pair with higher than maxTravelDist
                high--;
            } else { // process pairs which less or equal total distance to maxTravelDist
                if (forwardFuel + returnFuel == maxFuel) { // pair total distance same as previous pair
                    result.add(new ArrayList<>(Arrays.asList(forwardRoute, returnRoute)));
                } else if (forwardFuel + returnFuel > maxFuel) {// pair total distance greater than previous pair
                    maxFuel = forwardFuel + returnFuel; // update maxFuel with current pair total distance
                    result.clear(); //remove old pairs from result
                    result.add(new ArrayList<>(Arrays.asList(forwardRoute, returnRoute)));
                }
                low++;
            }
        }
        return result;
    }
}
