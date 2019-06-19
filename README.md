#DATA EXPORTER

The Data Exporter utility is responsible for exporting data from various sources to storage system . In the current
implementation there is support for exporting data from Cassandra Keyspace in CSV format to target storage system.


##How to run 

The argument can be passed using command line options as given below . By default cassandra url is set to localhost
spark master is set to local aand delimiter is set to "|"

-url cassandraurl -master sparkmaster -keyspace spark -table us_unemployment_stats -delimiter "," -outpath /home/exa00077/CassandraOutput