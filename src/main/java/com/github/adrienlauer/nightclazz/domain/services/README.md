**Domain services are located under this package.** Domain services are stateless objects that implement logic which doesn’t fit
directly in the domain model (entities or value objects).

Example:

    @Service
    public interface AccountTransferService {

        public AccountTransferReport transferMoney(Account toBeDebited, Account toBeCredited, Amount transferAmount);

    }

Rules:

* Domain services only contains pure domain logic. Naming should come from the ubiquitous language or be introduced into
it if necessary. Parameters and return values should be domain objects. Example: a bank account transfer service.
* If a service implementation depends upon a specific technology or external library, it should be relocated to the
infrastructure package.
* Create a service only if the logic cannot be located in an entity or a value object.
* Avoid generic naming like "AccountManagementService" but prefer focused and intention-revealing names.

Additional information:

* http://seedstack.org/docs/business/manual/model/
* http://seedstack.org/docs/business/manual/lifecycle/
