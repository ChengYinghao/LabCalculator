package cyh.labCalculator.core



interface LabObject{
	val name:String? get() = null
}

interface LabDict: LabObject,Map<String, LabObject>
