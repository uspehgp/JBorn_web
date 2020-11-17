package com.uspehgp.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<DOMAIN, ID> {
    DOMAIN findById(ID id) throws SQLException;
    List<DOMAIN> findByAll();
    DOMAIN insert(DOMAIN domain);
    DOMAIN update(DOMAIN domain);
    boolean delete(ID id);

}
