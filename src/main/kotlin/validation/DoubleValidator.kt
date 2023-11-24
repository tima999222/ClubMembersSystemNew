package validation

import validation.validationcontext.ValidationContext
import validation.validationcontext.ValidationContextInterface
import validation.validationcontext.factories.ValidationContextFactoryInterface
import javax.inject.Inject

class DoubleValidator @Inject constructor (private val validationContextFactory: ValidationContextFactoryInterface<Double>) : EntityValidator<Double> {
    override fun validate(entity: Double?): ValidationContextInterface<Double> {
        if (entity != null && entity >= 0) {

            return validationContextFactory.createValidationContext(entity, true)
        }

        return validationContextFactory.createValidationContext(null, false)
    }
}