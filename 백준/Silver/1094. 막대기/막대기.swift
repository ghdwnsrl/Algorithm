var X = Int(readLine()!)!

print(String(X, radix: 2).filter{ $0 == "1" }.count)