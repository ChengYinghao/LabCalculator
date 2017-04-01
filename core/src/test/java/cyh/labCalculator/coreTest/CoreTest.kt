package cyh.labCalculator.coreTest

import cyh.labCalculator.core.MeasuredQuantity
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class CoreTest{
	
	@Test
	fun testMeasuredQuantity(){
		val measuredValues = arrayListOf(5.5, 4.3, 5.3, 5.2)
		val measuredQuantity = MeasuredQuantity(measuredValues, 0.1/Math.sqrt(3.0))
		
		
		println("average:${measuredQuantity.value}")
		println("count:${measuredQuantity.valueCount}")
		println("uncertaintyA:${measuredQuantity.uncertaintyA}")
		println("uncertaintyB:${measuredQuantity.uncertaintyB}")
		println("uncertainty:${measuredQuantity.uncertainty}")
		
	}
}
