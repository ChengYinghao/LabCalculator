package cyh.labCalculator.universal

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import cyh.labCalculator.R
import cyh.labCalculator.core.MeasuredQuantity

class MeasuredQuantityView(context: Context)
	: ConstraintLayout(context) {
	
	val b_run by lazy { findViewById(R.id.b_run) as Button }
	val et_name by lazy { findViewById(R.id.et_name)as EditText }
	val et_uncertainty by lazy { findViewById(R.id.et_unsertainty) as EditText }
	val b_valuesSpan by lazy { findViewById(R.id.b_valuesSpan) as Button }
	val tv_valuesInfo by lazy { findViewById(R.id.tv_valuesInfo) as TextView }
	val lv_values by lazy { findViewById(R.id.lv_values) as ListView }
	
	val measuredQuantity = MeasuredQuantity()
	init {
		LayoutInflater.from(context).inflate(R.layout.cv_item_meansured_value,this)
		
		b_run.setOnClickListener {
			
		}
		
		b_valuesSpan.setOnClickListener {
			lv_values.visibility = when (lv_values.visibility) {
				View.VISIBLE -> View.GONE
				else -> View.VISIBLE
			}
		}
		
		
		lv_values.addFooterView(ValueItemView(context,1))
		lv_values.adapter=object : BaseAdapter() {
			override fun getItem(position: Int): Double = measuredQuantity.measuredValues[getItemId(position).toInt()]
			override fun getItemId(position: Int): Long = position.toLong()
			override fun getCount(): Int = measuredQuantity.valueCount
			
			override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
				val theView: ValueItemView = convertView as?ValueItemView ?:ValueItemView(context)
				theView.tv_index.text=position.toString()
				theView.et_value.setText(getItem(position).toString())
				return theView
			}
		}
	}
	
}

class ValueItemView(context: Context) : LinearLayout(context) {
	val tv_index:TextView
	val et_value:EditText
	
	init {
		LayoutInflater.from(context).inflate(R.layout.adapter_meansured_value,this)
		tv_index = findViewById(R.id.tv_index) as TextView
		et_value = findViewById(R.id.et_value) as EditText
	}
	constructor(context: Context, index: Int, content: String=""):this(context){
		tv_index.text = index.toString()
		et_value.setText(content)
	}
}

