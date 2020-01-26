#!/usr/bin/env groovy

tools {
  maven 'maven'
  jdk 'jdk'
}

def mvn {
      sh 'mvn clean verify -DSkiptest=True -U -X'
      }


//def call(mvn) {
//      withMaven(maven: 'maven') {
//      sh 'mvn clean verify -DSkiptest=True -U -X'
//      }
//}
