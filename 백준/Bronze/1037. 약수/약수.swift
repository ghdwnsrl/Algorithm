var answer = 0

var first = Int(readLine()!)!
var second = readLine()!.split(separator: " ").map{ Int($0)! }

print(second.max()! * second.min()! )