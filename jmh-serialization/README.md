# jmh-serialization

JMH Java Serialization (JDK, FastJson, Jackson, FST, Kryo, MessagePack) application for different complexity JSONs structure

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
        id: '{{index()}}',
        active: '{{bool()}}',
        age: '{{integer(5, 15)}}',
        name: '{{firstName()}} {{surname()}}',
        gender: '{{gender()}}',
        email: '{{email()}}',
        phone: '+3 {{phone()}}'
      }
    ]

### Youngling serialization

|                       Benchmark                       | Mode | Count |  Time  |   | Fault | Units |
|-------------------------------------------------------|------|-------|--------|---|-------|-------|
| c.j.t.b.youngling.SerializationYoungling.fstUnsafe    | avgt |    20 |  9.185 | ± | 0.387 | us/op |
| c.j.t.b.youngling.SerializationYoungling.fastjson     | avgt |    20 |  9.238 | ± | 0.454 | us/op |
| c.j.t.b.youngling.SerializationYoungling.fst          | avgt |    20 |   9.32 | ± | 0.363 | us/op |
| c.j.t.b.youngling.SerializationYoungling.jacksonJson  | avgt |    20 | 11.512 | ± | 0.364 | us/op |
| c.j.t.b.youngling.SerializationYoungling.jacksonSmile | avgt |    20 |   11.8 | ± | 0.288 | us/op |
| c.j.t.b.youngling.SerializationYoungling.kryo         | avgt |    20 | 17.623 | ± | 0.335 | us/op |
| c.j.t.b.youngling.SerializationYoungling.kryoUnsafe   | avgt |    20 | 17.753 | ± | 0.428 | us/op |
| c.j.t.b.youngling.SerializationYoungling.jdk          | avgt |    20 |  46.53 | ± | 1.576 | us/op |
| c.j.t.b.youngling.SerializationYoungling.messagePack  | avgt |    20 | 49.838 | ± | 1.602 | us/op |

<p align="center">
	<img src="https://github.com/jedivision-software/jdv-benchmarks/blob/master/jmh-serialization/img/SerializationYoungling.jpg?raw=true" alt=""/>
</p>

### Youngling deserialization

|                        Benchmark                        | Mode | Count |  Time   |   | Fault  | Units |
|---------------------------------------------------------|------|-------|---------|---|--------|-------|
| c.j.t.b.youngling.DeserializationYoungling.fastjson     | avgt |    20 |  11.303 | ± |  0.229 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.fstUnsafe    | avgt |    20 |  12.656 | ± |  0.284 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.jacksonSmile | avgt |    20 |  15.331 | ± |  0.270 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.jacksonJson  | avgt |    20 |  17.742 | ± |  0.433 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.kryoUnsafe   | avgt |    20 |  18.372 | ± |  0.381 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.kryo         | avgt |    20 |  18.376 | ± |  0.278 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.fst          | avgt |    20 |  23.231 | ± |  0.216 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.messagePack  | avgt |    20 |  42.622 | ± |  2.001 | us/op |
| c.j.t.b.youngling.DeserializationYoungling.jdk          | avgt |    20 | 262.363 | ± | 12.974 | us/op |

<p align="center">
	<img src="https://github.com/jedivision-software/jdv-benchmarks/blob/master/jmh-serialization/img/DeserializationYoungling.jpg?raw=true" alt=""/>
</p>

### Youngling summary

    1) FastJson implementation is efficient for simple JSON structure
    2) FST and Jackson implementation shows average result
    3) Default JDK is very slow

# Padawan ~ 500KB file
### Padawan JSON template

    [
      '{{repeat(500)}}',
      {
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

### Padawan serialization

|                     Benchmark                     | Mode | Count |   Time   |   |  Fault  | Units |
|---------------------------------------------------|------|-------|----------|---|---------|-------|
| c.j.t.b.padawan.SerializationPadawan.jacksonSmile | avgt |    20 |  871.391 | ± |  31.674 | us/op |
| c.j.t.b.padawan.SerializationPadawan.fst          | avgt |    20 |  974.727 | ± |  38.203 | us/op |
| c.j.t.b.padawan.SerializationPadawan.kryo         | avgt |    20 | 1040.589 | ± |  19.851 | us/op |
| c.j.t.b.padawan.SerializationPadawan.kryoUnsafe   | avgt |    20 | 1076.508 | ± |  74.631 | us/op |
| c.j.t.b.padawan.SerializationPadawan.jacksonJson  | avgt |    20 | 1094.142 | ± |  30.891 | us/op |
| c.j.t.b.padawan.SerializationPadawan.fstUnsafe    | avgt |    20 | 1143.053 | ± |  91.747 | us/op |
| c.j.t.b.padawan.SerializationPadawan.fastjson     | avgt |    20 | 1200.746 | ± |  42.326 | us/op |
| c.j.t.b.padawan.SerializationPadawan.jdk          | avgt |    20 | 3259.187 | ± | 101.133 | us/op |
| c.j.t.b.padawan.SerializationPadawan.messagePack  | avgt |    20 | 4221.451 | ± | 251.481 | us/op |

<p align="center">
	<img src="https://github.com/jedivision-software/jdv-benchmarks/blob/master/jmh-serialization/img/SerializationPadawan.jpg?raw=true" alt=""/>
</p>

### Padawan deserialization

|                      Benchmark                      | Mode | Count |   Time    |   |  Fault   | Units |
|-----------------------------------------------------|------|-------|-----------|---|----------|-------|
| c.j.t.b.padawan.DeserializationPadawan.fstUnsafe    | avgt |    20 |  1234.123 | ± |   31.295 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.kryoUnsafe   | avgt |    20 |  1329.885 | ± |   58.905 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.kryo         | avgt |    20 |  1405.841 | ± |   93.669 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.jacksonSmile | avgt |    20 |  1460.234 | ± |   30.434 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.fst          | avgt |    20 |   1615.05 | ± |   49.455 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.fastjson     | avgt |    20 |  1718.297 | ± |   72.949 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.jacksonJson  | avgt |    20 |  2049.522 | ± |   94.798 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.messagePack  | avgt |    20 |  5060.018 | ± | 1432.821 | us/op |
| c.j.t.b.padawan.DeserializationPadawan.jdk          | avgt |    20 | 12454.951 | ± |  255.441 | us/op |
<p align="center">
	<img src="https://github.com/jedivision-software/jdv-benchmarks/blob/master/jmh-serialization/img/DeserializationPadawan.jpg?raw=true" alt=""/>
</p>

### Padawan summary

    1) FastJson implementation is not so efficient for more complex JSON structure
    2) FST and Kryo implementations shows average result
    3) Default JDK is very slow

# Master ~ 12MB file
### Master JSON template

    [
      '{{repeat(50)}}',
      {
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

### Master serialization

|                    Benchmark                    | Mode | Count |   Time    |   |  Fault   | Units |
|-------------------------------------------------|------|-------|-----------|---|----------|-------|
| c.j.t.b.master.SerializationMaster.fst          | avgt |    20 | 15225.396 | ± | 1905.317 | us/op |
| c.j.t.b.master.SerializationMaster.fstUnsafe    | avgt |    20 | 15356.936 | ± | 2573.933 | us/op |
| c.j.t.b.master.SerializationMaster.jacksonSmile | avgt |    20 |  17435.29 | ± | 2713.010 | us/op |
| c.j.t.b.master.SerializationMaster.jacksonJson  | avgt |    20 | 21436.848 | ± | 2388.423 | us/op |
| c.j.t.b.master.SerializationMaster.messagePack  | avgt |    20 | 24457.526 | ± |  307.336 | us/op |
| c.j.t.b.master.SerializationMaster.jdk          | avgt |    20 | 33576.548 | ± | 5148.820 | us/op |
| c.j.t.b.master.SerializationMaster.kryoUnsafe   | avgt |    20 | 38330.612 | ± | 1057.353 | us/op |
| c.j.t.b.master.SerializationMaster.kryo         | avgt |    20 | 38489.036 | ± | 3252.439 | us/op |
| c.j.t.b.master.SerializationMaster.fastjson     | avgt |    20 | 75266.191 | ± | 6477.615 | us/op |

<p align="center">
	<img src="https://github.com/jedivision-software/jdv-benchmarks/blob/master/jmh-serialization/img/SerializationMaster.jpg?raw=true" alt=""/>
</p>

### Master deserialization

|                     Benchmark                     | Mode | Count |   Time    |   |   Fault   | Units |
|---------------------------------------------------|------|-------|-----------|---|-----------|-------|
| c.j.t.b.master.DeserializationMaster.fstUnsafe    | avgt |    20 | 15709.193 | ± |  2752.810 | us/op |
| c.j.t.b.master.DeserializationMaster.jacksonSmile | avgt |    20 | 18415.212 | ± |   429.781 | us/op |
| c.j.t.b.master.DeserializationMaster.fst          | avgt |    20 | 23469.581 | ± |  5365.872 | us/op |
| c.j.t.b.master.DeserializationMaster.jacksonJson  | avgt |    20 | 30635.827 | ± |  2415.138 | us/op |
| c.j.t.b.master.DeserializationMaster.messagePack  | avgt |    20 | 39614.778 | ± | 13398.180 | us/op |
| c.j.t.b.master.DeserializationMaster.kryoUnsafe   | avgt |    20 | 42383.201 | ± |  4839.326 | us/op |
| c.j.t.b.master.DeserializationMaster.kryo         | avgt |    20 | 47451.506 | ± |  8090.429 | us/op |
| c.j.t.b.master.DeserializationMaster.fastjson     | avgt |    20 | 62477.532 | ± | 13146.153 | us/op |
| c.j.t.b.master.DeserializationMaster.jdk          | avgt |    20 | 70896.623 | ± |  1098.658 | us/op |

<p align="center">
	<img src="https://github.com/jedivision-software/jdv-benchmarks/blob/master/jmh-serialization/img/DeserializationMaster.jpg?raw=true" alt=""/>
</p>

### Master summary

    1) FastJson implementation is not efficient for complex JSON structure
    2) FST and Jackson implementation shows average result
    3) Default JDK is very slow

# Summary

    1) FastJson implementation is efficient for simple, not efficient for complex JSON structure
    2) Default JDK is very slow
    3) FST, Kryo, Jackson implementations is efficient depending on JSON structure
    4) MessagePack implementation is slow
