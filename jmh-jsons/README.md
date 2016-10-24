# jmh-jsons

JMH Java JSONs (Jackson, Gson, Genson, FlexJson) application for different complexity JSONs structure

# Steps to run benchmarks

    mvn clean install
    java -jar target/benchmarks.jar

# Environment

    OS: Mac OS X
    JVM: Oracle Corporation 1.8.0_51
    CPU: 2.8 GHz Intel Core i5
    Cores: 4
    RAM: 8 GB 1600 MHz DDR3

# JSON entity generator

    http://www.json-generator.com/

# Youngling ~ 5KB file
### Youngling JSON template
    [
      '{{repeat(25)}}',
      {
        '@class': 'youngling',
        id: '{{index()}}',
        active: '{{bool()}}',
        age: '{{integer(5, 15)}}',
        name: '{{firstName()}} {{surname()}}',
        gender: '{{gender()}}',
        email: '{{email()}}',
        phone: '+3 {{phone()}}'
      }
    ]

### Youngling conver to JSON

|                Benchmark                 | Mode | Count |  Time   |   | Fault  | Units |
|------------------------------------------|------|-------|---------|---|--------|-------|
| c.j.b.youngling.ToJsonYoungling.jackson  | avgt |    10 |   9.797 | ± |  0.513 | us/op |
| c.j.b.youngling.ToJsonYoungling.genson   | avgt |    10 |  28.293 | ± |  6.742 | us/op |
| c.j.b.youngling.ToJsonYoungling.gson     | avgt |    10 |  40.975 | ± | 14.614 | us/op |
| c.j.b.youngling.ToJsonYoungling.flexjson | avgt |    10 | 101.924 | ± | 32.639 | us/op |

<p align="center">
	<img src="https://github.com/JediVision/jmh-jsons/blob/master/img/ToJsonYoungling.jpg?raw=true" alt=""/>
</p>

### Youngling convert from JSON

|                 Benchmark                  | Mode | Count |  Time   |   | Fault  | Units |
|--------------------------------------------|------|-------|---------|---|--------|-------|
| c.j.b.youngling.FromJsonYoungling.jackson  | avgt |    10 |  25.385 | ± |  4.623 | us/op |
| c.j.b.youngling.FromJsonYoungling.genson   | avgt |    10 |  35.142 | ± |  5.678 | us/op |
| c.j.b.youngling.FromJsonYoungling.gson     | avgt |    10 |  39.117 | ± |  4.973 | us/op |
| c.j.b.youngling.FromJsonYoungling.flexjson | avgt |    10 | 157.928 | ± | 96.220 | us/op |

<p align="center">
	<img src="https://github.com/JediVision/jmh-jsons/blob/master/img/FromJsonYoungling.jpg?raw=true" alt=""/>
</p>

### Youngling summary

    1) Jackson is implementation is efficient for simple JSON structure
    2) Gson and Genson implementations shows average results
    3) FlexJson is very slow

# Padawan ~ 500KB file
### Padawan JSON template

    [
      '{{repeat(500)}}',
      {
        '@class': 'com.jedivision.entity.Padawan',
        id: '{{index()}}',
        balance: '{{floating(1000, 4000, 2, "$0,0.00")}}',
        age: '{{integer(15, 30)}}',
        sword: '{{random("blue", "brown", "green")}}',
        name: '{{firstName()}} {{surname()}}',
        gender: '{{gender()}}',
        company: '{{company().toUpperCase()}}',
        email: '{{email()}}',
        phone: '+3 {{phone()}}',
        latitude: '{{floating(-90.000001, 90)}}',
        longitude: '{{floating(-180.000001, 180)}}',
        tasks: [
          '{{repeat(5, 10)}}',
          {
            id: '{{index()}}',
            description: '{{lorem(5, "words")}}'
          }
        ]
      }
    ]

### Padawan conver to JSON

|              Benchmark               | Mode | Count |   Time   |   |  Fault   | Units |
|--------------------------------------|------|-------|----------|---|----------|-------|
| c.j.b.padawan.ToJsonPadawan.jackson  | avgt |    10 | 2438.013 | ± | 1995.022 | us/op |
| c.j.b.padawan.ToJsonPadawan.flexjson | avgt |    10 | 3093.851 | ± | 1556.707 | us/op |
| c.j.b.padawan.ToJsonPadawan.genson   | avgt |    10 | 3952.121 | ± | 1391.293 | us/op |
| c.j.b.padawan.ToJsonPadawan.gson     | avgt |    10 | 4905.696 | ± | 1521.152 | us/op |

<p align="center">
	<img src="https://github.com/JediVision/jmh-jsons/blob/master/img/ToJsonPadawan.jpg?raw=true" alt=""/>
</p>

### Padawan convert from JSON

|               Benchmark                | Mode | Count |   Time    |   |  Fault   | Units |
|----------------------------------------|------|-------|-----------|---|----------|-------|
| c.j.b.padawan.FromJsonPadawan.jackson  | avgt |    10 |  2710.593 | ± |  349.352 | us/op |
| c.j.b.padawan.FromJsonPadawan.gson     | avgt |    10 |  3468.672 | ± |  594.031 | us/op |
| c.j.b.padawan.FromJsonPadawan.genson   | avgt |    10 |  3938.604 | ± | 2380.436 | us/op |
| c.j.b.padawan.FromJsonPadawan.flexjson | avgt |    10 | 14682.631 | ± | 4348.925 | us/op |

<p align="center">
	<img src="https://github.com/JediVision/jmh-jsons/blob/master/img/FromJsonPadawan.jpg?raw=true" alt=""/>
</p>

### Padawan summary

    1) Serialization shows average results for any implementations
    3) FlexJson is very slow for deserialization

# Master ~ 12MB file
### Master JSON template

    [
      '{{repeat(50)}}',
      {
        '@class': 'com.jedivision.entity.Master',
        id: '{{index()}}',
        balance: '{{floating(1000, 4000, 2, "$0,0.00")}}',
        age: '{{integer(20, 40)}}',
        sword: '{{random("blue", "brown", "green")}}',
        name: '{{firstName()}} {{surname()}}',
        gender: '{{gender()}}',
        company: '{{company().toUpperCase()}}',
        email: '{{email()}}',
        phone: '+3 {{phone()}}',
        address: '{{integer(100, 999)}} {{street()}}, {{city()}}, {{state()}}, {{integer(100, 10000)}}',
        about: '{{lorem(1, "paragraphs")}}',
        started: '{{date(new Date(2014, 0, 1), new Date(), "YYYY-MM-ddThh:mm:ss Z")}}',
        latitude: '{{floating(-90.000001, 90)}}',
        longitude: '{{floating(-180.000001, 180)}}',
        tasks: [
          '{{repeat(100, 200)}}',
          {
            id: '{{index()}}',
            description: '{{lorem(5, "words")}}'
          }
        ],
        forces: [
          '{{repeat(25, 100)}}',
          {
            id: '{{index()}}',
            title: '{{lorem(10, "words")}}',
            started: '{{date(new Date(2014, 0, 1), new Date(), "YYYY-MM-ddThh:mm:ss Z")}}',
            areas: [
              '{{repeat(10, 20)}}',
              '{{lorem(1, "words")}}'
            ],
            description: '{{lorem(10, "paragraphs")}}'
          }
        ]
      }
    ]

### Master convert to JSON

|             Benchmark              | Mode | Count |   Time    |   |   Fault   | Units |
|------------------------------------|------|-------|-----------|---|-----------|-------|
| c.j.b.master.ToJsonMaster.flexjson | avgt |    10 |  3463.825 | ± |  1562.101 | us/op |
| c.j.b.master.ToJsonMaster.jackson  | avgt |    10 | 43477.606 | ± | 19773.094 | us/op |
| c.j.b.master.ToJsonMaster.genson   | avgt |    10 | 45047.772 | ± |  7893.488 | us/op |
| c.j.b.master.ToJsonMaster.gson     | avgt |    10 | 51570.067 | ± |  7290.569 | us/op |

<p align="center">
	<img src="https://github.com/JediVision/jmh-jsons/blob/master/img/ToJsonMaster.jpg?raw=true" alt=""/>
</p>

### Master convert from JSON

|              Benchmark               | Mode | Count |    Time    |   |   Fault   | Units |
|--------------------------------------|------|-------|------------|---|-----------|-------|
| c.j.b.master.FromJsonMaster.genson   | avgt |    10 |  33405.919 | ± |  4688.963 | us/op |
| c.j.b.master.FromJsonMaster.jackson  | avgt |    10 |  60806.959 | ± | 28496.939 | us/op |
| c.j.b.master.FromJsonMaster.gson     | avgt |    10 |  82843.482 | ± |  7153.586 | us/op |
| c.j.b.master.FromJsonMaster.flexjson | avgt |    10 | 187056.779 | ± | 59337.826 | us/op |

<p align="center">
	<img src="https://github.com/JediVision/jmh-jsons/blob/master/img/FromJsonMaster.jpg?raw=true" alt=""/>
</p>

### Master summary

    1) FlexJson implementation shows unexpectedly efficient result for serialization
    2) Genson implementation shows effiecient in deserialization complex JSON
    3) FlexJson implementation shows unexpectedly unefficient result for deserilization

# Summary

    1) Jackson implementation shows efficient result for any JSON complexity
    2) Gson and Genson implementations show average similar results
    3) FlexJson implementation shows unexpectedly unefficient result for deserilization for complex JSON
