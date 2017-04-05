package cyh.labCalculator.universal

import android.animation.LayoutTransition
import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.LinearLayout
import cyh.labCalculator.R

class UniversalActivity : AppCompatActivity() {
	val ll_items: LinearLayout by lazy { findViewById(R.id.ll_items) as LinearLayout }
	val b_new: FloatingActionButton by lazy{ findViewById(R.id.fab) as FloatingActionButton }
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_universal)
		setSupportActionBar(findViewById(R.id.toolbar) as Toolbar)
		
		ll_items.layoutTransition = LayoutTransition().apply {
			this.enableTransitionType(LayoutTransition.CHANGING)
		}
		
		b_new.setOnClickListener { addNewItem() }
		
		addNewItem()
	}
	
	@SuppressLint("SetTextI18n")
	fun addNewItem() {
		val item = MeasuredQuantityView(this)
		item.et_name.setText("Quantity_${ll_items.childCount}")
		ll_items.addView(item, 0)
	}
	
}
