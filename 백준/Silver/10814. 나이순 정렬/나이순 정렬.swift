import Foundation

struct User {
    var name : String
    var age : Int
    var order : Int
}

var input = Int(readLine()!)!
var userArr : [User] = []

for i in 0..<input{
    let userInput = readLine()!.split(separator: " ").map{ String($0)}
    let user = User(name: userInput[1], age: Int(userInput[0])!, order: i)
    userArr.append(user)
}

userArr.sort(by: {
    $0.age == $1.age ? $0.order<$1.order : $0.age < $1.age
})

for i in userArr {
    print("\(i.age) \(i.name)")
}
