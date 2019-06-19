package com.developrswithpassion.cassandra.processor

import com.datastax.spark.connector._
import com.smartthings.cassandra.utils.Arguments
import org.apache.spark.{SparkConf, SparkContext}
import com.beust.jcommander.JCommander
import com.developrswithpassion.cassandra.utils.Arguments


object CassandraExporter {
  def main(args: Array[String]) {
    intialize(args)
    val conf = new SparkConf(true)
      .setAppName("cassandra_csv_export")
      .setMaster(Arguments.getMaster)
      .set("spark.cassandra.connection.host", Arguments.getUrl)

    val sc = new SparkContext(conf)

    val colvalue = sc.cassandraTable(Arguments.getKeyspace, Arguments.getTable).map(row => {
      row.columnValues
    })

    /* Spliting columns using Delimiter */
    val delimiterSeperatedRDD = colvalue.map(col => col.toSeq.mkString(Arguments.getDelimiter))

    delimiterSeperatedRDD.saveAsTextFile(Arguments.getOutpath)

    sc.stop()
  }

  /**
    * Intitalize and set variable using jcommander utiity
    *
    * @param args
    * @return
    */
  def intialize(args: Array[String]): Unit = {
    try {
      val jCommander = new JCommander(Arguments, args.toArray: _*)
      if (Arguments.getHelp) {
        jCommander.usage()
        System.exit(0)
      }
    }
    catch {
      case e: Exception => System.out.println(e.getMessage)
        System.exit(0)

    }
  }
}
