package com.jantox.jsonbenchmark

import java.io.File

import argonaut.Parse
import com.plasmaconduit.json.JsonParser
import play.api.libs.json.Json
import spray.json._

import org.openjdk.jmh.annotations.{Setup, Scope, State, Benchmark}

@State(Scope.Thread)
class ParseMediumJson {

  var string = ""

  @Setup
  def setup(): Unit = {
    string = scala.io.Source.fromFile(new File("./src/main/resources/medium.json")).mkString
  }

  @Benchmark
  def plasmaconduit(): Unit = {
    val success = JsonParser.parse(string)
  }

  @Benchmark
  def argonaut(): Unit = {
    Parse.parse(string)
  }

  @Benchmark
  def spray(): Unit = {
    val ast = string.parseJson
  }

  @Benchmark
  def play(): Unit = {
    val json = Json.parse(string)
  }

}
