let input = Int(readLine()!)!

var arr : [Int] = []

for _ in 0 ..< input {
    let input = Int(readLine()!)!
    
    if (input != 0) {
        arr.append(input)
    }else {
        arr.popLast()
    }
    
}

var sum : Int = 0

arr.forEach { sum = sum + $0 }

print(sum)
