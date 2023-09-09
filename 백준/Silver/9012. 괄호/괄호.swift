let input = Int(readLine()!)!

var arr : String

var stack : [Character] = []
var check : Bool = true

for _ in 0 ..< input {
    arr = readLine()!
    check = true
    stack.removeAll()
    
    for j in arr{
        if j == "(" {
            stack.append(j)
        } else if j == ")"{
            if stack.isEmpty {
                check = false
                break
            }
            stack.popLast()
        }
        
    }
    
    if stack.isEmpty && check {
        print("YES")
    }else {
        print("NO")
    }
    
}