package data.printers

import data.entities.ClubMember

interface ClubMembersPrinterInterface {
    fun printClubMember(clubMember: ClubMember)
    fun printClubMember(clubMembers: List<ClubMember>)
}