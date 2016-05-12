**The application logic is located under this package.** It is responsible for driving the workflow of the application,
executing the use cases of the system.

Rules:

* These operations are independent of the interfaces by which they are exposed (REST, CLI, ...).
* This layer is well suited for spanning transactions, high-level logging and security.
* The application layer is thin in terms of domain logic, it merely coordinates the domain layer objects to perform the
actual work through application services.

Additional information:

* http://seedstack.org/docs/business/manual/
