/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs6522;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author imalik
 */
public class users {
    public users () {
        
    }

	private String[] columns = { "cid", "login_name", "password", "full_name", "phone" };
        private String column_names = " (cid, login_name, password, full_name, phone) values (" ;
	private String table = "users";

	public Boolean user_exist(String column, Statement stmt)
			throws Exception {

		String query;
		query = "select count(*) as c from users where users.login_name='"
				+ column + "';";
		ResultSet results;
		try {
			results = stmt.executeQuery(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}

		if (results.next()) {
			if (results.getInt("c") == 0) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public void new_user(String[] values, Statement stmt)
			throws Exception {

		int cid = this.count_users(stmt) + 1;
		String[] newrow = new String[] { String.valueOf(cid), "'"+values[0]+"'",
				"'"+values[1]+"'", "'"+values[2]+"'", "'"+values[3]+"'"};

		util inst = new util();
		inst.new_table_row(newrow, table, columns, stmt);

	}

	public boolean login_user(String login_name, String password,
			Statement stmt) throws Exception {

		ResultSet results;
		String[] columns = { "login_name" };
		String[] values = { "'"+login_name+"'" };
		results = this.show_user(columns, values, stmt);
		
		if (results.next()) {
			if (password.equals(results.getString("password")))
				return true;
			else
				return false;
		}
		return false;
	}
	public int get_cid(String user, Statement stmt) throws Exception {
		
		String query;
		
		query = "select cid from users where login_name=" + user + ";";
		System.out.println(query);
		ResultSet results;
		try {
			results = stmt.executeQuery(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}
		
		int cid = -1;
		if (results.next()) {
			cid = results.getInt("cid"); 
		}
		return cid;
	}
	public void delete_user(String cid, Statement stmt) throws Exception {

		String query;

		query = "delete from users where users.cid=";
		query += cid + ";";
		System.out.println(query);

		try {
			stmt.execute(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}

	}

	public void update_user(String cid, String[] columns, String[] values,
			Statement stmt) throws Exception {

		util inst = new util();
		inst.update_table("cid", cid, columns, values, table, stmt);
	}

	public ResultSet show_user(String[] column_filter, String[] column_values,
			Statement stmt) throws Exception {

		util inst = new util();
		return inst.show_table(column_filter, column_values, table, stmt);

	}

	public int count_users (Statement stmt) throws Exception {

		util inst = new util();
		return inst.count_table(table, stmt);
	}
}
