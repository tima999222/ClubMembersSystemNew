package data.repositories

import data.entities.ClubMember

interface ClubMemberRepositoryInterface {
    fun addClubMember(item: ClubMember)

    fun deleteClubMember(item: ClubMember)

    fun getClubMembers() : List<ClubMember>

    fun getClubMemberById(id: Int) : ClubMember?

    fun sortClubMembers(arg: Comparator<ClubMember>) : List<ClubMember>

    fun findClubMembers(arg: (ClubMember) -> Boolean) : List<ClubMember>

    fun updateClubMember(id: Int, clubMember: ClubMember)
}