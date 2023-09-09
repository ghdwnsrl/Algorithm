var N = Int(readLine()!)!

var arr = Array<String>()

for _ in 0 ..< N {
    let value = readLine()!
    arr.append(value)
}

arr = Array(Set(arr))
arr = arr.sorted(by: { $0.count == $1.count ? $0 < $1 : $0.count < $1.count })

for i in 0 ..< arr.count {
    print(arr[i])
}
