
To start:
```shell
docker-compose up 
```

Inicializa o db e habilita o CDC
```shell
cat script.sql | docker exec -i sql-cdc-kafka_sqlserver_1 bash -c '/opt/mssql-tools/bin/sqlcmd -U sa -P P@ssw0rd'
```
Run MysqlStreamApplication.java 
and run:
```shell
docker exec -it sql-cdc-kafka_sqlserver_1 bash -c '/opt/mssql-tools/bin/sqlcmd -U sa -P P@ssw0rd'
```
```mysql
insert into db.dbo.t1 values ('Test');
go
```
## Resources
- https://medium.com/bemobi-tech/construindo-ambiente-de-streaming-de-dados-com-sql-server-cdc-e-kafka-d363589da545
- https://www.baeldung.com/debezium-intro
- https://debezium.io/documentation/reference/stable/connectors/sqlserver.html#_enabling_cdc_on_the_sql_server_database