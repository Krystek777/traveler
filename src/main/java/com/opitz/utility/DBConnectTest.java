package com.opitz.utility;

import static org.junit.Assert.*;

public class DBConnectTest {

    @org.junit.Test
    public void getData() {

        DBConnect connect = new DBConnect();
        connect.getData();
    }
}