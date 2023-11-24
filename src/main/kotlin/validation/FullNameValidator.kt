package validation

import validation.validationcontext.ValidationContext
import validation.validationcontext.ValidationContextInterface
import validation.validationcontext.factories.ValidationContextFactoryInterface
import javax.inject.Inject

class FullNameValidator @Inject constructor (private val validationContextFactory: ValidationContextFactoryInterface<String>) : EntityValidator<String> {
    override fun validate(entity: String?): ValidationContextInterface<String> {
        if (!entity.isNullOrEmpty() && entity.split(" ").count() == 3) {
            return validationContextFactory.createValidationContext(entity, true)
        }

        return validationContextFactory.createValidationContext(null, false)
    }

}