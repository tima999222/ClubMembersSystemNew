package validation.validationcontext

interface ValidationContextInterface<T> {
    val result: T?

    val isValidated: Boolean
}