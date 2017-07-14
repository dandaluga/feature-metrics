package com.daluga.feature.metrics.service;

import com.daluga.feature.metrics.domain.FeatureMetric;
import com.daluga.feature.metrics.repository.FeatureMetricRespository;
import org.springframework.stereotype.Service;

@Service
public class FeatureMetricsService {

    private final FeatureMetricRespository featureMetricRespository;

    public FeatureMetricsService(FeatureMetricRespository featureMetricRespository) {
        this.featureMetricRespository = featureMetricRespository;
    }

    public FeatureMetric findOne(long id) {
        return featureMetricRespository.findOne(id);
    }

    public FeatureMetric save(FeatureMetric featureMetric) {
        return featureMetricRespository.save(featureMetric);
    }
}
