package cyh.labCalculator.core

class MeasuredQuantity(
	val measuredValues:ArrayList<Double> = ArrayList<Double>(),
	val uncertaintyB: Double = 0.0
):UncertainQuantity {
	
	val valueCount:Int get()=measuredValues.size
	
	override val value: Double
		get() = measuredValues.average()
	
	override val uncertainty: Double
		get() {
			val uA = uncertaintyA
			val uB = uncertaintyB
			return Math.sqrt(uA * uA + uB * uB)
		}
	
	val uncertaintyA: Double
		get() {
			if (valueCount > 1) {
				val average = value
				return Math.sqrt(measuredValues.sumByDouble { (it-average)*(it-average) }/(valueCount-1)/valueCount)
			}else{
				return 0.0
			}
		}
	
}
