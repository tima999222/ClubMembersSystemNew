package scanners

import javax.inject.Inject

class StringScanner @Inject constructor (): ScannerInterface<String> {
    override fun scanEntity(): String? {
        return readlnOrNull()
    }
}