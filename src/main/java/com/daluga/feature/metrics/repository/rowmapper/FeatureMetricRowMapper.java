package com.daluga.feature.metrics.repository.rowmapper;

import com.daluga.feature.metrics.domain.FeatureMetric;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class FeatureMetricRowMapper implements RowMapper<FeatureMetric> {

    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String BUSINESS_SYSTEM_ID = "business_system_id";
    private static final String FEATURE_NAME = "feature_name";
    private static final String DEALER_NUMBER = "dealer_number";

    @Override
    public FeatureMetric mapRow(ResultSet rs, int i) throws SQLException {
        FeatureMetric featureMetric = new FeatureMetric();

        featureMetric.setId(rs.getLong(ID));
        featureMetric.setUsername(rs.getString(USERNAME));
        featureMetric.setBusinessSystemId(rs.getLong(BUSINESS_SYSTEM_ID));
        featureMetric.setFeatureName(rs.getString(FEATURE_NAME));
        featureMetric.setDealerNumber(rs.getString(DEALER_NUMBER));

        return featureMetric;
    }

    public static FeatureMetric getFeatureMetric(KeyHolder keyHolder) {
        Map<String, Object> returnedData = keyHolder.getKeys();

        FeatureMetric featureMetric = new FeatureMetric();
        featureMetric.setId(NumberUtils.toLong(String.valueOf(returnedData.get(ID))));
        featureMetric.setUsername(String.valueOf(returnedData.get(USERNAME)));
        featureMetric.setBusinessSystemId(NumberUtils.toLong(String.valueOf(returnedData.get(BUSINESS_SYSTEM_ID))));
        featureMetric.setFeatureName(String.valueOf(returnedData.get(FEATURE_NAME)));
        featureMetric.setDealerNumber(String.valueOf(returnedData.get(DEALER_NUMBER)));

        return featureMetric;
    }
}
