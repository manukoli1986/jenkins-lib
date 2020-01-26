#!/usr/bin/env groovy

tools {
  maven 'maven'
  jdk 'jdk'
}

def verify {
      sh 'mvn clean verify -U -X'
      }

def test {
      sh 'mvn test -U -X'
      }

//def call(mvn) {
//      withMaven(maven: 'maven') {
//      sh 'mvn clean verify -DSkiptest=True -U -X'
//      }
//}
