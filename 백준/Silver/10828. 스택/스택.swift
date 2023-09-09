class Stack{
    
    var arr : [Int] = []

    func push(num : Int) {
        arr.append(num)
    }
    
    func size() -> Int {
        return Int(self.arr.count)
    }

    func empty() {
        self.arr.isEmpty ? print(1) : print(0)
    }

    func top() -> Int {
        if(arr.isEmpty){
            return -1
        }
        return self.arr.last!
    }

    func pop() -> Int {
        if let value = arr.popLast(){
            return value
        }
        return -1
    }
}

let stack : Stack = Stack()

let cnt = Int(readLine()!)!

for _ in 0 ..< cnt {
    
    let input = readLine()!.split(separator: " ").map{ String($0)}
    switch input[0] {
    case "push":
        stack.push(num: Int(input[1])!)
        break
    case "pop":
        print(stack.pop())
        break
    case "size":
        print(stack.size())
        break
    case "empty":
        stack.empty()
        break
    case "top":
        print(stack.top())
        break
    default:
        break
    }
}
