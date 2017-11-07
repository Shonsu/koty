package pl.kobietydokodu.koty.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import pl.kobietydokodu.koty.dao.CatDAO;
import pl.kobietydokodu.koty.domain.Cat;

@Repository
@Qualifier("jdbcKotDAOBean")
public class JdbcCatDAO implements CatDAO {

	Connection conn = null;
	List<Cat> koty;
	Cat result;

	@Resource(name = "dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Cat kot) {
		String sql = "INSERT INTO koty.koty_table " + "(imie, opiekun, dataUrodzenia, waga) VALUES (?, ?, ?, ?)";

		conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setInt(1, kot.getCustId());
			ps.setString(1, kot.getName());
			ps.setString(2, kot.getOwner());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(3, sdf.format(kot.getBirthDate()));
			ps.setFloat(4, kot.getWeight());
			ps.executeUpdate();
			ps.close();

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

	@Override
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
				System.out.println(rs.getString("imie"));
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

	@Override
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

	@Override
	public void edit(Cat kot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long idKot) {
		// TODO Auto-generated method stub
		
	}

}
