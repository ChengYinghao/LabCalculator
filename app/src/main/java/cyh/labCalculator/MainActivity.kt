package cyh.labCalculator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : Activity(), View.OnClickListener {
	private val output by lazy { findViewById(R.id.et_output) as EditText }
	private val input by lazy { findViewById(R.id.et_input) as EditText }
	private val button0 by lazy { findViewById(R.id.b_zero) as Button }
	private val button1 by lazy { findViewById(R.id.b_one) as Button }
	private val button2 by lazy { findViewById(R.id.b_two) as Button }
	private val button3 by lazy { findViewById(R.id.b_three) as Button }
	private val button4 by lazy { findViewById(R.id.b_four) as Button }
	private val button5 by lazy { findViewById(R.id.b_five) as Button }
	private val button6 by lazy { findViewById(R.id.b_six) as Button }
	private val button7 by lazy { findViewById(R.id.b_seven) as Button }
	private val button8 by lazy { findViewById(R.id.b_eight) as Button }
	private val button9 by lazy { findViewById(R.id.b_nine) as Button }
	private val buttonF by lazy { findViewById(R.id.b_f) as Button }
	private val buttonM0 by lazy { findViewById(R.id.b_m0) as Button }
	private val buttonL0 by lazy { findViewById(R.id.b_l0) as Button }
	private val buttonDm by lazy { findViewById(R.id.b_Dm) as Button }
	private val buttonDL0 by lazy { findViewById(R.id.b_Dl0) as Button }
	private val buttonDx by lazy { findViewById(R.id.b_Dx) as Button }
	private val buttonDy by lazy { findViewById(R.id.b_Dy) as Button }
	private val buttonPoint by lazy { findViewById(R.id.point) as Button }

	private var str = ""
	private var f: Double = 0.0
	private var p: Double = 0.0
	private var m0: Double = 0.0
	private var l0: Double = 0.0
	private var Dm: Double = 0.0
	private var Dl0: Double = 0.0
	private var Dx: Double = 0.0
	private var Dy: Double = 0.0
	private var Uf: Double = 0.0
	private var Up: Double = 0.0
	private var Um0: Double = 0.0
	private var Ul0: Double = 0.0
	private var Ub: Double = 0.0

	public override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		output.setText("请输入f,m0,l0,Dm,Dl0,Dx,Dy的值")

		input.setText(str)

		button0.setOnClickListener(this)
		button1.setOnClickListener(this)
		button2.setOnClickListener(this)
		button3.setOnClickListener(this)
		button4.setOnClickListener(this)
		button5.setOnClickListener(this)
		button6.setOnClickListener(this)
		button7.setOnClickListener(this)
		button8.setOnClickListener(this)
		button9.setOnClickListener(this)
		buttonF.setOnClickListener(this)
		buttonM0.setOnClickListener(this)
		buttonL0.setOnClickListener(this)
		buttonDm.setOnClickListener(this)
		buttonDL0.setOnClickListener(this)
		buttonDx.setOnClickListener(this)
		buttonDy.setOnClickListener(this)
		buttonPoint.setOnClickListener(this)

	}
		override fun onClick(view: View) {

			when (view.id) {
				R.id.b_zero -> num(0)
				R.id.b_one -> num(1)
				R.id.b_two -> num(2)
				R.id.b_three -> num(3)
				R.id.b_four -> num(4)
				R.id.b_five -> num(5)
				R.id.b_six -> num(6)
				R.id.b_seven -> num(7)
				R.id.b_eight -> num(8)
				R.id.b_nine -> num(9)
				R.id.point -> addPoint()
				R.id.b_f -> {
					f = java.lang.Double.parseDouble(str)
					str = ""
					check()
				}
				R.id.b_m0 -> {
					m0 = java.lang.Double.parseDouble(str)
					str = ""
					check()
				}
				R.id.b_l0 -> {
					l0 = java.lang.Double.parseDouble(str)
					str = ""
					check()
				}
				R.id.b_Dm -> {
					Dm = java.lang.Double.parseDouble(str)
					str = ""
					check()
				}
				R.id.b_Dl0 -> {
					Dl0 = java.lang.Double.parseDouble(str)
					str = ""
					check()
				}
				R.id.b_Dx -> {
					Dx = java.lang.Double.parseDouble(str)
					str = ""
					check()
				}
				R.id.b_Dy -> {
					Dy = java.lang.Double.parseDouble(str)
					str = ""
					check()
				}
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
			str += n.toString()
			input.setText(str)
		}

		fun addPoint() {
			str += "."
			input.setText(str)
		}
	fun check(){
		if(f * m0 * l0 * Dx * Dy * Dl0 * Dm != 0.0){
			uncertaintyCount()
			output.setText( "Uf=$Uf \n Ub=$Ub \n Up=$Up")
		}
	}
}

