package com.btb.index.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.btb.index.dao.ProductDao;
import com.btb.index.model.Product;
import com.btb.util.dao.BaseDao;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public List<Product> findList() {
		List<Product> list = new ArrayList<>();
        Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM product_information";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setProdoctName(resultSet.getString("product_name"));
				product.setProdoctPrice(resultSet.getDouble("product_price"));
				product.setProdoctUrl(resultSet.getString("product_url"));
				product.setProdoctPicture(resultSet.getString("product_picture"));
				list.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeAll(connection, statement, resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return list;
	}

	@Override
	public int save(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Product t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
