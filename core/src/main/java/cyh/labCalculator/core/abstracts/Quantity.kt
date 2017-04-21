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
	val derivative:Quantity
}



/**
 * 常量
 * 其取值不变
 */
data class ConstantQuantity(override val value:Double):ElementQuantity,DerivableQuantity{
	override val derivative get() = ConstantQuantity.ZERO
	companion object{
		@JvmStatic val ZERO =ConstantQuantity(0.0)
	}
}


/**
 * 占位符量
 * 在计算时才需要确定取值，可以指定其取值的常量
 */
data class PlaceholderQuantity(override var value: Double):ElementQuantity,DerivableQuantity{
	override val derivative get() =ConstantQuantity.ZERO
}




class SumQuantity:RelatedQuantity,DerivableQuantity{
	override val value: Double
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
	override val derivative: Quantity
		get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
	
}
