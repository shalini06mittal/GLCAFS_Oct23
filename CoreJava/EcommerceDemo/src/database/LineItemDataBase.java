package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.LineItem;
import model.Order;

public class LineItemDataBase {

	private static Connection conn =  DBConnection.getConnection();
	public List<LineItem> getAllItemsByOrderId(String orderid) throws SQLException
	{

		List<LineItem> lineItems = new ArrayList<LineItem>();
		String sql = "select l.item_id, l.qty, l.price "
				+ "from lineitem l "
				+ "where l.order_id = ?";
		System.out.println(sql);
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, orderid);
		ResultSet rs = statement.executeQuery();
		while(rs.next())
		{
			LineItem lineItem = new LineItem();
			Item item = new Item();
			item.setItemid(rs.getString(1));
			lineItem.setItem(item);
			lineItem.setQty(rs.getInt(2));
			lineItem.setPrice(rs.getDouble(3));
			
			lineItems.add(lineItem);

		}
		return lineItems;
	}
}
