/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs6522;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author imalik
 */
public class util {
    

	public void new_table_row(String row[], String table,
			String[] columns, Statement stmt) throws Exception {

		String query;
		int len = columns.length;

		query = "insert into " + table + " (";
		for (int i = 0; i < len - 1; i++)
			query += columns[i] + ",";
		query += columns[len - 1] + ") values (";
		len = row.length;
		for (int i = 0; i < len - 1; i++)
			query += row[i] + ",";
		query += row[len - 1];
		len = columns.length - row.length;
		for (int i = 0; i < len; i++)
			query += ",null";
		query += ");";

		System.out.println(query);

		try {
			stmt.execute(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}

	}

	public ResultSet show_table(String[] column_filter, String[] column_values,
			String table, Statement stmt) throws Exception {

		String query;
		int len = column_filter.length;
		query = "select * from " + table;
		if (len != 0) {
			query += " where ";
			for (int i = 0; i < len - 1; i++)

				query += column_filter[i] + "=" + column_values + " and ";
			query = query + column_filter[len - 1] + "=" + column_values[len - 1];
		}
		query += ";";
		System.out.println(query);

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

	public int count_table(String table, Statement stmt) throws Exception {

		String query;
		query = "select count(*) as cnt from " + table + ";";
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

	public void update_table(String key, String value, String[] columns,
			String[] values, String table, Statement stmt) throws Exception {

		String query;

		query = "update " + table + " set ";
		for (int i = 0; i < columns.length - 1; i++)
			if (values[i] != "null")
				query += columns[i] + "=" + values[i] + ",";
		if (values[columns.length - 1] != "null") {
			query += columns[columns.length - 1] + "=" + values[columns.length - 1] + " ";
		}
		query += "where " + key + "=" + value + ";";
		System.out.println(query);

		try {
			stmt.execute(query);
		} catch (Exception e) {
			System.err.println("Unable to execute query:" + query + "\n");
			System.err.println(e.getMessage());
			throw (e);
		}
	}

	public void showResultSet(ResultSet results) throws Exception {

		ResultSetMetaData m = null;
		m = results.getMetaData();
		int cols = m.getColumnCount();

		for (int i = 1; i <= cols; i++) {
			System.out.print(m.getColumnName(i));
			System.out.print("\t\t\t");
		}

		System.out.println();
		while (results.next()) {
			for (int i = 1; i <= cols; i++) {
				System.out.print(results.getString(i));
				System.out.print("\t\t\t");
			}
			System.out.println();
		}
	}






}
