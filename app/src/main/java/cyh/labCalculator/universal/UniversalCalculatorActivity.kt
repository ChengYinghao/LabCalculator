package cyh.labCalculator.universal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.LinearLayout
import cyh.labCalculator.R

class UniversalCalculatorActivity : AppCompatActivity() {
	
	val ll_vars:LinearLayout by lazy { findViewById(R.id.ll_items) as LinearLayout }
	val b_newVar: Button by lazy{ findViewById(R.id.b_newItem) as Button}
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_universal_calculator)
		
		
	}
}
