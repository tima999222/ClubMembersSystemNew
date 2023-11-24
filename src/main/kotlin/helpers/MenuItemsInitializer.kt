package helpers

import action.factories.ActionFactoryInterface
import ui.controls.MenuItem
import ui.factories.MenuItemFactoryInterface
import action.Action
import data.entities.ClubMember
import data.printers.ClubMembersPrinterInterface
import data.repositories.ClubMemberRepositoryInterface
import scanners.ScannerInterface
import validation.EntityValidator
import javax.inject.Inject

class MenuItemsInitializer @Inject constructor (
    private val menuItemFactory: MenuItemFactoryInterface,
    private val actionFactory: ActionFactoryInterface<Action>,
    private val clubMemberRepository: ClubMemberRepositoryInterface,
    private val clubMembersPrinter: ClubMembersPrinterInterface,
    private val clubMemberValidator: EntityValidator<ClubMember>,
    private val intScanner: ScannerInterface<Int>,
    private val intValidator: EntityValidator<Int>,
    private val clubMemberScanner: ScannerInterface<ClubMember>,
    private val strValidator: EntityValidator<String>,
    private val strScanner: ScannerInterface<String>
) : MenuItemsInitializerInterface {
    override fun initMenuItems() : List<MenuItem> {

        val showClubMembers = menuItemFactory.createMenuItem(1, "Show club members",
            actionFactory.createAction {
                clubMembersPrinter.printClubMember(clubMemberRepository.getClubMembers())
            }
        )

        val deleteClubMemberById = menuItemFactory.createMenuItem(2, "Delete club member",
            actionFactory.createAction {
                val id = intScanner.scanEntity()
                val validationContext = intValidator.validate(id)
                if (!validationContext.isValidated) {
                    println("Enter correct number")
                }
                else {
                    val clubMember = clubMemberRepository.getClubMemberById(validationContext.result!!)
                    val clubMemberValidationContext = clubMemberValidator.validate(clubMember)
                    if (!clubMemberValidationContext.isValidated) {
                        println("Can't get club member")
                    }
                    else {
                        clubMemberRepository.deleteClubMember(clubMemberValidationContext.result!!)
                    }

                }
            }
        )

        val addClubMember = menuItemFactory.createMenuItem(3, "Add club member",
            actionFactory.createAction {
                val clubMember = clubMemberScanner.scanEntity()
                val validationContext = clubMemberValidator.validate(clubMember)

                if (!validationContext.isValidated) {
                    println("Some fields of club member are incorrect")
                }
                else {
                    clubMemberRepository.addClubMember(clubMember!!)
                }
            }
        )

        val sortClubMembers = menuItemFactory.createMenuItem(4, "Sort club members by experience",
            actionFactory.createAction {
                val result = clubMemberRepository.sortClubMembers(compareBy(ClubMember::experience))
                clubMembersPrinter.printClubMember(result)
            }
        )

        val findClubMember = menuItemFactory.createMenuItem(5, "Find club member by full name",
            actionFactory.createAction {
                val fullName = strScanner.scanEntity()

                val validationContext = strValidator.validate(fullName)
                if (!validationContext.isValidated) {
                    println("Enter correct full name")
                }
                else {
                    val splitFullName = validationContext.result!!.split(" ")
                    val result = clubMemberRepository.findClubMembers {
                        splitFullName[0] == it.surname
                                && splitFullName[1] == it.name
                                && splitFullName[2] == it.patronymic
                    }
                    clubMembersPrinter.printClubMember(result)
                }
            }
        )

        val updateClubMember = menuItemFactory.createMenuItem(6, "Update club member",
            actionFactory.createAction {
                print("enter id: ")
                val id = intScanner.scanEntity()
                val validationContext = intValidator.validate(id)
                if (!validationContext.isValidated) {
                    println("Enter correct id")
                }
                else {

                }
            }
        )

        return listOf(showClubMembers,
            deleteClubMemberById,
            addClubMember,
            sortClubMembers,
            findClubMember,
            )
    }

}