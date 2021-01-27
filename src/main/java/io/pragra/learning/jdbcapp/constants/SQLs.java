package io.pragra.learning.jdbcapp.constants;

public class SQLs {
    public static final String USER_SQL ="CREATE TABLE USER (\n" +
            "  USER_ID INT,\n" +
            "  USER_NAME CHAR(20),\n" +
            "  CREATE_DATE DATE,\n" +
            "  USER_PASS CHAR(30)\n" +
            ")";
}
