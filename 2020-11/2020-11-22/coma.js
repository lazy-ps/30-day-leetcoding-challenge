/**
 * @param {string[]} words
 * @return {number}
 */
var uniqueMorseRepresentations = function(words) {
    const morseCodes = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."];
    const morseMap = {};
    morseCodes.forEach((code, index) => morseMap[String.fromCharCode(97 + index)] = code);
    const ansSet = new Set();
    words.forEach(word => {
        let morse = '';
        [...word].forEach(w => morse += morseMap[w]);
        ansSet.add(morse);
    });
    return ansSet.size;
};
