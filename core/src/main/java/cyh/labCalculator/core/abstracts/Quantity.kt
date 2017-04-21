package cyh.labCalculator.core.abstracts

/**
 * 某个量
 */
interface Quantity : LabObject {
	val value: Double
}

/**
 * 独立量
 * 其取值与其余任何量独立
 */
interface ElementQuantity : Quantity

/**
 * 关联量
 * 其取值由其余量算出
 */
interface RelatedQuantity : Quantity

/**
 * 可导量
 * 可以对该量关于某个独立量求导
 */
interface DerivableQuantity {
	fun derivative(target: VariableQuantity): Quantity
}





/**
 * 元常量
 * 其取值不变
 */
data class ConstantQuantity(override val value: Double) : ElementQuantity, DerivableQuantity {
	override fun derivative(target: VariableQuantity) = ZERO
}

/**
 * 元变量
 * 在计算时才需要确定取值，可以指定其取值的常量
 */
data class VariableQuantity(override var value: Double) : ElementQuantity, DerivableQuantity {
	override fun derivative(target: VariableQuantity) = if (this == target) ONE else ZERO
}

/**
 * 加法运算
 */
class SumQuantity(items: Collection<Quantity>) : RelatedQuantity, DerivableQuantity {
	val items: List<Quantity> = ArrayList<Quantity>().apply { addAll(items) }
	val size: Int get() = items.size
	
	constructor(vararg items: Quantity) : this(items.asList())
	
	override val value: Double get() = items.sumByDouble { it.value }
	override fun derivative(target: VariableQuantity)
		= SumQuantity(items.map { item -> (item as? DerivableQuantity)?.derivative(target) ?: NAN })
}

/**
 * 乘法运算
 */
class ProductQuantity(items: Collection<Quantity>) : RelatedQuantity, DerivableQuantity {
	override fun derivative(target: VariableQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
	
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
	
}

/**
 * 整数幂运算
 */
class IntegerPowerQuantity(val base: Quantity, val exponent: Int = 1) : RelatedQuantity, DerivableQuantity {
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
	
	override fun derivative(target: VariableQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}

/**
 * 实数幂运算
 */
class RealPowerQuantity(val base: Quantity, val exponent: Double = 1.0) : RelatedQuantity, DerivableQuantity {
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
	
	override fun derivative(target: VariableQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}

/**
 * 任意幂运算
 */
class RelatedPowerQuantity(val base: Quantity, val exponent: Quantity = ONE) : RelatedQuantity, DerivableQuantity {
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
	
	override fun derivative(target: VariableQuantity): Quantity {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}



//常用的元常量
/**
 * 元常量 1
 */
val ZERO = ConstantQuantity(0.0)
/**
 * 元常量 0
 */
val ONE = ConstantQuantity(1.0)
/**
 * 元常量 -1
 */
val MINUS = ConstantQuantity(-1.0)
/**
 * 元常量 NaN （表示无意义）
 */
val NAN = ConstantQuantity(Double.NaN)




//常用的符号运算

operator fun Quantity.plus(quantity: Quantity) = SumQuantity(this, quantity)
operator fun SumQuantity.plus(quantity: Quantity): SumQuantity {
	val items = ArrayList<Quantity>(this.size + 1)
	items.addAll(this.items)
	items.add(quantity)
	return SumQuantity(items)
}

operator fun Quantity.plus(quantity: SumQuantity) = quantity.plus(this)
operator fun SumQuantity.plus(quantity: SumQuantity): SumQuantity {
	val items = ArrayList<Quantity>(this.size + quantity.size)
	items.addAll(this.items)
	items.addAll(quantity.items)
	return SumQuantity(items)
}
