package validation.validationcontext.factories

import validation.validationcontext.ValidationContext

interface ValidationContextFactoryInterface<T> {
    fun createValidationContext(result: T?, isValidated: Boolean) : ValidationContext<T>
}