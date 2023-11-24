package data.repositories

import data.datacontext.ClubMembersDataContext
import data.entities.ClubMember
import data.factories.ClubMemberDataContextFactory
import data.factories.DataContextFactoryInterface
import javax.inject.Inject

class ClubMemberRepository @Inject constructor (databaseContextFactory: DataContextFactoryInterface<ClubMembersDataContext>) : ClubMemberRepositoryInterface {
    private val _context: ClubMembersDataContext

    init {
        _context = databaseContextFactory.createContext()
    }

    override fun addClubMember(item: ClubMember) {
        _context.clubMembers.add(item)
    }

    override fun deleteClubMember(item: ClubMember) {
        _context.clubMembers.remove(item)
    }

    override fun getClubMembers() : List<ClubMember> {
        return _context.clubMembers
    }

    override fun getClubMemberById(id: Int) : ClubMember? {
        return _context.clubMembers.find { it.id == id }
    }

    override fun sortClubMembers(arg: Comparator<ClubMember>): List<ClubMember> {
        return _context.clubMembers.sortedWith(arg)
    }

    override fun findClubMembers(arg: (ClubMember) -> Boolean): List<ClubMember> {
        return _context.clubMembers.filter(arg)
    }

    override fun updateClubMember(id: Int, clubMember: ClubMember) {
        if (_context.clubMembers.find { it.id == id } == null) return
        _context.clubMembers[id] = clubMember
    }
}