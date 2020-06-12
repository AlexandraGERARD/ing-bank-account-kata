package fr.ing.interview.kata.consumer.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Abstract class that provides the {@link DataSource}
 */
public abstract class AbstractDaoImpl {

    @Autowired
    @Resource
    private DataSource dataSource;

    //----------------- GETTERS/SETTERS -----------------//
    protected DataSource getDataSource() {
        return dataSource;
    }
}
