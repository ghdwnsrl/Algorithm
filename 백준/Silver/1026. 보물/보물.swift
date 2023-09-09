let input = Int(readLine()!)!
var arr = [Int]()

var a = readLine()!.split(separator: " ").map { Int(String($0))! }
var b = readLine()!.split(separator: " ").map { Int(String($0))! }

var result = 0

for _ in 0 ..< input {
    result += a.max()! * b.min()!
    a.remove(at: a.firstIndex(of: a.max()!)!)
    b.remove(at: b.firstIndex(of: b.min()!)!)
}

print(result)
