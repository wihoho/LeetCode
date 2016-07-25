/**
 *
 * @author Gong Li <gong_l@worksap.co.jp> on 27/6/2016.
 */
public class GasStationTwo {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) return -1;
        if (gas.length != cost.length) return -1;

        int size = gas.length;
        int sum = 0;
        int total = 0;
        int startIndex = -1;

        if (size == 1) {
            if (gas[0] - cost[0] < 0) return -1;
            else return 0;
        }

        for (int i = 0; i < size; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (sum < 0) {
                startIndex = i + 1;
                sum = 0;
            }
        }

        if (total >= 0) {
            return startIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = new int[2];
        gas[0] = 2;
        gas[1] = 4;

        int[] cost = new int[2];
        cost[0] = 3;
        cost[1] = 4;

        GasStationTwo gasStationTwo = new GasStationTwo();
        System.out.println(gasStationTwo.canCompleteCircuit(gas, cost));
    }
}
