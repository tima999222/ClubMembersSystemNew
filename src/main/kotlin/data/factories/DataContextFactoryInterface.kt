package data.factories

import data.datacontext.DataContextInterface

interface DataContextFactoryInterface<T> where T: DataContextInterface {
    fun createContext() : T
}