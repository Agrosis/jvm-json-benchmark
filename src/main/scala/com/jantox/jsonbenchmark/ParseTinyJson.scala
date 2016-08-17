package com.jantox.jsonbenchmark

import argonaut.Parse
import com.plasmaconduit.json.JsonParser
import play.api.libs.json.Json
import spray.json._

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
    val success = JsonParser.parse(ParseTinyJson.string)
  }

  @Benchmark
  def argonaut(): Unit = {
    val parsed = Parse.parse(ParseTinyJson.string)
  }

  @Benchmark
  def spray(): Unit = {
    val ast = ParseTinyJson.string.parseJson
  }

  @Benchmark
  def play(): Unit = {
    val json = Json.parse(ParseTinyJson.string)
  }

}
