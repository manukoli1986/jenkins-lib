#!/usr/bin/env groovy

tools {
  maven 'maven'
  jdk 'jdk'
}
def call(test) {
      sh 'mvn test -U -X'
      }
