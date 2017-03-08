package cyh.labCalculator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity(), View.OnClickListener {
	private var output: EditText? = null
	private var input: EditText? = null
	private var btn1: Button? = null
	private var btn2: Button? = null
	private var btn3: Button? = null
	private var btn4: Button? = null
	private var btn5: Button? = null
	private var btn6: Button? = null
	private var btn7: Button? = null
	private var btn8: Button? = null
	private var btn9: Button? = null
	private var btnf: Button? = null
	private var btnm0: Button? = null
	private var btnl0: Button? = null
	private var btnDm: Button? = null
	private var btnDl0: Button? = null
	private var btnDx: Button? = null
	private var btnDy: Button? = null
	
	private var str = ""
	private var f: Double = 0.toDouble()
	private var p: Double = 0.toDouble()
	private var m0: Double = 0.toDouble()
	private var l0: Double = 0.toDouble()
	private var Dm: Double = 0.toDouble()
	private var Dl0: Double = 0.toDouble()
	private var Dx: Double = 0.toDouble()
	private var Dy: Double = 0.toDouble()
	private var Uf: Double = 0.toDouble()
	private var Up: Double = 0.toDouble()
	private var Um0: Double = 0.toDouble()
	private var Ul0: Double = 0.toDouble()
	private var Ub: Double = 0.toDouble()
	
	public override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		output = findViewById(R.id.output) as EditText
		output!!.setText("请输入f,m0,l0,Dm,Dl0,Dx,Dy的值")
		
		input = findViewById(R.id.input) as EditText
		input!!.setText(str)
		
		
		val btn0 = findViewById(R.id.zero) as Button
		btn1 = findViewById(R.id.one) as Button
		btn2 = findViewById(R.id.two) as Button
		btn3 = findViewById(R.id.three) as Button
		btn4 = findViewById(R.id.four) as Button
		btn5 = findViewById(R.id.five) as Button
		btn6 = findViewById(R.id.six) as Button
		btn7 = findViewById(R.id.seven) as Button
		btn8 = findViewById(R.id.eight) as Button
		btn9 = findViewById(R.id.nine) as Button
		
		btnf = findViewById(R.id.f) as Button
		btnm0 = findViewById(R.id.m0) as Button
		btnl0 = findViewById(R.id.l0) as Button
		btnDm = findViewById(R.id.Dm) as Button
		btnDl0 = findViewById(R.id.Dl0) as Button
		btnDx = findViewById(R.id.Dx) as Button
		btnDy = findViewById(R.id.Dy) as Button
		
		btn0.setOnClickListener(this)
		btn1!!.setOnClickListener(this)
		btn2!!.setOnClickListener(this)
		btn3!!.setOnClickListener(this)
		btn4!!.setOnClickListener(this)
		btn5!!.setOnClickListener(this)
		btn6!!.setOnClickListener(this)
		btn7!!.setOnClickListener(this)
		btn8!!.setOnClickListener(this)
		btn9!!.setOnClickListener(this)
		btnf!!.setOnClickListener(this)
		btnm0!!.setOnClickListener(this)
		btnl0!!.setOnClickListener(this)
		btnDm!!.setOnClickListener(this)
		btnDl0!!.setOnClickListener(this)
		btnDx!!.setOnClickListener(this)
		btnDy!!.setOnClickListener(this)
	}
	
	override fun onClick(view: View) {
		when (view.id) {
			R.id.zero -> num(0)
			R.id.one -> num(1)
			R.id.two -> num(2)
			R.id.three -> num(3)
			R.id.four -> num(4)
			R.id.five -> num(5)
			R.id.six -> num(6)
			R.id.seven -> num(7)
			R.id.eight -> num(8)
			R.id.nine -> num(9)
			R.id.point -> addPoint()
			R.id.f -> {
				f = java.lang.Double.parseDouble(str)
				str = ""
			}
			R.id.m0 -> {
				m0 = java.lang.Double.parseDouble(str)
				str = ""
			}
			R.id.l0 -> {
				l0 = java.lang.Double.parseDouble(str)
				str = ""
			}
			R.id.Dm -> {
				Dm = java.lang.Double.parseDouble(str)
				str = ""
			}
			R.id.Dl0 -> {
				Dl0 = java.lang.Double.parseDouble(str)
				str = ""
			}
			R.id.Dx -> {
				Dx = java.lang.Double.parseDouble(str)
				str = ""
			}
			R.id.Dy -> {
				Dy = java.lang.Double.parseDouble(str)
				str = ""
			}
		}
		if (f * m0 * l0 * Dm * Dl0 * Dx * Dy != 0.0) {
			uncertaintyCount()
			output!!.setText("Uf:$Uf Up:$Up Ub:$Ub ")
		}
	}
	
	
	fun uncertaintyCount() {
		Ub = Math.sqrt(Math.pow(Dx, 2.0) / 12 + Math.pow(Dy, 2.0) / 3)
		p = m0 / l0
		Um0 = Dm / Math.sqrt(3.0)
		Ul0 = Dl0 / Math.sqrt(3.0)
		Up = Math.sqrt(Math.pow(Um0 / m0, 2.0) + Math.pow(Ul0 / l0, 2.0)) * p
		Uf = Math.sqrt(Math.pow(Ub, 2.0) + Math.pow(Up / p, 2.0) / 4) * f
	}
	
	fun num(n: Int) {
		str = str + n.toString()
		input!!.setText(str)
	}
	
	fun addPoint() {
		str = str + "."
		input!!.setText(str)
	}
}
