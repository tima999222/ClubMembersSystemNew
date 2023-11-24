package di

import action.Action
import action.factories.ActionFactory
import action.factories.ActionFactoryInterface
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import data.datacontext.ClubMembersDataContext
import data.datacontext.DataContextInterface
import data.entities.ClubMember
import data.factories.ClubMemberDataContextFactory
import data.factories.ClubMemberFactory
import data.factories.ClubMemberFactoryInterface
import data.factories.DataContextFactoryInterface
import data.printers.ClubMembersPrinter
import data.printers.ClubMembersPrinterInterface
import data.repositories.ClubMemberRepository
import data.repositories.ClubMemberRepositoryInterface
import helpers.*
import scanners.*
import ui.controls.Menu
import ui.controls.MenuInterface
import ui.controls.MenuItem
import ui.factories.MenuFactory
import ui.factories.MenuFactoryInterface
import ui.factories.MenuItemFactory
import ui.factories.MenuItemFactoryInterface
import ui.printers.MenuPrinter
import ui.printers.MenuPrinterInterface
import validation.*
import validation.validationcontext.factories.ValidationContextFactory
import validation.validationcontext.factories.ValidationContextFactoryInterface

@Module
interface MainModule {

    @Binds
    fun bindValidationContextFactoryInt(validationContextFactory: ValidationContextFactory<Int>) : ValidationContextFactoryInterface<Int>

    @Binds
    fun bindValidationContextFactoryString(validationContextFactory: ValidationContextFactory<String>) : ValidationContextFactoryInterface<String>

    @Binds
    fun bindValidationContextFactoryClubMember(validationContextFactory: ValidationContextFactory<ClubMember>) : ValidationContextFactoryInterface<ClubMember>

    @Binds
    fun bindValidationContextFactoryDouble(validationContextFactory: ValidationContextFactory<Double>) : ValidationContextFactoryInterface<Double>

    @Binds
    fun bindIntValidator(intValidator: IntValidator) : EntityValidator<Int>

    @Binds
    fun bindFullNameValidator(fullNameValidator: FullNameValidator) : EntityValidator<String>

    @Binds
    fun bindClubMemberValidator(clubMemberValidator: ClubMemberValidator) : EntityValidator<ClubMember>

    @Binds
    fun bindDoubleValidator(intValidator: DoubleValidator) : EntityValidator<Double>

    @Binds
    fun bindMenu(menu: Menu) : MenuInterface

    @Binds
    fun bindMenuFactory(menuFactory: MenuFactory) : MenuFactoryInterface

    @Binds
    fun bindMenuItemFactory(menuItemFactory: MenuItemFactory) : MenuItemFactoryInterface

    @Binds
    fun bindMenuPrinter(menuPrinter: MenuPrinter) : MenuPrinterInterface

    @Binds
    fun bindMenuItem(menuItem: MenuItem) : MenuItem

    @Binds
    fun bindClubMemberScanner(clubMemberScanner: ClubMemberScanner) : ScannerInterface<ClubMember>

    @Binds
    fun bindIntScanner(intScanner: IntScanner) : ScannerInterface<Int>

    @Binds
    fun bindDoubleScanner(doubleScanner: DoubleScanner) : ScannerInterface<Double>

    @Binds
    fun bindStringScanner(strScanner: StringScanner) : ScannerInterface<String>

    @Binds
    fun bindActionFactory(actionFactory: ActionFactory) : ActionFactoryInterface<Action>

    @Binds
    fun bindClubMemberDataContext(clubMembersDataContext: ClubMembersDataContext) : DataContextInterface

    @Binds
    fun bindClubMemberDataContextFactory(clubMembersDataContextFactory: ClubMemberDataContextFactory) : DataContextFactoryInterface<ClubMembersDataContext>

    @Binds
    fun bindClubMemberFactory(clubMemberFactory: ClubMemberFactory) : ClubMemberFactoryInterface

    @Binds
    fun bindClubMemberPrinter(clubMembersPrinter: ClubMembersPrinter) : ClubMembersPrinterInterface

    @Binds
    fun bindClubMemberRepository(clubMemberRepository: ClubMemberRepository) : ClubMemberRepositoryInterface

    @Binds
    fun bindMenuItemsInitializer(menuItemsInitializer: MenuItemsInitializer) : MenuItemsInitializerInterface

    @Binds
    fun bindMenuInitializer(menuInitializer: MenuInitializer) : MenuInitializerInterface
}

@Component(modules = [MainModule::class])
interface AppComponent {
    val menuInitializer: helpers.MenuInitializerInterface
}