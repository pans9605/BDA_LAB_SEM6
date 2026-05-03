adoop@bmscecse-HP-Pro-Tower-400-G9-PCI-Desktop-PC:~$ start-dfs.sh
hadoop@bmscecse-HP-Pro-Tower-400-G9-PCI-Desktop-PC:~$ start-yarn.sh
hadoop@bmscecse-HP-Pro-Tower-400-G9-PCI-Desktop-PC:~$ spark-shell
hadoop@bmscecse-HP-Pro-Tower-400-G9-PCI-Desktop-PC:~$ nano /home/$USER/wc.txt
hadoop@bmscecse-HP-Pro-Tower-400-G9-PCI-Desktop-PC:~$ spark-shell
scala> val textFile = sc.textFile("/home/hadoop/wc.txt")
scala> val counts = textFile.flatMap(line => line.split(" ")) .map(word => (word,1)) .reduceByKey(_ + _)
counts: org.apache.spark.rdd.RDD[(String, Int)] = ShuffledRDD[8] at reduceByKey at <console>:23

scala> import scala.collection.immutable.ListMap
import scala.collection.immutable.ListMap

scala> val sorted = ListMap(counts.collect.sortWith(_._2>_._2):_*)
sorted: scala.collection.immutable.ListMap[String,Int] = ListMap(test -> 6, hello -> 5, world -> 3)

scala> for((k,v) <- sorted){
     | if(v > 4) {
     | 
Display all 918 possibilities? (y or n)
     | 
     | println(k + "->" + v)
     | }
     | }
test->6
hello->5



