
var arr : String

var stack : [Character] = []
var check : Bool = true

while true {
    arr = readLine()!
    check = true
    stack.removeAll()
    if arr == "."{
        break
    }
    
    for j in arr{
        if j == "(" || j == "["{
            stack.append(j)
        } else if j == ")" {
            if stack.isEmpty || stack.last != "("  {
                check = false
                break
            }
            stack.popLast()
        } else if j == "]"{
            if stack.isEmpty || stack.last != "[" {
                check = false
                break
            }
            stack.popLast()
        }
        
    }
    
    if stack.isEmpty && check {
        print("yes")
    }else {
        print("no")
    }
    
}
