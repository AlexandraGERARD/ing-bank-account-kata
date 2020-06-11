package fr.ing.interview.kata.consumer.impl.dao;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

public abstract class AbstractDaoImpl {

    @Inject
    @Named("dataSource")
    private DataSource dataSource;

    //----------------- GETTERS/SETTERS -----------------//
    protected DataSource getDataSource() {
        return dataSource;
    }
}
