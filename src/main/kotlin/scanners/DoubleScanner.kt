package scanners

import javax.inject.Inject

class DoubleScanner @Inject constructor () : ScannerInterface<Double> {
    override fun scanEntity(): Double? {
        return readlnOrNull()?.toDoubleOrNull()
    }

}