package mol;

import DButils.ConnectionUtil;

import java.sql.Connection;

public class Test {
    public static void main(String[] args) {
        Connection conn = ConnectionUtil.getConnect();
        System.out.println(conn);
        ConnectionUtil.close(conn);
    }
}
