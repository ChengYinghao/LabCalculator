package cyh.labCalculator.core.graph

class MeasuredQuantity : Quantity {
	
	//数据部分
	val measuredValues:MutableList<Double> = ArrayList<Double>()
	
	val valueCount: Int get() = measuredValues.size
	
	val average:Double
		get() = measuredValues.average()
	override val value: Double
		get() = average
	
	val uncertainty: Double
		get() {
			val uA = uncertaintyA
			val uB = uncertaintyB
			return Math.sqrt(uA * uA + uB * uB)
		}
	
	val uncertaintyA: Double
		get() {
			if (valueCount > 1) {
				val average = value
				return Math.sqrt(measuredValues.sumByDouble { (it - average) * (it - average) } / (valueCount - 1) / valueCount)
			} else {
				return 0.0
			}
		}
	
	var uncertaintyB: Double = 0.0
	var measureResolution: Double
		get() = uncertaintyB * Math.sqrt(3.0)
		set(value) {
			uncertaintyB = value / Math.sqrt(3.0)
		}
	
	
}
