package com.jantox.jsonbenchmark

import java.io.File

import argonaut.Parse
import com.plasmaconduit.json.JsonParser
import play.api.libs.json.Json
import spray.json._

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
