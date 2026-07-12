public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {

        List<List<Pair>> result = new ArrayList<>();

        int n = pairs.size();

        for (int i = 0; i < n; i++) {

            Pair current = pairs.get(i);
            int j = i - 1;

            // Stable insertion sort
            while (j >= 0 && pairs.get(j).key > current.key) {
                pairs.set(j + 1, pairs.get(j));
                j--;
            }

            pairs.set(j + 1, current);

            // Save current state
            result.add(new ArrayList<>(pairs));
        }

        return result;
    }
}