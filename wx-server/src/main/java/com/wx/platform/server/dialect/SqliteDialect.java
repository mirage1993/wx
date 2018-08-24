package com.wx.platform.server.dialect;

import org.hibernate.dialect.SQLiteDialect;

public class SqliteDialect extends SQLiteDialect {

    public String getAddColumnString() {
        return"add column";
    }

}
