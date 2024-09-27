package org.example.data.core.config.repository.impl.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.data.core.config.database.impl.DataSourceImpl;
import org.example.data.core.config.repository.Repository;

public abstract class RepositoryDbImpl<T> extends DataSourceImpl implements Repository<T>{

    protected String tableName;

    public abstract T convertToObject(ResultSet rs) throws SQLException;
    
}
