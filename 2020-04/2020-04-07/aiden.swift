class Solution {
    func countElements(_ arr: [Int]) -> Int {
        var counting = [Int](repeating: 0, count: 1001)
        
        arr.forEach { counting[$0] += 1 }
        var result = 0
        for i in 0..<1000 {
            if counting[i+1] > 0 {
                result += counting[i]
            }
        }
        
        return result
    }
}