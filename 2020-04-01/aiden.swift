class Solution {
    func singleNumber(_ nums: [Int]) -> Int {
        return nums.reduce(into: [Int:Int]()) { (map, value) in
            if let count = map[value] {
                map[value] = count + 1
            } else {
                map[value] = 1
            }
        }.filter{ $1 == 1 }.keys.first!
    }
}
