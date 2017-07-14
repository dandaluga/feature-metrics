package com.daluga.feature.metrics.repository;

import com.daluga.feature.metrics.domain.FeatureMetric;
import com.daluga.feature.metrics.exception.FeatureMetricRuntimeException;
import com.daluga.feature.metrics.repository.rowmapper.FeatureMetricRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class FeatureMetricRespository {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureMetricRespository.class);

    private static final String SQL_SELECT = "select id, username, business_system_id, feature_name, dealer_number from feature_metrics";
    private static final String SQL_INSERT = "insert into feature_metrics (username, business_system_id, feature_name, dealer_number) values (:username, :businessSystemId, :featureName, :dealerNumber)";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public FeatureMetricRespository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public FeatureMetric save(FeatureMetric featureMetric) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        SqlParameterSource parameters = new BeanPropertySqlParameterSource(featureMetric);

        int rowsInserted = jdbcTemplate.update(SQL_INSERT, parameters, keyHolder);

        if (rowsInserted != 1) {
            throw new FeatureMetricRuntimeException("Failure inserting row into database. Expected 1 row to be inserted but instead inserted [" + rowsInserted + "] rows. The data received was:  " + featureMetric.toString());
        }

        LOGGER.debug("Generated Key = " + keyHolder.getKeys().get("id"));

        return FeatureMetricRowMapper.getFeatureMetric(keyHolder);
    }

    public FeatureMetric findOne(long id) {
        String sql = SQL_SELECT + " where id = :id";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);

        return jdbcTemplate.queryForObject(sql, parameters, new FeatureMetricRowMapper());
    }
}
