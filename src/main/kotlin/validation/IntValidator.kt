package validation

import validation.validationcontext.ValidationContext
import validation.validationcontext.factories.ValidationContextFactoryInterface
import javax.inject.Inject

class IntValidator @Inject constructor (private val validationContextFactory: ValidationContextFactoryInterface<Int>) : EntityValidator<Int> {
    override fun validate(entity: Int?): ValidationContext<Int> {
        if (entity != null && entity > 0) {
            return validationContextFactory.createValidationContext(entity, true)
        }

        return validationContextFactory.createValidationContext(null, false);
    }
}