package pl.kobietydokodu.koty.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.domain.Cat;

@Repository
@Qualifier("jdbcKotDAOBean")
public class JdbcCatDAO {

	Connection conn = null;
	List<Cat> koty;
	Cat result;

	@Resource(name = "dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Cat add(Cat kot) {
		String sql = "INSERT INTO koty.koty_table " + "(imie, opiekun, dataUrodzenia, waga) VALUES (?, ?, ?, ?)";

		conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// ps.setInt(1, kot.getCustId());
			ps.setString(1, kot.getName());
			ps.setString(2, kot.getOwner());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(3, sdf.format(kot.getBirthDate()));
			ps.setFloat(4, kot.getWeight());
			int affectedRows = ps.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("Creating cat failed, no rows affected.");
			}

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					kot.setCustId(generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating cat failed, no ID obtained.");
				}
			}
			ps.close();
			return kot;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
				return null;
			}

		}

	}

	public List<Cat> findAll() {
		String sql = "SELECT * FROM koty.koty_table";

		conn = null;
		koty = new ArrayList<Cat>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = new Cat();
				result.setCustId(rs.getLong("CUST_ID"));
				result.setName(rs.getString("imie"));
				result.setOwner(rs.getString("opiekun"));
				result.setBirthDate(rs.getDate("dataUrodzenia"));
				result.setWeight(rs.getFloat("waga"));
				koty.add(result);
			}
			rs.close();
			ps.close();
			return koty;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public Cat findById(Long id) {
		String sql = "SELECT * FROM koty_table where CUST_ID = " + id;

		conn = null;
		result = new Cat();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result.setCustId(rs.getLong("CUST_ID"));
				result.setName(rs.getString("imie"));
				result.setOwner(rs.getString("opiekun"));
				result.setBirthDate(rs.getDate("dataUrodzenia"));
				result.setWeight(rs.getFloat("waga"));
			}
			rs.close();
			ps.close();
			return result;

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public Cat edit(Cat kot) {
		return null;
		// TODO Auto-generated method stub

	}

	public void delete(Cat kot) {
		// TODO Auto-generated method stub

	}

	public boolean existsById(Long id) {
		return true;
	}

}
