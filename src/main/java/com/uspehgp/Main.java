package com.uspehgp;

import com.uspehgp.dao.ContactDao;
import com.uspehgp.dao.domain.Contact;

import java.sql.*;

import static com.uspehgp.dao.ContactDao.getContactDao;

public class Main {
    public static void main(String[] arg) throws SQLException {
        ContactDao contactDao = getContactDao();
        Contact contact = contactDao.findById(1);
        System.out.println(contact);
    }
}
