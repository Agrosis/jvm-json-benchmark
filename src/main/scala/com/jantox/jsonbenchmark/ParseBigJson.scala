package com.jantox.jsonbenchmark

import java.io.File

import com.plasmaconduit.json.{JsonParser => PlasmaConduitJsonParser}
import argonaut.{Parse => ArgonautParse}
import spray.json.{JsonParser => SprayJsonParser}
import play.api.libs.json.{Json => PlayJson}
import com.google.gson.{JsonParser => GsonJsonParser}
import com.fasterxml.jackson.databind.{ObjectMapper => JacksonObjectMapper}

import org.openjdk.jmh.annotations.{Scope, State, Setup, Benchmark}

@State(Scope.Thread)
class ParseBigJson {

  var string = ""

  @Setup
  def setup(): Unit = {
    string = scala.io.Source.fromFile(new File("./src/main/resources/big.json")).mkString
  }

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
