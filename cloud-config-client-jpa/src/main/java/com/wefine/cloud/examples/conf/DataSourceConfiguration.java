package com.wefine.cloud.examples.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@RefreshScope
@Configuration
public class DataSourceConfiguration {

    @Value("${mysqldb.datasource.url}")
    private String url;
    @Value("${mysqldb.datasource.username}")
    private String username;
    @Value("${mysqldb.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();

        ds.setMaximumPoolSize(100);
        ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        ds.addDataSourceProperty("url", url);
        ds.addDataSourceProperty("user", username);
        ds.addDataSourceProperty("password", password);
        ds.addDataSourceProperty("cachePrepStmts", true);
        ds.addDataSourceProperty("prepStmtCacheSize", 250);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        ds.addDataSourceProperty("useServerPrepStmts", true);

        return ds;
    }
}
