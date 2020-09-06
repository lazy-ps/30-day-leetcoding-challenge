class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ranges = new TreeSet<>();
        Map<Long, Integer> counts = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(i - k - 1 >= 0)  {
                long v = nums[i - k - 1];
                int count = counts.get(v) - 1;
                counts.put(v, count);
                if (count == 0) {
                    ranges.remove(v);
                }
            }

            long v = nums[i];
            counts.put(v, counts.getOrDefault(v, 0) + 1);
            ranges.add(v);

            if(counts.get(v) >= 2) {
                return true;
            }

            Long higher = ranges.higher(v);
            Long lower = ranges.lower(v);

            if(higher != null && higher - v <= t) {
                return true;
            }
            if(lower != null && v - lower <= t) {
                return true;
            }
        }
        return false;
    }
}

