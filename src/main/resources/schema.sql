DROP TABLE IF EXISTS feature_metrics;

CREATE TABLE feature_metrics (
  id                    SERIAL,
  username              VARCHAR(40),
  business_system_id    INT,
  feature_name          VARCHAR(40),
  dealer_number         VARCHAR(40),
  PRIMARY KEY(id)
);