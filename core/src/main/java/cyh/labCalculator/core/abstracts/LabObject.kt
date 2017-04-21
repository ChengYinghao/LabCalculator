package cyh.labCalculator.core.abstracts

interface LabObject{
	val name:String? get() = null
}

interface LabDict{
	val dict:Map<String,LabObject>
}
