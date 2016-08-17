jvm-json-benchmark
==================

To run benchmarks, run

```
sbt
jmh:run -i 3 -wi 3 -f1 -t1 .
```

Latest benchmark:

```
[info] Benchmark                       Mode  Cnt        Score        Error  Units
[info] ParseBigJson.argonaut          thrpt    3       38.216 ±    134.801  ops/s
[info] ParseBigJson.gson              thrpt    3       85.970 ±    131.233  ops/s
[info] ParseBigJson.jackson           thrpt    3      125.265 ±    294.327  ops/s
[info] ParseBigJson.plasmaconduit     thrpt    3        1.387 ±      1.374  ops/s
[info] ParseBigJson.play              thrpt    3       63.395 ±    163.180  ops/s
[info] ParseBigJson.spray             thrpt    3       45.240 ±     85.738  ops/s
[info] ParseMediumJson.argonaut       thrpt    3     4356.687 ±   1009.052  ops/s
[info] ParseMediumJson.gson           thrpt    3     8594.854 ±   1902.506  ops/s
[info] ParseMediumJson.jackson        thrpt    3    13934.342 ±   4748.802  ops/s
[info] ParseMediumJson.plasmaconduit  thrpt    3      148.365 ±     31.778  ops/s
[info] ParseMediumJson.play           thrpt    3     7683.303 ±   1082.325  ops/s
[info] ParseMediumJson.spray          thrpt    3     5443.595 ±   1769.973  ops/s
[info] ParseTinyJson.argonaut         thrpt    3   674005.324 ±  71216.049  ops/s
[info] ParseTinyJson.gson             thrpt    3   894098.734 ±  50374.374  ops/s
[info] ParseTinyJson.jackson          thrpt    3   448138.128 ±  43191.723  ops/s
[info] ParseTinyJson.plasmaconduit    thrpt    3    24126.164 ±  15093.288  ops/s
[info] ParseTinyJson.play             thrpt    3   674997.076 ± 187364.243  ops/s
[info] ParseTinyJson.spray            thrpt    3  1205213.894 ± 513301.997  ops/s
```