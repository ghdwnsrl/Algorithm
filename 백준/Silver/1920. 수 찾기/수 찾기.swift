import Foundation

let N = Int(readLine()!)!
var aN : [Int] = readLine()!.split(separator: " ").map{ Int($0)! }

aN = aN.sorted(by: <)

let M = Int(readLine()!)!
let aM : [Int] = readLine()!.split(separator: " ").map{ Int($0)! }

func binarySearch<T: Comparable> (array : [T], searchItem : T ) -> Bool {
    
    var low = 0
    var high = array.count - 1
    
    while low <= high {
        let mid = ( low + high) / 2
        if searchItem == array[mid] {
            return true
        } else if searchItem < array[mid]{
            high = mid - 1
        }else {
            low = mid + 1
        }
    }
    return false
    
}

for (_,k) in aM.enumerated() {
    if binarySearch(array: aN, searchItem: k) {
        print(1)
    }else {
        print(0)
    }
}