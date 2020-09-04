### DP
dp(i) 정의: A<sub>i</sub>을 마지막으로 포함하는 부분 연속 배열의 합의 최대값</br>
dp(i) = max(0, dp(i-1)) + A<sub>i</sub>
</br></br>
모든 dp(i) 중 최대 값을 찾으면 그것이 연속 부분 수열 합의 최대값.</br>
i를 0부터 순회하면서 이전 dp(i-1)을 계속 갱신하면 한번만 순회하고, 메모리도 적게 든다. 

### WHY?
dp(i)의 정의에 현재 값(A<sub>i</sub>)을 포함하므로 이전 값들이 중요한데, </br>
만약 이전 값을 포함하는 최대값인 dp(i-1)이 0보다 크면, 이전 값들을 부분 배열에 포함하는 것이 더 큰 값이 될 것이고 </br>
0보다 작으면 부분 배열에서 사용하지 않고 현재 값만 사용해야한다. </br>
이게 `max(0, dp(i-1))`에 녹아져 있다.

### 복잡도
- 시간복잡도: O(N)
- 공간복잡도: O(1)

```cpp
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int ret = nums[0], pre_sum = 0;
        for(auto &v : nums) {
            if(pre_sum > 0)
                pre_sum += v;
            else
                pre_sum = v;
            
            ret = max(ret, pre_sum);
        }
        return ret;
    }
};
```
