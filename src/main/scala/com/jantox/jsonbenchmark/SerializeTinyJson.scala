package com.jantox.jsonbenchmark

import com.plasmaconduit.json.{JsonParser => PlasmaConduitJsonParser}
import argonaut.{Parse => ArgonautParser, Json => ArgonautJson}
import spray.json.{JsonParser => SprayJsonParser, JsValue => SprayJsValue}
import play.api.libs.json.{Json => PlayJson, JsValue => PlayJsValue}
import com.google.gson.{JsonParser => GsonJsonParser}
import com.fasterxml.jackson.databind.{ObjectMapper => JacksonObjectMapper}

import org.openjdk.jmh.annotations.{Setup, Benchmark, Scope, State}

@State(Scope.Thread)
class SerializeTinyJson {

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

  var plasmaAst: com.plasmaconduit.json.JsValue = null
  var argonautAst: ArgonautJson = null
  var sprayAst: SprayJsValue = null
  var playAst: PlayJsValue = null
  var gsonAst: com.google.gson.JsonElement = null
  var jacksonAst: com.fasterxml.jackson.databind.JsonNode = null

  @Setup
  def setup(): Unit = {
    plasmaAst = PlasmaConduitJsonParser.parse(string).toOption.get
    argonautAst = ArgonautParser.parse(string).toEither.right.get
    sprayAst = SprayJsonParser(string)
    playAst = PlayJson.parse(string)
    gsonAst = new GsonJsonParser().parse(string)
    jacksonAst = new JacksonObjectMapper().readTree(string)
  }

  @Benchmark
  def plasmaconduit(): Unit = {
    val str = plasmaAst.toString
  }

  @Benchmark
  def argonaut(): Unit = {
    val str = argonautAst.nospaces
  }

  @Benchmark
  def spray(): Unit = {
    val str = sprayAst.compactPrint
  }

  @Benchmark
  def play(): Unit = {
    val str = PlayJson.stringify(playAst)
  }

  @Benchmark
  def gson(): Unit = {
    val str = gsonAst.toString
  }

  val mapper = new com.fasterxml.jackson.databind.ObjectMapper()

  @Benchmark
  def jackson(): Unit = {
    val node = mapper.writeValueAsString(jacksonAst)
  }

}
