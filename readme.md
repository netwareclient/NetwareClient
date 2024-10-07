## About library
Netware Client is a straightforward networking library to simplify networking in Kotlin and Java. This library is created to simplify the process of sending and receiving data between clients and servers. Please refer to the following documentation to learn how you can use this library in your project. [View the documentation](https://netwareclient.vercel.app/)

Netware Client supports the following operations:
- Send `GET`, `POST`, `PATCH`, and `DELETE` HTTP requests.
- Send headers along with the network requests.
- Accept server response in `JSON` format.
- Send request body in `JSON` format.
- Display response in well format.

### Add to your project

This library can be used in Java or Kotlin project that uses Gradle build system. I’m also planning to add support for project that uses Maven build system. Follow the following steps to add the library to your project.

***Step 1:*** Add the following line in your project's `build.gradle` or `build.gradle.kts` file depending upon which build type you have chosen for your project and click on sync.

- **For `build.gradle.kts`:**
```groovy
maven { url = uri("https://jitpack.io") }
```

- **For `build.gradle`:**
```groovy
maven { url "https://jitpack.io" }
```

You may wonder where to add the above lines in your Java or Kotlin project. Don't worry, you may find the following code structure in your `build.gradle` or `build.gradle.kts` file. Just copy and paste the above line in your code structure.

```groovy
// Your code structure inside repositories should look like this
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}
```

***Step 2:*** Add this following line in your project's `build.gradle` or `build.gradle.kts` and click on sync.

- **For `build.gradle.kts`:**
```groovy
implementation("com.github.netwareclient:netwareclient:v0.0.8-alpha")
```

- **For `build.gradle`:**
```groovy
implementation "com.github.netwareclient:netwareclient:v0.0.8-alpha"
```

Where to add the above lines? You may find the following code structure in your `build.gradle` or `build.gradle.kts` file. Just copy and paste the above line in your code structure.
```groovy
dependencies {

    // Insert the above line here
    implementation("com.github.netwareclient:netwareclient:v0.0.8-alpha")
    
    // Your another project dependencies
}
```

Once it's done, then congratulate to yourself; now you're ready to use ***Netware Client*** for your project.

### Background story

When I was learning how to send network requests in Java and later on in Kotlin, I realized that there is no easy way to do that. Even though there are libraries available in the market like Volley, Ktor Client, Fuel, etc., these libraries are often complicated to implement, and if you have to send or test network requests, you have to write a big boilerplate code. With simplification and efficiency in mind, I decided to work on this library. I understand this library isn't that good and mature right now, but it definitely helps you perform and test network requests. To make this library mature and more efficient, I need contributors. If anyone who's reading this finds my idea interesting, then you can definitely contribute to this project. Just keep one thing in mind: we have to make this library very simple to implement and efficient to handle all tasks. You can contact me using this email: sudarshanmhasrup@gmail.com. 

### Authors
[@Sudarshan Mhasrup](https://github.com/sudarshanmhasrup)
