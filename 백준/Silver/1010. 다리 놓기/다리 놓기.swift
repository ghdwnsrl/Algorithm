var input = Int(readLine()!)!
var N, M : Int
var dp = Array(repeating: Array(repeating: 0, count: 30), count: 30)

for n in 1..<30 {
    for m in 1..<30 {
        if n == 1 {
            dp[n][m] = m
        }else {
            if n == m {
                dp[n][m] = 1
            } else if n <= m {
                dp[n][m] = dp[n][m-1] + dp[n - 1][m - 1]
            }
        }
    }
}

for _ in 0..<input {
    let value = readLine()!.split(separator: " ").map{ Int($0)! }
    N = value.first!
    M = value.last!
    print(dp[N][M])
}
