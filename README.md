jvm-json-benchmark
==================

To run benchmarks, run

```
sbt jmh:run -i 3 -wi 3 -f1 -t1 .
```

Latest benchmark:

```
[info] Benchmark                       Mode  Cnt        Score        Error  Units
[info] ParseBigJson.argonaut          thrpt    3       38.552 ±    117.342  ops/s
[info] ParseBigJson.plasmaconduit     thrpt    3        1.323 ±      1.689  ops/s
[info] ParseBigJson.play              thrpt    3       62.844 ±     94.086  ops/s
[info] ParseBigJson.spray             thrpt    3       46.968 ±    145.945  ops/s
[info] ParseMediumJson.argonaut       thrpt    3     4293.050 ±   1796.094  ops/s
[info] ParseMediumJson.plasmaconduit  thrpt    3      143.572 ±     91.474  ops/s
[info] ParseMediumJson.play           thrpt    3     7663.909 ±    613.920  ops/s
[info] ParseMediumJson.spray          thrpt    3     5277.624 ±   2986.461  ops/s
[info] ParseTinyJson.argonaut         thrpt    3   675880.689 ± 137370.558  ops/s
[info] ParseTinyJson.plasmaconduit    thrpt    3    24347.001 ±   6217.009  ops/s
[info] ParseTinyJson.play             thrpt    3   669037.810 ± 163123.886  ops/s
[info] ParseTinyJson.spray            thrpt    3  1215418.326 ± 201718.862  ops/s
```