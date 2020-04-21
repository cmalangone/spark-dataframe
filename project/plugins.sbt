resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/eed3si9n/sbt-plugins/"))(Resolver.ivyStylePatterns)
resolvers += "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven/"

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.1")
// The Play plugin
//addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.1")
