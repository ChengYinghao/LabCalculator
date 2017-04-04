package cyh.labCalculator.universal

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import cyh.labCalculator.R

class UniversalCalculatorActivity : AppCompatActivity() {
	
	val ll_items:LinearLayout by lazy { findViewById(R.id.ll_items) as LinearLayout }
	val b_new: Button by lazy{ findViewById(R.id.b_newItem) as Button}
	
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_universal_calculator)
		
		b_new.setOnClickListener @SuppressLint("SetTextI18n"){
			val item=MeasuredQuantityView(this)
			item.et_name.setText("Quantity_${(ll_items.childCount - 1)}")
			ll_items.addView(item,ll_items.childCount-1)
		}
		
		b_new.performClick()
		
	}
}
