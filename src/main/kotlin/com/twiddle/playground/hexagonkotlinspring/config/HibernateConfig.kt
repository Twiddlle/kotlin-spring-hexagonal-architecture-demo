package com.twiddle.playground.hexagonkotlinspring.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import javax.sql.DataSource

@Configuration
@ConfigurationProperties(prefix = "spring.jpa.hibernate")
class HibernateConfig {

    @Autowired
    lateinit var envLoader: EnvLoader

    @Bean
    fun hibernateJpaVendorAdapter(): HibernateJpaVendorAdapter {
        val adapter = HibernateJpaVendorAdapter()
        adapter.setGenerateDdl(true)
        adapter.setShowSql(true)
        return adapter
    }

    @Bean
    fun entityManagerFactory(
        dataSource: DataSource,
        jpaVendorAdapter: JpaVendorAdapter,
    ): LocalContainerEntityManagerFactoryBean {
        val emf = LocalContainerEntityManagerFactoryBean()
        emf.dataSource = dataSource
        emf.jpaVendorAdapter = jpaVendorAdapter
        emf.setPackagesToScan("com.twiddle.playground.hexagonkotlinspring")
        emf.setJpaPropertyMap(additionalProperties())
        return emf
    }

    fun additionalProperties(): Map<String, String> {
        val properties = mutableMapOf<String, String>()
        properties["spring.jpa.generate-ddl"] = envLoader.envProps.getProperty("SPRING_JPA_HIBERNATE_DDL_AUTO") ?: "none"
        return properties
    }
}
