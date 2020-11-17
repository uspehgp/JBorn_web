package com.uspehgp.dao;

import com.uspehgp.dao.domain.Contact;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.uspehgp.dao.DaoFactory.getConnection;
import static com.uspehgp.dao.DaoFactory.getDataSource;

public class ContactDao implements Dao<Contact, Integer> {
    private static ContactDao contactDao;
    public static ContactDao getContactDao() {
        if (contactDao==null){
            contactDao=new ContactDao();
        }
        return contactDao;
    }
    @Override
    public Contact findById(Integer id) throws SQLException{
        Contact contact =null;
        try (Connection connection = getConnection()){
            PreparedStatement ps = connection.prepareStatement("select * from contact where id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setFirst_name(rs.getString("first_name"));
                contact.setLast_name(rs.getString("last_name"));
            }
        }
        return contact;
    }

    @Override
    public List<Contact> findByAll() {
        return null;
    }

    @Override
    public Contact insert(Contact contact) {
        return null;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }
}
