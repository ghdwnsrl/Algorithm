var input = Int(readLine()!)!

var set = Set<Int>()

var a = readLine()!.split(separator: " ").map { set.insert(Int($0)!) }

set.sorted().map{ print($0, terminator: " ")}