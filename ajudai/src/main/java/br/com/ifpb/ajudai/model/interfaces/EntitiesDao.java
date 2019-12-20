package br.com.ifpb.ajudai.model.interfaces;

import java.sql.SQLException;

public interface EntitiesDao {
    boolean addEntities(Object object) throws SQLException, ClassNotFoundException;

    boolean removeEntities(Object object) throws SQLException, ClassNotFoundException;

    boolean updateEntities(Object object) throws SQLException, ClassNotFoundException;

    Object searchEntities(String id) throws SQLException, ClassNotFoundException;
}
