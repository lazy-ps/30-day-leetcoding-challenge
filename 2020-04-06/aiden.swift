class Solution {
    func groupAnagrams(_ strs: [String]) -> [[String]] {
        return strs.reduce(into: [String:[String]]()) { (map, current) in
            let key = String(current.sorted())
            if map.keys.firstIndex(of: key) == nil {
                map[key] = []
            }
            map[key]?.append(current)
        }.values.compactMap{ $0 }
    }
}