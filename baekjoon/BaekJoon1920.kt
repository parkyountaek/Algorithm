package baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun BaekJoon1920(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N: Int = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    val A = IntArray(N)
    for (i in 0 until N) {
        A[i] = st.nextToken().toInt()
    }
    A.sort()

    val M:Int = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    val sb = StringBuilder()
    for (i in 0 until M) {
        val target = st.nextToken().toInt()
        sb.append(if (A.binarySearch(target) >= 0) 1 else 0).append('\n')
    }
    print(sb)
}

fun main(args: Array<String>) {
    BaekJoon1920(args)
}
