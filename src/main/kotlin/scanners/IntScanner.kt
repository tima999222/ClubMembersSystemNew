package scanners

import javax.inject.Inject

class IntScanner @Inject constructor (): ScannerInterface<Int> {
    override fun scanEntity(): Int? {
        return readlnOrNull()?.toIntOrNull()
    }
}