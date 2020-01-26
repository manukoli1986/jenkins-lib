#!/usr/bin/env groovy

tools {
  maven 'maven'
  jdk 'jdk'
}

def package(args) {
  sh 'mvn clean package ${args}'
      }

def test(args) {
  sh 'mvn test ${args}'
      }
