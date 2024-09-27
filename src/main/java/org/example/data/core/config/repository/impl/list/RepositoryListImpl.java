package org.example.data.core.config.repository.impl.list;
import java.util.ArrayList;
import java.util.List;

import org.example.data.core.config.repository.Repository;
public class RepositoryListImpl <T> implements Repository<T> {
    protected List<T> items = new ArrayList<>();

    @Override
    public void insert(T object) {
        // return items.add(object);
    }

    @Override
    public boolean update(T object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<T> selectAll() {
        return items;
    }

    @Override
    public T selectById(int id) {
        return null;
    }

    @Override
    public int count() {
        return items.size();
    }

    @Override
    public int insert(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }
}