package cyh.labCalculator.core

interface LabObject

interface LabQuantity:LabObject{
	val value:Double
}

interface UncertainQuantity:LabQuantity{
	val uncertainty:Double
}

