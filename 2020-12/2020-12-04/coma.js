/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthFactor = function(n, k) {
    let cnt = 0;
    for (let i = 1; i <= n; i++) {
        if (n % i == 0) cnt++;
        if (cnt == k) return i;
    }
    return -1;
};
