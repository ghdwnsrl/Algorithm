import Foundation

let input = Int(readLine()!)!
var dic : [String:Int] = [:]

for _ in (0 ..< input){
    let tmp = readLine()!
    if dic.keys.contains(tmp){
        dic[tmp] = dic[tmp]! + 1
    }else {
        dic[tmp] = 1
    }
}

var maxvalue = 0
var maxname = ""
for (key, value) in dic {
    
    if (value == maxvalue){
        let maxtmp = min(key, maxname)
        maxname = maxtmp
    }
    
    if (value > maxvalue){
        maxvalue = value
        maxname = key
    }
}

print(maxname)