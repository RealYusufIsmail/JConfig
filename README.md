![](https://github.com/RealYusufIsmail/JConfig/blob/master/logo.png)
[![License: Apache 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Kotlin](https://img.shields.io/badge/kotlin-1.7.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.realyusufismail/jconfig/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.realyusufismail/jconfig)

# JConfig

JConfig is a simple library made to help with storing and retrieving data from a json file. 

Supporting both Kotlin and Java.

## Example

For example, say you are making a discord bot and you want to store the token in a json file, you can do this:

1. create a config.json file in the root of your project. If you want you can change the files name, but I will shows
   you how to do it with the default name.

```json
{
  "token": "YOUR_TOKEN_HERE"
}
```

2. We know need to get the token, so we will use JConfigUtils which has a standard builder.

```kotlin
val token = JConfigUtils.getString("token")
```

And thats it for getting the token.

## Installation

### Maven

```xml

<dependency>
    <groupId>io.github.realyusufismail</groupId>
    <artifactId>jconfig</artifactId>
    <version>1.0.3</version>
</dependency>
```

### Gradle

```groovy
//kotlin
dependencies {
   implementation("io.github.realyusufismail:jconfig:${project.version}")
}

//groovy
dependencies {
   implementation "io.github.realyusufismail:jconfig:${project.version}"
}
```

## Documentation

See the [wiki](https://realyusufismail.github.io/JConfig/index.html)

## Contributing

Just make a pr and wait for it to be reviewed.
