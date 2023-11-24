package validation.validationcontext.factories

import validation.validationcontext.ValidationContext
import javax.inject.Inject

class ValidationContextFactory<T> @Inject constructor () : ValidationContextFactoryInterface<T> {
    override fun createValidationContext(result: T?, isValidated: Boolean): ValidationContext<T> {
        return ValidationContext(result, isValidated)
    }
}