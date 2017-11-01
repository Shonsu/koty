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

import pl.kobietydokodu.koty.dao.CatService;
import pl.kobietydokodu.koty.domain.Cat;

public class JdbcKotDAO implements CatService {

	Connection conn = null;
	List<Cat> koty;
	Cat kot;

	@Resource(name = "dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void add(Cat kot) {
		String sql = "INSERT INTO koty_table " + "(imie, opiekun, dataUrodzenia, waga) VALUES (?, ?, ?, ?)";

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
		String sql = "SELECT * FROM koty_table";

		conn = null;
		koty = new ArrayList<Cat>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kot = new Cat();
				kot.setName(rs.getString("imie"));
				kot.setOwner(rs.getString("opiekun"));
				kot.setBirthDate(rs.getDate("dataUrodzenia"));
				kot.setWeight(rs.getFloat("waga"));
				koty.add(kot);
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
	public Cat findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Long idKot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long idKot) {
		// TODO Auto-generated method stub
		
	}

}
