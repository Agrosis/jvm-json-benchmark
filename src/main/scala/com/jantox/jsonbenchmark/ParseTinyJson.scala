package com.jantox.jsonbenchmark

import com.plasmaconduit.json.{JsonParser => PlasmaConduitJsonParser}
import argonaut.{Parse => ArgonautParse}
import spray.json.{JsonParser => SprayJsonParser}
import play.api.libs.json.{Json => PlayJson}
import com.google.gson.{JsonParser => GsonJsonParser}
import com.fasterxml.jackson.databind.{ObjectMapper => JacksonObjectMapper}

import org.openjdk.jmh.annotations.{Scope, State, Benchmark}

@State(Scope.Thread)
class ParseTinyJson {

  val string =
    """
      |{
      |  "a": 1,
      |  "b": true,
      |  "c": "test",
      |  "d": {
      |    "d1": 3,
      |    "d2": 4
      |  }
      |}
    """.stripMargin

  @Benchmark
  def plasmaconduit(): Unit = {
    val success = PlasmaConduitJsonParser.parse(string)
  }

  @Benchmark
  def argonaut(): Unit = {
    val parsed = ArgonautParse.parse(string)
  }

  @Benchmark
  def spray(): Unit = {
    val ast = SprayJsonParser(string)
  }

  @Benchmark
  def play(): Unit = {
    val json = PlayJson.parse(string)
  }

  val parser = new GsonJsonParser()

  @Benchmark
  def gson(): Unit = {
    val json = parser.parse(string)
  }

  val mapper = new JacksonObjectMapper()

  @Benchmark
  def jackson(): Unit = {
    val node = mapper.readTree(string)
  }

}
