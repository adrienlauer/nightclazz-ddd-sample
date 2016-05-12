**The infrastructure is located under this package.** The infrastructure layer contains the technology-specific
implementations of interfaces defined in other layers.

Rules:

* It supports all of the three other layers in different ways, facilitating communication between the layers.
* It consists of everything that would still exist without the application: external libraries, database engine, application
server, messaging backend and so on.
* This layer can be completely replaced by another one with other technological choices without altering the system behavior.

We often declare Java interfaces in interface, application and domain layers and implement them in the infrastructure layer.
A good example is the repository: interfaces are located in the domain layer but the implementation is in the infrastructure
under a sub-package named after its technology (like "jpa", "mongodb", ...).

Additional information:

* http://seedstack.org/docs/business/manual/
