import java.io.*
val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
fun pStar(i:Int,j:Int,n:Int){
    if(n == 1 ) bw.write("*")
    else if ((i / (n/3)) % 3 == 1 && (j / (n/3)) % 3 == 1){
        bw.write(" ")
    }
    else pStar(i,j,n/3)
} 
fun main(){
    var n = br.readLine().toInt()
     for (i in 0..n-1){
        for (j in 0..n-1) pStar(i, j, n);
        bw.write("\n")
    }
    bw.flush()
    bw.close()
}