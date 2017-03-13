package net.lnk.spring.boot.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.lnk.spring.boot.jdbc.dao.CardBinDao;
import net.lnk.spring.boot.jdbc.model.CardBinEntity;

/**
 * @author Ben
 * @memo 2017年2月21日
 */
@Repository
public class CardBinDaoImpl implements CardBinDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	public void save(final CardBinEntity cardBin) {

		final String sql = "INSERT INTO t_card_bin (issuer_name, issuer_code, for_atm, for_pos, card_length, primary_length, primary_no, card_type, create_time)"
				+ " VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, cardBin.getIssuerName());
				ps.setString(2, cardBin.getIssuerCode());
				ps.setInt(3, cardBin.getForATM());
				ps.setInt(4, cardBin.getForPOS());
				ps.setInt(5, cardBin.getCardLength());
				ps.setInt(6, cardBin.getPrimaryLength());
				ps.setString(7, cardBin.getPrimaryNo());
				ps.setInt(8, cardBin.getCardType());
				// 只有年月日
				// ps.setDate(9, new Date(new java.util.Date().getTime()));
				// 只有时分秒
				// ps.setTime(9, new Time(new java.util.Date().getTime()));
				// 包含年月日时分秒
				ps.setTimestamp(9, new Timestamp(new java.util.Date().getTime()));

				return ps;
			}
		}, keyHolder);

		long id = keyHolder.getKey().longValue();
		cardBin.setId(id);
	}

	public void update(CardBinEntity cardBin, Long id) {
		List<Object> params = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();

		if (cardBin.getCardName() == null) {
			sb.append("card_name = ?,");
			params.add(cardBin.getCardName());
		}
		if (cardBin.getIssuerName() == null) {
			sb.append("issuer_name = ?,");
			params.add(cardBin.getIssuerName());
		}

		if (sb.toString().length() == 0) {
			return;
		}

		String setSql = sb.substring(0, sb.length() - 1).toString();

		String sql = "update t_card_bin set " + setSql + " where id = ?";

		Object[] values = new Object[params.size() + 1];
		for (int i = 0; i < params.size(); i++) {
			values[i] = params.get(i);
		}
		values[params.size()] = id;

		jdbcTemplate.update(sql, values);
	}

	public CardBinEntity findById(Long id) {
		String sql = "select * from t_card_bin where id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new CardBinRowMapper());
	}

	public List<CardBinEntity> findByIssuerCode(String issuerCode) {
		String sql = "select * from t_card_bin where issuer_code = ?";

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { issuerCode });

		List<CardBinEntity> cardBins = new ArrayList<CardBinEntity>();

		Iterator<Map<String, Object>> it = rows.iterator();
		while (it.hasNext()) {
			cardBins.add(mapToEntity(it.next()));
		}

		return cardBins;
	}

	private CardBinEntity mapToEntity(Map<String, Object> map) {
		CardBinEntity cardBin = new CardBinEntity();
		cardBin.setId((Long) map.get("id"));
		cardBin.setIssuerName((String) map.get("issuer_name"));
		cardBin.setIssuerCode((String) map.get("issuer_code"));
		cardBin.setCardName((String) map.get("card_name"));
		cardBin.setForATM((Integer) map.get("for_atm"));
		cardBin.setForPOS((Integer) map.get("for_pos"));
		cardBin.setCardLength((Integer) map.get("card_length"));
		cardBin.setPrimaryLength((Integer) map.get("primary_length"));
		cardBin.setPrimaryNo((String) map.get("primary_no"));
		cardBin.setCardType((Integer) map.get("card_type"));
		cardBin.setCreateTime((Date) map.get("create_time"));
		return cardBin;
	}

	private class CardBinRowMapper implements RowMapper<CardBinEntity> {

		public CardBinEntity mapRow(ResultSet resultset, int i) throws SQLException {
			CardBinEntity cardBin = new CardBinEntity();
			cardBin.setIssuerName(resultset.getString("issuer_name"));
			cardBin.setIssuerCode(resultset.getString("issuer_code"));
			cardBin.setCardName(resultset.getString("card_name"));
			cardBin.setForATM(resultset.getInt("for_atm"));
			cardBin.setForPOS(resultset.getInt("for_pos"));
			cardBin.setCardLength(resultset.getInt("card_length"));
			cardBin.setPrimaryLength(resultset.getInt("primary_length"));
			cardBin.setPrimaryNo(resultset.getString("primary_no"));
			cardBin.setCardType(resultset.getInt("card_type"));
			cardBin.setCreateTime(resultset.getTimestamp("create_time"));

			return cardBin;
		}
	}

}
