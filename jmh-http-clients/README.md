# jmh-http-clients

JMH Java Http Clients (CommonsHttpClient, Jcabi, Jersey, OkHttp, Unirest) application for exchanging public APIs (POLONIEX, KRAKEN, BITFINEX)

# Steps to run benchmarks

`mvn clean install`

`java -jar target/benchmarks.jar`

# Environment

    OS: Mac OS X
    JVM: Oracle Corporation 1.8.0_102
    CPU: 2.8 GHz Intel Core i5
    Cores: 4
    RAM: 8 GB 1600 MHz DDR3
# POLONIEX
### POLONIEX public APIs

|                Benchmark                           | Mode | Count |  Time   |   | Fault  | Units |
|----------------------------------------------------|------|-------|---------|---|--------|-------|
| c.j.b.poloniex.PoloniexBenchmark.commonHttpClient  | avgt |    30 |   3.075 | ± |  0.225 | us/op |
| c.j.b.poloniex.PoloniexBenchmark.jcabi             | avgt |    30 |   3.043 | ± |  0.242 | us/op |
| c.j.b.poloniex.PoloniexBenchmark.jersey            | avgt |    30 |   2.903 | ± |  0.198 | us/op |
| c.j.b.poloniex.PoloniexBenchmark.okHttp            | avgt |    30 |   2.171 | ± |  0.194 | us/op |
| c.j.b.poloniex.PoloniexBenchmark.unirest           | avgt |    30 |   2.198 | ± |  0.179 | us/op |
| c.j.b.poloniex.PoloniexBenchmark.unirestParams     | avgt |    30 |   2.021 | ± |  0.180 | us/op |

### POLONIEX summary

# BITFINEX
### BITFINEX public APIs

|                Benchmark                           | Mode | Count |  Time   |   | Fault  | Units |
|----------------------------------------------------|------|-------|---------|---|--------|-------|
| c.j.b.bitfinex.BitfinexBenchmark.commonHttpClient  | avgt |    30 |   0.960 | ± |  0.379 | us/op |
| c.j.b.bitfinex.BitfinexBenchmark.jcabi             | avgt |    30 |   1.382 | ± |  1.034 | us/op |
| c.j.b.bitfinex.BitfinexBenchmark.jersey            | avgt |    30 |   1.014 | ± |  0.206 | us/op |
| c.j.b.bitfinex.BitfinexBenchmark.okHttp            | avgt |    30 |   0.834 | ± |  0.351 | us/op |
| c.j.b.bitfinex.BitfinexBenchmark.unirest           | avgt |    30 |   0.875 | ± |  0.527 | us/op |
| c.j.b.bitfinex.BitfinexBenchmark.unirestParams     | avgt |    30 |   0.729 | ± |  0.232 | us/op |

### BITFINEX summary

# KRAKEN
### KRAKEN public APIs

|                Benchmark                       | Mode | Count |  Time   |   | Fault  | Units |
|------------------------------------------------|------|-------|---------|---|--------|-------|
| c.j.b.kraken.KrakenBenchmark.commonHttpClient  | avgt |    30 |   2.514 | ± |  0.535 | us/op |
| c.j.b.kraken.KrakenBenchmark.jcabi             | avgt |    30 |   2.848 | ± |  0.758 | us/op |
| c.j.b.kraken.KrakenBenchmark.jersey            | avgt |    30 |   2.413 | ± |  0.548 | us/op |
| c.j.b.kraken.KrakenBenchmark.okHttp            | avgt |    30 |   1.557 | ± |  0.417 | us/op |
| c.j.b.kraken.KrakenBenchmark.unirest           | avgt |    30 |   1.518 | ± |  0.568 | us/op |
| c.j.b.kraken.KrakenBenchmark.unirestParams     | avgt |    30 |   1.159 | ± |  0.604 | us/op |

### KRAKEN summary