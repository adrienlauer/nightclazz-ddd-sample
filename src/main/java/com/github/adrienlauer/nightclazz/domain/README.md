**The domain and its sub-domains are located under this package.** The Domain Layer is where the business is expressed.

Important:

It is often necessary to share the domain (or a subset of it) between multiple modules. In this case you can use the
"domain" project template to create **a reusable domain JAR** that you will use instead of, or in addition to this package.
For instance, you can choose to create one or more domain JAR that you will add as dependencies of your batch, web and
cli modules.

Rules:

* The domain is independent of the use cases of the system, but is used to achieve their realization,
* It is a very behaviour-rich and expressive model of the domain, based on entities, values objects and aggregates.
* It contains additional patterns, such as domain services, repositories, factories, policies, etc...

Additional information:

* http://seedstack.org/docs/business/manual/
