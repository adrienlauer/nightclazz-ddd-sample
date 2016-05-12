**The domain model is located under this package.** The domain model is expressed through:

* **Entities** which are objects defined primarily by their identity,
* **Value Objects** which are objects with no conceptual identity and solely defined by their attributes.

Domain objects have a lifecycle: they are created, go through various states and eventually die (either being archived or
deleted). Many of these objects are simple, transient objects which are simply created with a call to their constructor
and thrown away after use. There is no need to complicate such objects. But some objects are more rich, with a complex
lifecycle and numerous relationships with other objects. The challenges of managing these objects can be addressed by
three patterns:

* **Aggregates**, which define clear ownership and boundaries between domain objects.
* **Repositories**, which encapsulate the logic of persisting and retrieving aggregates.
* **Factories**, which encapsulate the logic of creating aggregates.

Rules:

* Each aggregate must reside in its own package.
* An aggregate always have an entity which acts as the aggregate root.
* Hard references between aggregates are **FORBIDDEN**. Aggregates are only allowed to reference other aggregates
by the identity of their aggregate root.
* If a repository or a factory implementation depends upon a specific technology or external library, it should be
relocated to the infrastructure package.

Additional information:

* http://seedstack.org/docs/business/manual/model/
