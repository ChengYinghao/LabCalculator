package cyh.labCalculator.coreTest

import cyh.labCalculator.core.graph.MeasuredQuantity
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner

@RunWith(BlockJUnit4ClassRunner::class)
class CoreTest{
	
	@Test
	fun testMeasuredQuantity(){
		val measuredQuantity = MeasuredQuantity().apply {
			measuredValues.addAll(arrayListOf(5.5, 4.3, 5.3, 5.2))
			measureResolution =0.1
		}

		
		
		println("average:${measuredQuantity.value}")
		println("count:${measuredQuantity.valueCount}")
		println("uncertaintyA:${measuredQuantity.uncertaintyA}")
		println("uncertaintyB:${measuredQuantity.uncertaintyB}")
		println("uncertainty:${measuredQuantity.uncertainty}")
		
	}
}
