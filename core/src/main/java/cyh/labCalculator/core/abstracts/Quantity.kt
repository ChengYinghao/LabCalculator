package cyh.labCalculator.core.abstracts

/**
 * 某个量
 */
interface Quantity : LabObject {
	val value:Double
}

/**
 * 独立量
 * 其取值与其余任何量独立
 */
interface ElementQuantity :Quantity
/**
 * 关联量
 * 其取值由其余量算出
 */
interface RelatedQuantity:Quantity

/**
 * 可导变量
 * 可以对该量关于某个独立量求导
 */
interface DerivableQuantity{
	fun derivative(target: PlaceholderQuantity): Quantity
}





/**
 * 常量
 * 其取值不变
 */
data class ConstantQuantity(override val value: Double) : ElementQuantity, DerivableQuantity {
	override fun derivative(target: PlaceholderQuantity)= ZERO
}
val ZERO = ConstantQuantity(0.0)
val ONE = ConstantQuantity(1.0)
val MINUS = ConstantQuantity(-1.0)
val NAN = ConstantQuantity(Double.NaN)

/**
 * 占位符量
 * 在计算时才需要确定取值，可以指定其取值的常量
 */
data class PlaceholderQuantity(override var value: Double):ElementQuantity,DerivableQuantity{
	override fun derivative(target: PlaceholderQuantity) = if(this==target) ONE else ZERO
}


class SumQuantity(items: Collection<Quantity>):RelatedQuantity,DerivableQuantity{
	val items:List<Quantity> =ArrayList<Quantity>().apply { addAll(items) }
	val size:Int get() = items.size
	
	constructor(vararg items:Quantity):this(items.asList())
	
	
	override val value: Double get() = items.sumByDouble { it.value }
	override fun derivative(target: PlaceholderQuantity): SumQuantity {
		var sum = SumQuantity()
		items.forEach { item ->
			sum += (item as? DerivableQuantity)?.derivative(target) ?: NAN
		}
		return sum
	}
}


class ProductQuantity:RelatedQuantity,DerivableQuantity{
	override fun derivative(target: PlaceholderQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
	
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
	
}
class DivisionQuantity:RelatedQuantity,DerivableQuantity{
	override fun derivative(target: PlaceholderQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
	
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}

class IntegerPowerQuantity:RelatedQuantity,DerivableQuantity{
	override fun derivative(target: PlaceholderQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
	
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}
class RealPowerQuantity:RelatedQuantity,DerivableQuantity{
	override fun derivative(target: PlaceholderQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
	
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}
class RelatedPowerQuantity:RelatedQuantity,DerivableQuantity{
	override fun derivative(target: PlaceholderQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}


operator fun Quantity.plus(quantity: Quantity) = SumQuantity(this, quantity)
operator fun SumQuantity.plus(quantity: Quantity): SumQuantity {
	val items=ArrayList<Quantity>(this.size+1)
	items.addAll(this.items)
	items.add(quantity)
	return SumQuantity(items)
}
operator fun Quantity.plus(quantity: SumQuantity) = quantity.plus(this)
operator fun SumQuantity.plus(quantity: SumQuantity):SumQuantity{
	val items=ArrayList<Quantity>(this.size+quantity.size)
	items.addAll(this.items)
	items.addAll(quantity.items)
	return SumQuantity(items)
}
