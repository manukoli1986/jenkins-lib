#!/usr/bin/groovy
package io.abc;
def build() {
  mvn clean deploy -U
}
