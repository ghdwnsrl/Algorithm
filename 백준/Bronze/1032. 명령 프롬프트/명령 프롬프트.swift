var input = Int(readLine()!)!
var result  = Array(readLine()!)


for _ in 1..<input{
    let compare = Array(readLine()!)
    for (k,m) in compare.enumerated(){
        if result[k] != m {
            result[k] = "?"
        }
    }
}

print(result.map{String($0)}.joined() )