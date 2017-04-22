package cyh.labCalculator.universal

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import cyh.labCalculator.R
import cyh.labCalculator.core.graph.MeasuredQuantity

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
				stringBuilder.appendln(resources.getString(R.string.measurement_of,name))
			}
			stringBuilder.appendln(resources.getString(R.string.count)+"=$valueCount")
			if (measuredValues.count() != 0) {
				stringBuilder.appendln(resources.getString(R.string.average)+"=$average")
				stringBuilder.appendln(resources.getString(R.string.uncertainty)+"=$uncertainty")
				stringBuilder.appendln(resources.getString(R.string.less_useful_info))
				stringBuilder.appendln(resources.getString(R.string.uncertaintyA)+"=$uncertaintyA")
				stringBuilder.appendln(resources.getString(R.string.uncertaintyB)+"=$uncertaintyB")
			}
			stringBuilder.append(resources.getString(R.string.nothing_more))
			
			tv_valuesInfo.text = stringBuilder.toString()
			tv_valuesInfo.visibility=View.VISIBLE
		}
		
	}
	
	
	
}

