jvm-json-benchmark
==================

To run benchmarks, run

```
sbt
jmh:run -i 3 -wi 3 -f1 -t1 .
```

Latest benchmark:

```
[info] Benchmark                         Mode  Cnt        Score         Error  Units
[info] ParseBigJson.argonaut            thrpt    3       38.102 ±     153.431  ops/s
[info] ParseBigJson.gson                thrpt    3       70.307 ±     139.982  ops/s
[info] ParseBigJson.jackson             thrpt    3      139.005 ±     225.032  ops/s
[info] ParseBigJson.plasmaconduit       thrpt    3        1.417 ±       0.263  ops/s
[info] ParseBigJson.play                thrpt    3       69.953 ±     100.620  ops/s
[info] ParseBigJson.spray               thrpt    3       48.059 ±     109.202  ops/s
[info] ParseMediumJson.argonaut         thrpt    3     4460.210 ±     704.556  ops/s
[info] ParseMediumJson.gson             thrpt    3     9034.327 ±    1806.742  ops/s
[info] ParseMediumJson.jackson          thrpt    3    16032.613 ±    3735.834  ops/s
[info] ParseMediumJson.plasmaconduit    thrpt    3      152.861 ±      32.474  ops/s
[info] ParseMediumJson.play             thrpt    3     7634.257 ±     918.320  ops/s
[info] ParseMediumJson.spray            thrpt    3     5471.179 ±    1972.990  ops/s
[info] ParseTinyJson.argonaut           thrpt    3   699658.778 ±   94337.916  ops/s
[info] ParseTinyJson.gson               thrpt    3   906176.169 ±  153950.346  ops/s
[info] ParseTinyJson.jackson            thrpt    3  1622076.953 ±   68047.844  ops/s
[info] ParseTinyJson.plasmaconduit      thrpt    3    25700.022 ±    8395.233  ops/s
[info] ParseTinyJson.play               thrpt    3   691922.670 ±  124814.238  ops/s
[info] ParseTinyJson.spray              thrpt    3  1238498.454 ±   84305.710  ops/s
[info] SerializeTinyJson.argonaut       thrpt    3   924744.180 ±  164338.041  ops/s
[info] SerializeTinyJson.gson           thrpt    3  1511757.309 ± 2900059.491  ops/s
[info] SerializeTinyJson.jackson        thrpt    3  3351139.260 ±  681776.596  ops/s
[info] SerializeTinyJson.plasmaconduit  thrpt    3   654295.441 ±   54954.043  ops/s
[info] SerializeTinyJson.play           thrpt    3   552459.991 ±  173196.771  ops/s
[info] SerializeTinyJson.spray          thrpt    3  2431462.672 ±  939674.081  ops/s
```