import Foundation
let input = Int(readLine()!)!

var stack : [Int] = []
var end = 1
var result : [String] = []

for _ in 1 ... input {
    
    let value = Int(readLine()!)!
    
    while end <= value{
        stack.append(end)
        result.append("+")
        end += 1
    }
    
    if stack.last == value {
        stack.popLast()
        result.append("-")
    } else {
        print("NO")
        exit(0)
    }
}

print(result.joined(separator: "\n"))


