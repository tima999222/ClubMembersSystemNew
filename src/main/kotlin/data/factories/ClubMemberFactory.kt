package data.factories

import data.entities.ClubMember
import javax.inject.Inject

class ClubMemberFactory @Inject constructor() : ClubMemberFactoryInterface {
    override fun createClubMember(
        id: Int?,
        surname: String?,
        name: String?,
        patronymic: String?,
        bicycleType: String?,
        exp: Double?
    ): ClubMember {
        return ClubMember(id, surname, name, patronymic, bicycleType, exp)
    }

}