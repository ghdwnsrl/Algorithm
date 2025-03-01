function solution(my_string) {
    return my_string.split(" ")
        .filter(c => c !== '')
        .sort((c1, c2) => c1 - c2);
}