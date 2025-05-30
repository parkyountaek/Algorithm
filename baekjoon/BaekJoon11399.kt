package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun BaekJoon11399(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val P = IntArray(N)
    val st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        P[i] = st.nextToken().toInt()
    }
    P.sort()

    var sum = 0
    for (idx in 0 until P.size) {
        sum += P[idx] * (N - idx)
    }
    print(sum)
}

fun main(args: Array<String>) {
    BaekJoon11399(args)
}
