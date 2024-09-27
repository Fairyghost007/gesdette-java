package org.example.data.core.config.repository;

import java.util.List;
public interface Repository<T> {
       void insert(T objet);
       int insert (String sql);
       boolean update(T objet);
       boolean delete(int  id);
       List<T> selectAll();

       T selectById(int id);
      
       int count();
}
