
package com.developrswithpassion.cassandra.utils

import com.beust.jcommander.Parameter
import java.util
import java.util.{ArrayList, List}

import Arguments.keyspace


object Arguments {
  @Parameter private var parameters = new util.ArrayList[String]
  @Parameter(names = Array("-keyspace"), description = "cassandra keyspace",  required = true) private var keyspace = ""
  @Parameter(names = Array("-table"), description = "table in keyspace",  required = true) private var table = ""
  @Parameter(names = Array("-delimiter"), description = "Delimiter for column seperator") private var delimiter = "|"
  @Parameter(names = Array("-url"), description = "url of cassandra") private var url = "localhost"
  @Parameter(names = Array("-master"), description = "spark master") private var master = "local"
  @Parameter(names = Array("-outpath"), description = "output path for data", required = true) private var outpath = ""
  @Parameter(names = Array("-help"), description = "Help") private var help = false

  def getParameters: util.List[String] = parameters

  def setParameters(parameters: util.ArrayList[String]): Unit = {
    this.parameters = parameters
  }

  def getKeyspace: String = keyspace

  def setKeyspace(keyspace: String): Unit = {
    this.keyspace = keyspace
  }

  def getTable: String = table

  def setTable(table: String): Unit = {
    this.table = table
  }

  def getDelimiter: String = delimiter

  def setDelimiter(delimiter: String): Unit = {
    this.delimiter = delimiter
  }

  def getUrl: String = url

  def setUrl(url: String): Unit = {
    this.url = url
  }

  def getMaster: String = master

  def setMaster(master: String): Unit = {
    this.master = master
  }

  def getOutpath: String = outpath

  def setOutpath(outpath: String): Unit = {
    this.outpath = outpath
  }


  def getHelp: Boolean = help

  def setHelp(help: Boolean): Unit = {
    this.help = help
  }
}
