package fr.ing.interview.kata.consumer.impl.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSource")
    private DataSource dataSource;

    protected DataSource getDataSource() {
        return dataSource;
    }
}
