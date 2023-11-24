package scanners

import data.entities.ClubMember
import data.factories.ClubMemberFactoryInterface
import javax.inject.Inject

class ClubMemberScanner @Inject constructor (private val clubMemberFactory: ClubMemberFactoryInterface) : ScannerInterface<ClubMember> {
    override fun scanEntity(): ClubMember? {
        print("enter id: ")
        val id = readlnOrNull()?.toIntOrNull()
        print("enter surname: ")
        val surname = readlnOrNull()
        print("enter name: ")
        val name = readlnOrNull()
        print("enter patronymic: ")
        val patronymic = readlnOrNull()
        print("enter bicycle type: ")
        val bicycleType = readlnOrNull()
        print("enter experience: ")
        val exp = readlnOrNull()?.toDoubleOrNull()

        return clubMemberFactory.createClubMember(id, surname, name, patronymic, bicycleType, exp)
    }

}