import java.io.OutputStream
import java.io.IOException
import java.io.InputStream
import java.io.PrintWriter
import java.util.StringTokenizer
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
object Main {
    fun main(args: Array<String>) {
        val inputStream = System.`in`
        val outputStream = System.out
        val `in` = FastReader(inputStream)
        val out = PrintWriter(outputStream)
        val solver = CTwoPolicemen()
        solver.solve(1, `in`, out)
        out.close()
    }

    internal class CTwoPolicemen {
        fun solve(testNumber: Int, `in`: FastReader, out: PrintWriter) {
            var t = `in`.nextInt()
            while (t-- > 0) {
                val n = `in`.nextInt()
                var x = `in`.nextInt()
                var y = `in`.nextInt()

                if (x > y) {
                    val tmp = x
                    x = y
                    y = tmp
                }

                var ans = Math.max(n - x, y - 1)

                for (i in x until y) {
                    val tx = Math.min((i - x) * 2 + x - 1, (x - 1) * 2 + (i - x))
                    val ty = Math.min((n - y) * 2 + y - i - 1, (y - i - 1) * 2 + (n - y))
                    ans = Math.min(ans, Math.max(tx, ty))
                }
                out.println(ans)

            }
        }

    }

    internal class FastReader {
        var br: BufferedReader? = null
        var st = StringTokenizer("")

        constructor() {
            br = BufferedReader(InputStreamReader(System.`in`))
        }

        constructor(`in`: InputStream) {
            br = BufferedReader(InputStreamReader(`in`))
        }

        operator fun next(): String {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = StringTokenizer(br!!.readLine())
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
            return st.nextToken()
        }

        fun nextInt(): Int {
            return Integer.parseInt(next())
        }

    }
}

