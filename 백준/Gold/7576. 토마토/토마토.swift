func solution() {
    
    let input = readLine()!.split(separator: " ").map{ Int($0)! }
    let M = input[0]
    let N = input[1]
    var tomatoBox : [[Int]] = []
    var needVisit : [[Int]] = []
    let positionX = [0,0,1,-1]
    let positionY = [1,-1,0,0]
    var day = [0,0]
    var allRipe = true
    
    /* tomato 넣기 */
    for _ in 0..<N {
        let tmp : [Int] = readLine()!.split(separator: " ").map{ Int($0)!}
        tomatoBox.append(tmp)
    }
    
    for i in 0..<N {
        for j in 0..<M {
            if tomatoBox[i][j] == 1 {
                needVisit.append([i,j])
            }else if tomatoBox[i][j] == 0 {
                allRipe = false
            }
        }
    }
    var index = 0
    var checkDay = Array(repeating: Array(repeating: 0, count: 1001), count: 1001)
    /* 토마토 익히기 */
    while index < needVisit.count {
        
        let tomato = needVisit[index]
        index += 1
        
        for i in 0..<4{
            let row = tomato[0] + positionX[i]
            let col = tomato[1] + positionY[i]
            if row < 0 || row > N - 1 || col < 0 || col > M - 1 {
                continue
            }else {
                if tomatoBox[row][col] == 0 {
                    tomatoBox[row][col] = 1
                    checkDay[row][col] = checkDay[tomato[0]][tomato[1]] + 1
                    needVisit.append([row,col])
                    day = [row,col]
                }
            }
            
        }
    }
    
    if allRipe {
        print(0)
        return
    }else {
        for min in tomatoBox {
            if min.contains(0) {
                print(-1)
                return
            }
        
        }
        print(checkDay[day[0]][day[1]])
    }
    
}

solution()