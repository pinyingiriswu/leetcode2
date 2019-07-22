public class d28_399_evaluate_division {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<>();
        HashMap<String, ArrayList<Double>> valuePairs = new HashMap<>();
        // build graph
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!pairs.containsKey(equation.get(0))) {
                pairs.put(equation.get(0), new ArrayList<String>());
                valuePairs.put(equation.get(0), new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation.get(1))) {
                pairs.put(equation.get(1), new ArrayList<String>());
                valuePairs.put(equation.get(1), new ArrayList<Double>());
            }
            pairs.get(equation.get(0)).add(equation.get(1));
            pairs.get(equation.get(1)).add(equation.get(0));
            valuePairs.get(equation.get(0)).add(values[i]);
            valuePairs.get(equation.get(1)).add(1/values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1), pairs, valuePairs, new HashSet<String>(), 1.0);
            if (res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }

    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);

        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valList = values.get(start);
        double temp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            temp = dfs(strList.get(i), end, pairs, values, set, value * valList.get(i));
            if (temp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return temp;
    }
}
