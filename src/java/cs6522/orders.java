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




public class orders {

	private String[] columns = { "oid", "ISBN", "cid", "buy_date", "amount" };
	private String table = "orders";

	public orders() {
	}
	
	public void new_order(String[] values, Statement stmt)
			throws Exception {
		int oid = this.count_order(stmt);
		String[] temp = new String[] { String.valueOf(oid), values[0],
				values[1], values[2], values[3] };
		util utils = new util();
		utils.new_table_row(temp, table, columns, stmt);
	}
	
	public boolean new_orders(String[] attrValue, Statement stmt)
			throws Exception {

		book books = new book();
		String[] sigmaAttr = { "ISBN" };
		String[] sigmaValue = { attrValue[0] };
		ResultSet resultTable = books.show_book(sigmaAttr, sigmaValue, stmt);

		int copies = 0;

		copies = Integer.valueOf(attrValue[2]);
		if (copies < 0)
			return false;

		String[] tempAttr = { "copies" };
		String[] tempValue = { String.valueOf(copies) };

		String date = "'" + "2017" + "'";
		int oid = this.count_order(stmt) + 1;
		tempValue = new String[] { String.valueOf(oid), attrValue[0],
				attrValue[1], date, attrValue[2] };

		util inst = new util();
		inst.new_table_row(tempValue, table, columns, stmt);

		return true;

	}


	public ResultSet show_orders(int cid, Statement stmt) throws Exception {

		String query = "";

		query = "select * from orders where cid=" + String.valueOf(cid)
				+ " order by buy_date;";
		ResultSet results;

		try {
			results = stmt.executeQuery(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}
		return results;
	}

	public int count_order(Statement stmt) throws Exception {


		String query;
		query = "select max(oid) as cnt from " + table + ";";
		System.out.println(query);

		ResultSet results;
		try {
			results = stmt.executeQuery(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}

		int count = 0;
		if (results.next())
			count = results.getInt("cnt");
		System.out.println(count);

		return count+1;
	}

        
	public int count_user_order(int cid, Statement stmt) throws Exception {


		String query;
		query = "select sum(amount) as cnt from " + table + " where cid=" + String.valueOf(cid) + " ;";
		System.out.println(query);

		ResultSet results;
		try {
			results = stmt.executeQuery(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}

		int count = 0;
		if (results.next())
			count = results.getInt("cnt");
		System.out.println(count);

		return count;
	}
}

