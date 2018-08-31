package com.migraciones.sigesth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.migraciones.sigesth.dto.AdministradorDto;

@Repository
public class AdministradorDao extends JdbcDaoSupport implements IAdministradorDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initializa() {
		setDataSource(dataSource);
	}

	@Override
	public List<AdministradorDto> getAll() {
		String sql = "SELECT * FROM dgth.administradores ORDER BY admin_login ASC";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		List<AdministradorDto> result = new ArrayList<AdministradorDto>();
		for (Map<String, Object> row : rows) {
			AdministradorDto adm = new AdministradorDto();
			adm.setCedula((String) row.get("personal_cedula"));
			adm.setUsername((String) row.get("admin_login"));
			adm.setTipo((int) row.get("tipoadmin_id"));
			result.add(adm);
		}
		return result;
	}

	@Override
	public AdministradorDto getByLogin(String username, String password) {
		String sql = "SELECT * FROM dgth.administradores WHERE admin_login='" + username
				+ "' AND tipoadmin_id<>4 AND admin_estado<='A' AND admin_password=md5('" + password + "')";
		return (AdministradorDto) getJdbcTemplate().query(sql, new ResultSetExtractor<AdministradorDto>() {

			@Override
			public AdministradorDto extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					AdministradorDto adm = new AdministradorDto();
					adm.setCedula((String) rs.getString("personal_cedula"));
					adm.setUsername((String) rs.getString("admin_login"));
					adm.setPassword((String) rs.getString("admin_password"));
					adm.setTipo((int) rs.getInt("tipoadmin_id"));
					return adm;
				} else {
					return null;
				}
			}
		});
	}

}
