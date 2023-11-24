package validation

import validation.validationcontext.ValidationContextInterface

interface EntityValidator<T> {
    fun validate(entity: T?) : ValidationContextInterface<T>
}