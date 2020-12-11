/**
 * @param {number[]} arr
 * @return {boolean}
 */
var validMountainArray = function(arr) {
    if (arr.length < 3) return false;
    let upHill = false, downHill = false;
    for (let i = 1; i < arr.length; i++) {
        if (arr[i-1] < arr[i]) {
            if (downHill) return false;
            if (upHill) continue;
            else upHill = true;
        } else if (arr[i-1] > arr[i]) {
            if (!upHill) return false;
            if (downHill) continue;
            else downHill = true;
        } else {
            return false;
        }
    }
    return upHill && downHill;
};
