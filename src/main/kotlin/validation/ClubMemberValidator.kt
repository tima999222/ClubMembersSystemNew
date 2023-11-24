package validation

import data.entities.ClubMember
import validation.validationcontext.ValidationContext
import validation.validationcontext.factories.ValidationContextFactoryInterface
import javax.inject.Inject

class ClubMemberValidator @Inject constructor (private val validationContextFactory: ValidationContextFactoryInterface<ClubMember>): EntityValidator<ClubMember> {
    override fun validate(entity: ClubMember?): ValidationContext<ClubMember> {
        return if (entity!= null &&
            (entity.id != null && entity.id > 0)
            && !entity.name.isNullOrEmpty()
            && !entity.surname.isNullOrEmpty()
            && !entity.patronymic.isNullOrEmpty()
            && !entity.bicycleType.isNullOrEmpty()
            && (entity.experience != null && entity.experience >= 0)
        ) {
            validationContextFactory.createValidationContext(entity, true)
        } else {
            validationContextFactory.createValidationContext(null, false)
        }
    }
}