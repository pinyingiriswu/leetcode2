public class d31_134_gas_station {
    /** Time: O(n)
     * Space: O(1) */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Say starting from station i and reaching station j.
        //Add up gas in tank in every station i. If tank is less than 0 at station j, it cannot reach station j.
        //If cannot reach station j, that means stations between i~j cannot reach station j. Thus, starting from j+1 for circuit start point.
        //total for total amount of gas has to be bigger than cost to complete a circuit.
        //If total is less than 0, that means not enough gas for completing circuit. Thus, return index -1.
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }

        if (total < 0) return -1;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
