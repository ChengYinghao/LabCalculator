package cyh.labCalculator.core

import cyh.labCalculator.core.abstracts.LabObject

class LinearRegression : LabObject {
	
	val points = ArrayList<LabPoint>()
	
	val k: Double
		get() {
			TODO()
		}
	
	val b: Double
		get() {
			TODO()
		}
	
}

data class LabPoint(val x: Double, val y: Double)