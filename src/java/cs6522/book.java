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



public class book {

	private String[] columns = { "ISBN", "title", "author", "publisher",
			"publish_year"};
	private String table = "book";

	public book() {

	}

	public void new_book(String[] values, Statement stmt) throws Exception {

		util inst = new util();
		inst.new_table_row(values, table, columns, stmt);
		

	}

	public void delete_book(String ISBN, Statement stmt) throws Exception {

		String query;

		query = "delete from book where book.ISBN=";
		query += "'" + ISBN + "';";
		System.out.println(query);

		try {
			stmt.execute(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}

	}

	public void update_book(String key, String value, String[] columns,
			String[] values, Statement stmt) throws Exception {

		util inst = new util();
		inst.update_table(key, value, columns, values, table, stmt);
	}

	public ResultSet show_book(String[] column_filter, String[] column_filter_values,
			Statement stmt) throws Exception {

		util inst = new util();
		return inst.show_table(column_filter, column_filter_values, table, stmt);

	}


	public int count_book(Statement stmt) throws Exception {

		util inst = new util();
		int count = inst.count_table(table, stmt);
		return count;
	}

}

