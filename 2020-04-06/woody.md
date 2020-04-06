# Problem

- [문제 링크](https://leetcode.com/problems/group-anagrams/)

<br>

`String[] strs` 값이 주어지면 **Anagrams** 을 이루는 단어들을 한 리스트로 묶어서 출력하는 문제입니다.

**Anagrams** 이란 문자의 순서를 바꾸어서 만들 수 있는 다른 문자를 말하며

간단히 생각하면 같은 숫자의 문자들로 이루어진 `String` 들을 하나로 묶으면 됩니다.

주어지는 값은 모두 소문자이며 출력 순서는 상관 없다는 조건이 있습니다.

<br><br>

# Solution 1 - Sort

첫번째 솔루션은 **_Sort_** 입니다.

알파벳의 숫자가 같으면 문자열을 정렬했을 때 항상 같은 문자열이 됩니다.

`<String, List<String>>` 을 `<key, value>` 로 하는 `HashMap` 을 선언한 뒤에 `List` 로 변환하여 리턴해주면 됩니다.

`strs` 의 배열 길이를 `N`, `str` 문자열의 길이를 `K` 라고 했을 때 시간복잡도는 `O(N * K log K)` 입니다.

<br><br>

# Java Code 1 - Sort

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // sort
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedStr = String.valueOf(ch);
            
            // map renewal
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new LinkedList<>());
            }
            map.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
```

<br><br><br>

# Solution 2 - Hash 1

두번째 솔루션은 **_Hash_** 입니다.

주어진 문자열이 소문자 알파벳만으로 이루어졌다는 사실을 통해서 해시를 구현할 수 있습니다.

정렬은 문자열을 정렬해서 비교했다면 `Hash` 는 배열 그 자체를 비교합니다.

길이 26 의 `int` 배열을 선언한 뒤에 알파벳 숫자만큼 카운팅 합니다.

예를 들어 `bacc` 라는 문자열을 받았을 때 이걸 `keyArray` 로 변환한다면

`[1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]`

이런 문자열이 됩니다.

`accb` 도 변환한다면 위와 같은 문자열이 됩니다.

`Arrays.toString(int[] arr)` 을 통해 배열을 통째로 `String` 으로 변환할 수 있습니다.

내부적으로 `for` 문과 `StringBuilder` 를 사용하기 때문에 시간복잡도는 `O(N * K)` 가 됩니다.

<br><br>

# Java Code 2 - Hash 1

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // hash 1
            int[] arr = new int[26];
            for (char c : str.toCharArray()) arr[c - 'a']++;
            String keyArray = Arrays.toString(arr);
            
            // map renewal
            if (!map.containsKey(keyArray)) {
                map.put(keyArray, new LinkedList<>());
            }
            map.get(keyArray).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
```

<br><br><br>

# Solution 3 - Hash 2

세번째 솔루션은 다른 사람들의 **Submission Code** 를 참고했습니다.

두번째 솔루션과 같은 해시지만 배열 `String` 을 그대로 키 값으로 사용했던 것과 달리 `Integer` 값을 사용합니다.

26 개의 소수값을 배열에 미리 넣어둔 뒤 알파벳의 갯수만큼 `hashKey` 값에 곱해줍니다.

이와 같은 풀이가 가능한 이유는 소수의 곱이라 다른 **Anagrams** 값과 중복될 일이 전혀 없기 때문입니다.

시간복잡도는 동일하게 `O(N * K)` 지만 `Array to String` 과정이 없기 때문에 세번째 솔루션이 미세하게 더 빠릅니다.

<br><br>

# Java Code 3 - Hash 2

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 
                        23, 29, 31, 37, 41, 43, 47, 53, 
                        59, 61, 67, 71, 73, 79, 83, 89, 
                        97, 101};
        
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // hash 2
            int hashKey = 1;
            for (char c : str.toCharArray()) {
                hashKey *= primes[c - 'a'];
            }
            
            // map renewal
            if (!map.containsKey(hashKey)) {
                map.put(hashKey, new LinkedList<>());
            }
            map.get(hashKey).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
```