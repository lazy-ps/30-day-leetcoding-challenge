/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    const result = [];
    let element = intervals[0];
    for (let i = 1; i < intervals.length; i++) {
        const interval = intervals[i];
        element = element || interval;
        if (element[1] >= interval[0]) {
            element[1] = element[1] < interval[1] ? interval[1] : element[1];
        } else {
            result.push(element);
            element = interval;
        }
    }
    result.push(element);
    return result;
};
