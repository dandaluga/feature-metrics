package com.daluga.feature.metrics.controller;

import com.daluga.feature.metrics.domain.FeatureMetric;
import com.daluga.feature.metrics.service.FeatureMetricsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FeatureMetricsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureMetricsController.class);

    private final FeatureMetricsService featureMetricsService;
    private final CounterService counterService;

    public FeatureMetricsController(FeatureMetricsService featureMetricsService, CounterService counterService) {
        this.featureMetricsService = featureMetricsService;
        this.counterService = counterService;
    }

    @RequestMapping(value = "/feature-metric", method = RequestMethod.POST)
    public FeatureMetric create(@RequestBody @Valid final FeatureMetric featureMetric) {

        LOGGER.debug("Received request to create a feature: " + featureMetric.toString());

        return featureMetricsService.save(featureMetric);
    }

    @RequestMapping(value = "/feature-metric/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE, MediaType.APPLICATION_XML_VALUE})
    public FeatureMetric findById(@PathVariable("id") long id) {

        LOGGER.debug("Received request to find a metric by id: " + id);

        counterService.increment(this.getClass().getName() + ".findById()");

        return featureMetricsService.findOne(id);
    }
}
