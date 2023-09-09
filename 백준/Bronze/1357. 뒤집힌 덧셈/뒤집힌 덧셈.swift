var answer = 0
var input = readLine()!.split(separator: " ").map { answer += Int(String($0.reversed()))!}

print(Int(String(String(answer).reversed()))!)
