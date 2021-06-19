import java.io.OutputStream
import java.io.IOException
import java.io.InputStream
import java.io.PrintWriter
import java.util.HashMap
import java.io.InputStreamReader
import java.util.ArrayList
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
        val solver = MaximumTopologicalSort()
        solver.solve(1, `in`, out)
        out.close()
    }

    internal class MaximumTopologicalSort {
        var MOD = 1e9.toLong() + 7
        var TMP: Long = 1000000
        var edges: Array<List<Integer>>? = null
        var dp: Map<Long, Long>? = null
        var numdp: Map<Long, Integer>? = null
        var cdp: Map<Long, Long>? = null
        var F: LongArray? = null
        var bq: LongArray? = null
        var com: Com? = null
        var n: Int = 0
        var first: Node? = null
        var second: Node? = null
        var size: IntArray? = null
        var weight: IntArray? = null

        fun solve(testNumber: Int, `in`: FastReader, out: PrintWriter) {
            val t = `in`.nextInt()
            cdp = HashMap()
            com = Com(MOD)
            F = LongArray(500002)
            bq = LongArray(500002)
            F[0] = 1
            F[1] = 1
            bq[1] = -1
            bq[0] = bq[1]
            for (i in 2 until F!!.size) {
                F[i] = F!![i - 1] * i % MOD
                bq[i] = -1
            }
            for (i in 0 until t) {
                solve(`in`, out)
            }
        }

        private fun solve(`in`: FastReader, out: PrintWriter) {
            n = `in`.nextInt()
            val k = `in`.nextInt()
            edges = arrayOfNulls<ArrayList>(n + 1)
            dp = HashMap(n)
            numdp = HashMap(n)
            //cdp = new HashMap<>();
            //com = new Com(MOD);
            for (i in 1 until n) {
                val u = `in`.nextInt()
                val v = `in`.nextInt()
                buildEd(u, v)
                buildEd(v, u)
            }

            if (n == 1) {
                out.println("1 1")
                return
            }

            size = IntArray(n + 1)
            weight = IntArray(n + 1)
            first = Node(0, (n + 2).toLong())
            second = Node(0, (n + 2).toLong())
            GetCentroid(1, 0)


            val ans = if (k == 1) first else second
            out.println(ans.i.toString() + " " + cal(ans.i, 0))

        }

        fun GetCentroid(cur: Int, fa: Int) {  // cur 表示当前节点 (current)
            size[cur] = 1
            weight[cur] = 0
            val list = edges!![cur]
            for (x in list) {
                if (x == fa) continue
                GetCentroid(x.toInt(), cur)
                size[cur] += size!![x]
                weight[cur] = Math.max(weight!![cur], size!![x])
            }
            numdp!!.put(cur * TMP + fa, size!![cur])

            weight[cur] = Math.max(weight!![cur], n - size!![cur])
            if (weight!![cur] < first!!.`val` || weight!![cur].toLong() == first!!.`val` && cur > first!!.i) {
                second = first
                first = Node(cur, weight!![cur].toLong())
            } else {
                if (weight!![cur] < second!!.`val` || weight!![cur].toLong() == second!!.`val` && cur > second!!.i) {
                    second = Node(cur, weight!![cur].toLong())
                }
            }

        }

        private fun cal(root: Int, fa: Int): Long {
            val key = root * TMP + fa
            val ans = dp!![key]
            if (ans != null) {
                return ans.toLong()
            }
            val list = edges!![root]
            var sum: Long = 1
            val nums = ArrayList()
            var numSum: Long = 0
            for (x in list) {
                if (x == fa) continue
                sum = sum * cal(x.toInt(), root) % MOD
                val k = calNum(x.toInt(), root)
                nums.add(k)
                numSum += k
            }
            sum = sum * F!![numSum.toInt()] % MOD
            for (num in nums) {
                sum = sum * calBq(num.toInt()) % MOD
            }
            //        for (Long num : nums) {
            //            sum = (sum*calC(numSum,num))%MOD;
            //            numSum-=num;
            //        }
            dp!!.put(key, sum)
            return sum

        }

        private fun calBq(num: Int): Long {
            return if (bq!![num] != -1) bq!![num] else bq[num] = CommonUtils.binpow(F!![num], MOD - 2, MOD)

        }

        private fun calNum(root: Int, fa: Int): Long {
            var key = root * TMP + fa
            val ans = numdp!![key]
            if (ans != null) {
                return ans!!.toLong()
            }
            key = fa * TMP + root
            return n - numdp!![key]

        }

        private fun buildEd(u: Int, v: Int) {
            if (edges!![u] == null) {
                edges[u] = ArrayList()
            }
            edges!![u].add(v)
        }

        internal inner class Node(var i: Int, var `val`: Long)

    }

    internal object CommonUtils {
        fun binpow(a: Long, b: Long, m: Long): Long {
            var a = a
            var b = b
            a %= m
            var res: Long = 1
            while (b > 0) {
                if (b and 1 > 0) res = res * a % m
                a = a * a % m
                b = b shr 1
            }
            return res
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

    internal class Com(var p: Long)
}

