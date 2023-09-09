var N = readLine()!.split(separator: "-").map{ String($0) }
var first = N[0].split(separator: "+").map{ Int($0)! }
var answer = 0
var minusValue = 0

for i in first {
    answer += i
}

for i in 1..<N.count {
    let minus = N[i].split(separator: "+").map{ Int($0)! }
    
    for j in minus { minusValue += j }
    
}

print(answer - minusValue)