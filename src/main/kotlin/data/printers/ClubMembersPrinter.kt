package data.printers

import data.entities.ClubMember
import javax.inject.Inject

class ClubMembersPrinter @Inject constructor () : ClubMembersPrinterInterface {
    override fun printClubMember(clubMember: ClubMember) {
        println("${clubMember.id} ${clubMember.surname} ${clubMember.name} ${clubMember.patronymic} ${clubMember.bicycleType} ${clubMember.experience}")
    }

    override fun printClubMember(clubMembers: List<ClubMember>) {
        for (cm in clubMembers) {
            println("${cm.id} ${cm.surname} ${cm.name} ${cm.patronymic} ${cm.bicycleType} ${cm.experience}")
        }
    }

}