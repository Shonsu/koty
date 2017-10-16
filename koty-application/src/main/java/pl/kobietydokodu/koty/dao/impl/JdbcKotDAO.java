package pl.kobietydokodu.koty.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import pl.kobietydokodu.koty.dao.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;

public class JdbcKotDAO implements KotDAO {

	Connection conn = null;
	
	@Resource(name="dataSource")
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void dodajKota(Kot kot) {
		String sql = "INSERT INTO koty_table " +
				"(imie, opiekun, dataUrodzenia, waga) VALUES (?, ?, ?, ?)";

		conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, kot.getCustId());
			ps.setString(1, kot.getImie());
			ps.setString(2, kot.getImieOpiekuna());
			ps.setDate(3, java.sql.Date.valueOf(kot.getDataUrodzenia().toString()));
			ps.setFloat(4, kot.getWaga());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public List<Kot> getKoty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kot getKotById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
