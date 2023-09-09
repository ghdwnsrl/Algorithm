var arr: Array<Int> = []

for _ in 0 ..< 9  {
    let input = Int(readLine()!)!
    arr.append(input)
}

let max = arr.max()!
let maxIndex = arr.firstIndex(of: max)!

print(max)
print(maxIndex + 1)