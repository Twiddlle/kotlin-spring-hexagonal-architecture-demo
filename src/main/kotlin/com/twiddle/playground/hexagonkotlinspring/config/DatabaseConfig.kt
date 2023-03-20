package com.twiddle.playground.hexagonkotlinspring.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class DatabaseConfig {

    @Autowired
    lateinit var envLoader: EnvLoader

    @Bean
    fun dataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.postgresql.Driver")
        dataSource.setUrl(envLoader.envProps.getProperty("DB_URL"))
        dataSource.setUsername(envLoader.envProps.getProperty("DB_USERNAME"))
        dataSource.setPassword(envLoader.envProps.getProperty("DB_PASSWORD"))
        return dataSource
    }
}
