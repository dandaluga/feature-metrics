#!/usr/bin/env bash
#curl http://localhost:8080/feature-metric/1 --header "Accept: text/xml"

#curl http://localhost:8080/feature-metric/1 --header "Accept: application/xml"

curl http://localhost:8080/feature-metric/1 --header "Accept: application/json"

#curl http://localhost:8080/feature-metric/ --data @feature.json --header "Content-Type: application/json;charset=UTF-8" --insecure --output feature.out --trace feature.trace --user dd00865
