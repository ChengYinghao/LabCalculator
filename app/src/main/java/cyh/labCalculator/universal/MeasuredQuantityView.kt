package cyh.labCalculator.universal

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import cyh.labCalculator.R
import cyh.labCalculator.core.MeasuredQuantity

class MeasuredQuantityView(context: Context)
	: ConstraintLayout(context) {
	
	val et_name by lazy { findViewById(R.id.et_name)as EditText }
	val et_resolution by lazy { findViewById(R.id.et_resolution) as EditText }
	val et_values by lazy { findViewById(R.id.et_values) as EditText }
	val b_run by lazy { findViewById(R.id.b_run) as Button }
	val tv_valuesInfo by lazy { findViewById(R.id.tv_valuesInfo) as TextView }
	
	init {
		LayoutInflater.from(context).inflate(R.layout.cv_item_meansured_quantity,this)
		b_run.setOnClickListener { run() }
	}
	
	val measuredQuantity = MeasuredQuantity()
	fun run(){
		measuredQuantity.run {
			measureResolution=et_resolution.text.toString().toDoubleOrNull()?:0.0
			
			measuredValues.clear()
			et_values.text.toString().split("\n"," ")
				.mapNotNullTo(measuredValues, String::toDoubleOrNull)
			
			
			val stringBuilder = StringBuilder()
			
			val name=et_name.text
			if(!name.isNullOrEmpty()) {
				stringBuilder.appendln("measurement of $name:")
			}
			stringBuilder.appendln("count=$valueCount")
			if (measuredValues.count() == 0) {
				stringBuilder.appendln("(nothing more...)")
			}else{
				stringBuilder.appendln("average=$average")
				stringBuilder.appendln("uncertainty=$uncertainty")
				stringBuilder.appendln("less useful info:")
				stringBuilder.appendln("uncertaintyA=$uncertaintyA")
				stringBuilder.append("uncertaintyB=$uncertaintyB")
			}
			
			tv_valuesInfo.text = stringBuilder.toString()
			tv_valuesInfo.visibility=View.VISIBLE
		}
		
	}
	
	
	
}

