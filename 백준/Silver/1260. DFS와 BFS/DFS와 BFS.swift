
func DFS(graph :[Int:[Int]], start : Int ) -> [Int] {
    var visitedQueue : [Int] = []
    var needVisitedStack :[Int] = [start]
    
    while !needVisitedStack.isEmpty {
        let node = needVisitedStack.removeLast()
        
        if visitedQueue.contains(node) { continue }
        
        visitedQueue.append(node)
        
        needVisitedStack += graph[node] ?? []
    }
    
    return visitedQueue
}

func BFS(graph :[Int:[Int]], start : Int ) -> [Int] {
    var visitedQueue : [Int] = []
    var needVisitedStack :[Int] = [start]
    
    while !needVisitedStack.isEmpty {
        let node = needVisitedStack.removeFirst()
        
        if visitedQueue.contains(node) { continue }
        
        visitedQueue.append(node)
        
        needVisitedStack += graph[node] ?? []
    }
    
    return visitedQueue
}

var input = readLine()!.split(separator: " ").map{ Int($0)! }
var graph : [Int:[Int]] = [:]

for i in 1...input[0] {
    graph.updateValue([], forKey: i)
}

for _ in 0..<input[1] {
    let read = readLine()!.split(separator: " ").map{ Int($0)! }
    graph[read[0]]?.append(read[1])
    graph[read[1]]?.append(read[0])
}

for i in  1...input[1] {
    graph[i]?.sort(by: >)
}

print(DFS(graph: graph, start: input[2]).map{ String($0) }.joined(separator: " "))

for i in  1...input[1] {
    graph[i]?.sort(by: <)
}
print(BFS(graph: graph, start: input[2]).map{ String($0) }.joined(separator: " "))
