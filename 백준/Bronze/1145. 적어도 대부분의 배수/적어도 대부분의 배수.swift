var input = readLine()!.split(separator: " ").map{ Int($0)! }

var check = 0
var answer = 1

while check < 3 {
    check = 0
    for (_, n) in input.enumerated(){
        if (answer % n == 0 ){
            check += 1
        }
    }
    if check < 3 {
        answer += 1
    }
    
}

print(answer)