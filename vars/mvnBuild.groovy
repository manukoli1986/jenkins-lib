#!/usr/bin/env groovy

tools {
  maven 'maven'
  jdk 'jdk'
}

def package() {
      sh 'mvn clean package -U -X'
      }
