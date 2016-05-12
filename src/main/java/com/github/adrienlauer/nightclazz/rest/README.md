**REST resources and representations are located under this package.** REST is an architectural style which promotes
state transfer between a client (like a browser) and a stateless server through an uniform interface (HTTP in our case).

Rules:

* Domain objects are never exposed without being transformed into DTOs, which are called representations in REST.
* Representations should be as flat as possible.
* Representations can be mapped from and to domain aggregates by assemblers and their DSL facade `FluentAssembler`. They
can also be directly constructed from **read-only** data finders which can bypass the application and domain layers to
efficiently query persistence.
* Using hypermedia should be preferred over hard-coded URLs.

Additional information:

* http://seedstack.org/docs/seed/manual/rest/
* http://seedstack.org/docs/business/manual/assemblers/
* http://seedstack.org/docs/business/manual/finders/
* https://en.wikipedia.org/wiki/Representational_state_transfer
