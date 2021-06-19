import java.io.OutputStream
import java.io.IOException
import java.io.InputStream
import java.io.PrintWriter
import java.io.InputStreamReader
import java.util.Stack
import java.util.Vector
import java.util.StringTokenizer
import java.io.BufferedReader

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
        val solver = BRBSDeletion()
        solver.solve(1, `in`, out)
        out.close()
    }

    internal class BRBSDeletion {
        fun solve(testNumber: Int, `in`: FastReader, out: PrintWriter) {
            var t = `in`.nextInt()
            while (t-- > 0) {
                val n = `in`.nextInt()
                val k = `in`.nextInt()
                val str = `in`.nextLine()
                val stack = Stack()
                var ans = 0
                var num = 0
                var pre = 0
                for (i in 0 until str.length()) {
                    val ch = str.charAt(i)
                    if (ch == '(') {
                        stack.add(ch)
                    } else {
                        if (!stack.isEmpty() && stack.peek() !== ch) {
                            stack.pop()
                        } else {
                            stack.add(ch)
                        }
                    }
                    if (stack.isEmpty()) {
                        ans++
                        num += i - pre + 1 - 2
                        pre = i + 1
                    }
                }
                ans += if (num >= k) k else num
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

        fun nextLine(): String {
            var str = ""

            try {
                str = br!!.readLine()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return str
        }

        fun nextInt(): Int {
            return Integer.parseInt(next())
        }

    }
}

