package data.factories

import data.datacontext.ClubMembersDataContext
import javax.inject.Inject

class ClubMemberDataContextFactory @Inject constructor () : DataContextFactoryInterface<ClubMembersDataContext> {
    private var _context: ClubMembersDataContext? = null

    override fun createContext(): ClubMembersDataContext {
        if (_context == null) {
            _context = ClubMembersDataContext()
        }

        return _context as ClubMembersDataContext
    }

}