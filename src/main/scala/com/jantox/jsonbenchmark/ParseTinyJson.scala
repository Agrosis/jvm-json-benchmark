package com.jantox.jsonbenchmark

import com.fasterxml.jackson.databind.{ObjectMapper => JacksonObjectMapper}
import com.plasmaconduit.json.{JsonParser => PlasmaConduitJsonParser}
import argonaut.{Parse => ArgonautParser}
import play.api.libs.json.{Json => PlayJson}
import com.google.gson.{JsonParser => GsonJsonParser}
import spray.json.{JsonParser => SprayJsonParser}

import org.openjdk.jmh.annotations.{Scope, State, Benchmark}

object ParseTinyJson {

  @State(Scope.Thread)
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

}

class ParseTinyJson {

  @Benchmark
  def plasmaconduit(): Unit = {
    val success = PlasmaConduitJsonParser.parse(ParseTinyJson.string)
  }

  @Benchmark
  def argonaut(): Unit = {
    val parsed = ArgonautParser.parse(ParseTinyJson.string)
  }

  @Benchmark
  def spray(): Unit = {
    val ast = SprayJsonParser(ParseTinyJson.string)
  }

  @Benchmark
  def play(): Unit = {
    val json = PlayJson.parse(ParseTinyJson.string)
  }

  @Benchmark
  def gson(): Unit = {
    val parser = new GsonJsonParser()
    val json = parser.parse(ParseTinyJson.string)
  }

  @Benchmark
  def jackson(): Unit = {
    val mapper = new JacksonObjectMapper()
    val node = mapper.readTree(ParseTinyJson.string)
  }

}
