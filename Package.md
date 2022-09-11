

# Module jconfig

JConfig is a simple library made to help with storing and retrieving data from a json file.

## Example

For example, say you are making a discord bot and you want to store the token in a json file, you can do this:

1. create a config.json file in the root of your project. If you want you can change the files name, but I will shows you how to do it with the default name.

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
  <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
dependencies {
    implementation("io.github.realyusufismail:jconfig:${project.version}")
}
```