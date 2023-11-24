package data.datacontext

import data.entities.ClubMember
import javax.inject.Inject

class ClubMembersDataContext @Inject constructor () : DataContextInterface {
    val clubMembers = mutableListOf<ClubMember>()
}