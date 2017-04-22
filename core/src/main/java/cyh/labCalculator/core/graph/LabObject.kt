package cyh.labCalculator.core.graph



interface LabObject{
	val name:String? get() = null
}

interface LabDict: LabObject,Map<String, LabObject>
