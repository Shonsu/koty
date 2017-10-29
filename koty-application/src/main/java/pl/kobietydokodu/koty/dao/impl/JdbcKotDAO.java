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

import pl.kobietydokodu.koty.dao.KotDAO;
import pl.kobietydokodu.koty.domain.Kot;

public class JdbcKotDAO implements KotDAO {

	Connection conn = null;
	List<Kot> koty;
	Kot kot;

	@Resource(name = "dataSource")
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void dodajKota(Kot kot) {
		String sql = "INSERT INTO koty_table " + "(imie, opiekun, dataUrodzenia, waga) VALUES (?, ?, ?, ?)";

		conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setInt(1, kot.getCustId());
			ps.setString(1, kot.getImie());
			ps.setString(2, kot.getImieOpiekuna());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			ps.setString(3, sdf.format(kot.getDataUrodzenia()));
			ps.setFloat(4, kot.getWaga());
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
	public List<Kot> getKoty() {
		String sql = "SELECT * FROM koty_table";

		conn = null;
		koty = new ArrayList<Kot>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				kot = new Kot();
				kot.setImie(rs.getString("imie"));
				kot.setImieOpiekuna(rs.getString("opiekun"));
				kot.setDataUrodzenia(rs.getDate("dataUrodzenia"));
				kot.setWaga(rs.getFloat("waga"));
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
	public Kot getKotById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edytujKota(Long idKot) {
		// TODO Auto-generated method stub
		
	}

}
