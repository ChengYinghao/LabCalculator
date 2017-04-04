package cyh.labCalculator.core.abstracts

interface Quantity : LabObject {
	val value:Double
}
class ConstantQuantity(override val value:Double):Quantity


interface RelatedQuantity:Quantity{
	val arguments:MutableList<Quantity>
}
interface DerivableQuantity:RelatedQuantity{
	fun derivative(target: Quantity): Quantity
}