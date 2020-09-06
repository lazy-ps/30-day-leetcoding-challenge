class Solution {
    public String largestTimeFromDigits(int[] arr) {

        int answer = -1;

        for(int i = 0; i < 10000; i++) {
            List<Integer> randomDigits = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(randomDigits);

            int[] digits = randomDigits.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            if(isInvalid(digits)) {
                continue;
            }

            int v = (digits[0] * 10 + digits[1]) * 60 + (digits[2] * 10 + digits[3]);
            answer = Math.max(answer, v);
        }

        if(answer < 0) {
            return "";
        }
        return String.format("%02d:%02d", answer / 60, answer % 60);
    }

    boolean isInvalid(int... digits) {
        int h = digits[0] * 10 + digits[1];
        int m = digits[2] * 10 + digits[3];
        if(h < 0 || h >= 24) return true;
        if(m < 0 || m >= 60) return true;
        return false;
    }
}

