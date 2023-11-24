package validation.validationcontext

class ValidationContext<T>(
    override val result: T?,
    override val isValidated: Boolean
) : ValidationContextInterface<T> {

}