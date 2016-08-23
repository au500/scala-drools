Using Drools in a Scala Application
====

Background
----------

Scala maintains interoperability with most Java libraries, so it is possible to use Drools in a Scala application. There are, however, a few important changes you need to do
in order to make Drools work. This repository will highlight some of those issues as well as their solutions.

In addition, this project is also to serve as an example of a multi-module SBT project for Scala/Drools applications.

A large portion of this example was adapted from the following blog post by Stefan Bleibinhaus, so all due credit is attributed to him: [http://bleibinha.us/blog/2014/04/drools-with-scala]

Using Scala Objects in Drools
---------------------------

Drools can reason over Scala objects as if they were regular Java objects, however the way Scala defines classes it does not automatically comply with
the expectations of the Drools framework. Therefore it is necessary to to implement your "fact" classes in Scala with two specific atributes.

__1. Use case classes__

    Drools expects fact classes to have reasonable implementations of equals and hashCode. Scala's case
    classes will automatically handle this by sensibly implementing those methods automatically based
    on the class structure. Documentation on Scala case classes can be found at
    [http://docs.scala-lang.org/tutorials/tour/case-classes.html]

__2. Annotate classes with @BeanInfo__

    Drools expects fact classes to have public getters when resolving the names of properties for pattern
    matching. Scala classes will not have these by default, but it is possible to tell the compiler to
    generate them using the annotation @BeanInfo. This annotation tells the compiler to make the class
    JavaBean compliant, so public getters will be available when the class is used in Java. Documentation
    on @BeanInfo can be found here: <http://www.scala-lang.org/api/2.7.3/scala/reflect/BeanInfo.html>

Making Drools Recognize KieModules when Using SBT
---------
__TODO__ - make this section better

Drools relies on Maven conventions. It expects that in a KModule project that there will be a META-INF/pom.properties. Since SBT will not generate
this automatically, you need to create and maintain one yourself.

There is an [example of this](./scala-rules-api/src/test/resources/META-INF/pom.properties) in the project.

Building
--------

This project is built using SBT: http://www.scala-sbt.org/

To build and run the examples, use the command below. You can verify that the examples are running in console output.

```bash
sbt clean test
```

Issues
-------
The ultimate goal is to incorporate this into an application that will be deployed on OpenShift. Tasks related to that effort
will be documented with GitHub issues.

