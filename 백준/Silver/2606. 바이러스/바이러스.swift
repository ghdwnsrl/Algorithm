var count = Int(readLine()!)!
var num = Int(readLine()!)!

/* Create Graph */
var graph : [Int:[Int]] = [:]
for i in 1...count {
    graph.updateValue([], forKey: i)
}

for _ in 0..<num {
    var rep = readLine()!.split(separator: " ").map{ Int($0)! }
    
    graph[rep[0]]?.append(rep[1])
    graph[rep[1]]?.append(rep[0])
}

func DFS(_ graph : [Int:[Int]], _ start : Int) {
    var visitedNode : [Int] = []
    var needVisitNode : [Int] = [start]
    
    while !needVisitNode.isEmpty {
        let node = needVisitNode.removeLast()
        
        if visitedNode.contains(node) { continue }
        
        visitedNode.append(node)
        
        needVisitNode += graph[node] ?? []
        
    }
    
    print(visitedNode.count - 1 )
}

DFS(graph, 1)
