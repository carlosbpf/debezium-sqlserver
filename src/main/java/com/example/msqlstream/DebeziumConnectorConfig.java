package com.example.msqlstream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class DebeziumConnectorConfig {
    /**
     * Database details.
     */
    @Value("${sqlserver.datasource.host}")
    private String customerDbHost;

    @Value("${sqlserver.datasource.database}")
    private String customerDbName;

    @Value("${sqlserver.datasource.port}")
    private String customerDbPort;

    @Value("${sqlserver.datasource.username}")
    private String customerDbUsername;

    @Value("${sqlserver.datasource.password}")
    private String customerDbPassword;

    /**
     * Customer Database Connector Configuration
     */
    @Bean
    public io.debezium.config.Configuration customerConnector() throws IOException {

        return io.debezium.config.Configuration.create()
                .with("name", "customer-mysql-connector")
                .with("connector.class", "io.debezium.connector.sqlserver.SqlServerConnector")
                //.with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                //.with("offset.storage.file.filename", offsetStorageTempFile.getAbsolutePath())
                .with("offset.flush.interval.ms", "60000")
                .with("database.query.timeout.ms", "60000")
                .with("snapshot.lock.timeout.ms", "10000")
                .with("database.hostname", customerDbHost)
                .with("database.port", customerDbPort)
                .with("database.user", customerDbUsername)
                .with("database.password", customerDbPassword)
                .with("database.names", customerDbName)
                .with("topic.prefix", "bd")
                .with("database.include.list", customerDbName)
                .with("include.schema.changes", "false")
                .build();
    }
}
