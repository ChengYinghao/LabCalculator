package cyh.labCalculator.core.structed

import cyh.labCalculator.core.graph.LabObject

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