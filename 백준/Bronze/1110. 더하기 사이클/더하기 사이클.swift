var answer = 0

var input = Int(readLine()!)!

if input < 10 {
    input *= 10
}

var tens = input / 10
var unit = input % 10
var newValue = -1
while(newValue != input) {
    answer += 1
    newValue = (unit * 10) + (tens + unit) % 10
    
    tens = newValue / 10
    unit = newValue % 10
}
print(answer)