#!/usr/bin/env groovy

tools {
  maven 'maven'
  jdk 'jdk'
}

def mvn(args) {
  sh 'mvn clean package ${args}'
      }
