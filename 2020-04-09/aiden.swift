class Solution {
    func backspaceCompare(_ S: String, _ T: String) -> Bool {
        // swift의 경우 함수의 인자는 immutable이기 때문에 원천적으로 inplace는 불가능하다
        var S = S
        var T = T
        
        var sWriteIndex = 0
        for sReadIndex in 0..<S.count {
            let currentChar = S[S.index(S.startIndex, offsetBy: sReadIndex)]
            
            if currentChar == "#" {
                sWriteIndex -= 1
                if sWriteIndex < 0 {
                    sWriteIndex = 0
                }
            } else {
                let index = S.index(S.startIndex, offsetBy: sWriteIndex)
                S.replaceSubrange( index...index, with: [currentChar])
                sWriteIndex += 1
            }
        }
        
        var tWriteIndex = 0
        for tReadIndex in 0..<T.count {
            let currentChar = T[T.index(T.startIndex, offsetBy: tReadIndex)]
            
            if currentChar == "#" {
                tWriteIndex -= 1
                if tWriteIndex < 0 {
                    tWriteIndex = 0
                }
            } else {
                let index = T.index(T.startIndex, offsetBy: tWriteIndex)
                T.replaceSubrange( index...index, with: [currentChar])
                tWriteIndex += 1
            }
        }
        
        print(S.prefix(sWriteIndex), T.prefix(tWriteIndex))
        
        return S.prefix(sWriteIndex) == T.prefix(tWriteIndex)
    }
}