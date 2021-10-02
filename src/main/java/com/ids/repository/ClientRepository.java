package com.ids.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ids.entity.Client;

@Repository
public class ClientRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void save(Client c) {
		String sql = "insert into client(id, nom, ice, email) values (:id, :nom, :ice, :email)";
		Map<String, Object> params = new HashMap<>();
		params.put("id", c.getId());
		params.put("nom", c.getNom());
		params.put("ice", c.getIce());
		params.put("email", c.getEmail());
		namedParameterJdbcTemplate.update(sql, params);
	}

	public void update(Client c) {
		String sql = "update client set nom = :nom, ice = :ice, email = :email where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource("id", c.getId())
				.addValue("nom", c.getNom())
				.addValue("ice", c.getIce())
				.addValue("email", c.getEmail())
			;
		namedParameterJdbcTemplate.update(sql, params);
	}
	
	static Client rowMapper(ResultSet rs, int num) {
		try {
			return Client.builder().id(rs.getString("id"))
					.nom(rs.getString("nom"))
					.ice(rs.getString("ice"))
					.email(rs.getString("email"))
					.build();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Client> findAll() {
		return namedParameterJdbcTemplate.query(
				"select * from client", ClientRepository::rowMapper);
	}
	
	public Optional<Client> findById(String id) {
		String sql = "select * from client where id = :id";
		try {
			Client client = namedParameterJdbcTemplate.queryForObject(sql, 
					new MapSqlParameterSource("id", id), 
					ClientRepository::rowMapper
			);
			return Optional.ofNullable(client);
		} catch (IncorrectResultSizeDataAccessException e) {
			return Optional.empty();
		}
	}

	public Optional<String> findNameById(String id) {
		String sql = "select nom from client where id = :id";
		try {
			String client = namedParameterJdbcTemplate.queryForObject(sql, 
					new MapSqlParameterSource("id", id), String.class);
			return Optional.ofNullable(client);
		} catch (IncorrectResultSizeDataAccessException e) {
			return Optional.empty();
		}
	}
}
