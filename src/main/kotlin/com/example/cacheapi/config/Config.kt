package com.example.cacheapi.config

import com.example.cacheapi.repository.MobileEventRepository
import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy
import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy
import org.springframework.data.r2dbc.dialect.H2Dialect
import org.springframework.data.r2dbc.dialect.R2dbcDialect
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.data.r2dbc.repository.support.R2dbcRepositoryFactory

@Configuration
@EnableR2dbcRepositories
class Config : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory() = H2ConnectionFactory(
            H2ConnectionConfiguration
                    .builder()
                    .url("r2dbc:h2:mem:///test")
//                    .url("jdbc:h2:mem:h2database")
                    .username("sa")
                    .password("pass")
                    .build()
    )

    @Bean
    fun databaseClient(connectionFactory: H2ConnectionFactory): DatabaseClient =
            DatabaseClient.builder().connectionFactory(connectionFactory).build()

    @Bean
    fun dialect(): R2dbcDialect = H2Dialect()

    @Bean
    fun reactiveDataAccessStrategy(dialect: R2dbcDialect): ReactiveDataAccessStrategy = DefaultReactiveDataAccessStrategy(dialect)

    @Bean
    fun repositoryFactory(databaseClient: DatabaseClient, reactiveDataAccessStrategy: ReactiveDataAccessStrategy): R2dbcRepositoryFactory {
        return R2dbcRepositoryFactory(databaseClient, reactiveDataAccessStrategy)
    }

    @Bean
    fun mobileEvenRepository(repositoryFactory: R2dbcRepositoryFactory): MobileEventRepository =
            repositoryFactory.getRepository(MobileEventRepository::class.java)
}