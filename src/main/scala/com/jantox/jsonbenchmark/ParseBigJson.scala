package com.jantox.jsonbenchmark

import java.io.File

import com.fasterxml.jackson.databind.{ObjectMapper => JacksonObjectMapper}
import com.plasmaconduit.json.{JsonParser => PlasmaConduitJsonParser}
import argonaut.{Parse => ArgonautParser}
import play.api.libs.json.{Json => PlayJson}
import com.google.gson.{JsonParser => GsonJsonParser}
import spray.json.{JsonParser => SprayJsonParser}

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
    ArgonautParser.parse(string)
  }

  @Benchmark
  def spray(): Unit = {
    val ast = SprayJsonParser(string)
  }

  @Benchmark
  def play(): Unit = {
    val json = PlayJson.parse(string)
  }

  @Benchmark
  def gson(): Unit = {
    val parser = new GsonJsonParser()
    val json = parser.parse(string)
  }

  @Benchmark
  def jackson(): Unit = {
    val mapper = new JacksonObjectMapper()
    val node = mapper.readTree(string)
  }

}
