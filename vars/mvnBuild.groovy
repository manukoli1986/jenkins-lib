#!/usr/bin/env groovy

def call() {
      withMaven(maven: 'maven') {
      sh 'mvn clean verify -DSkiptest=True'
      }
//      mvn clean verify -DSkiptest=True
}
