package cyh.labCalculator.special

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import cyh.labCalculator.R

class ThirdActivity : AppCompatActivity() , View.OnClickListener {
    private val output by lazy{findViewById(R.id.et_output) as TextView }
    private val inputM by lazy { findViewById(R.id.M_input) as EditText }
    private val inputt2 by lazy { findViewById(R.id.t2_input) as EditText }
    private val inputt1 by lazy { findViewById(R.id.t1_input) as EditText }
    private val inputδt by lazy { findViewById(R.id.δt_input) as EditText }
    private val inputδM by lazy { findViewById(R.id.δM_input) as EditText }
    private val inputM1 by lazy { findViewById(R.id.M1_input) as EditText }
    private val inputM2 by lazy { findViewById(R.id.M2_input) as EditText }
    private val btnOK by lazy { findViewById(R.id.ok) as Button }

    private var M: LabVariable = LabVariable()
    private var t2: LabVariable = LabVariable()
    private var t1: LabVariable = LabVariable()
    private var M1: LabVariable = LabVariable()
    private var M2: LabVariable = LabVariable()
    private var ListM:ArrayList<Double> = ArrayList()
    private var δt:Double=0.0
    private var δM:Double=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        output.text="请输入各参数值"
        btnOK.setOnClickListener(this)
    }
    override fun onClick(view: View){
        when(view.id){
            R.id.ok->calculate()
        }
    }
    fun calculateUa(arrayList:ArrayList<Double>):Double{
        val sum:Double= (0..arrayList.size-1).sumByDouble { arrayList[it] }
        val average=sum/arrayList.size
        val squareSum:Double= (0..arrayList.size-1).sumByDouble { Math.pow(arrayList[it]-average,2.0) }
        val ua:Double=Math.sqrt(squareSum/arrayList.size/(arrayList.size-1))
        return ua
    }
    fun calculate(){
        t2.value=inputt2.text.toString().toDouble()
        t1.value=inputt1.text.toString().toDouble()
        δt=inputδt.text.toString().toDouble()
        M2.value=inputM2.text.toString().toDouble()
        M1.value=inputM1.text.toString().toDouble()
        δM=inputδM.text.toString().toDouble()
        val listStringM= inputM.text.toString().split(" ")
        for(i in 0 until listStringM.size){
            ListM.add(listStringM[i].toDouble())
        }
        val sum1:Double= (0 until ListM.size).sumByDouble { ListM[it] }
        M.value=sum1/ListM.size
        M.ua=calculateUa(ListM)
        M.ub=δM/Math.sqrt(3.0)
        M.u=Math.sqrt(Math.pow(M.ua,2.0)+Math.pow(M.ub,2.0))
        M2.ub=δM/Math.sqrt(3.0)
        M2.u=M2.ub
        M1.u=M2.u
        t1.u=δt/Math.sqrt(3.0)
        t2.u=t1.u
        val u1=Math.sqrt(Math.pow(M1.u,2.0)+Math.pow(M2.u,2.0))
        val u2=Math.sqrt(Math.pow(M.u,2.0)+Math.pow(M2.u,2.0))
        val u3:Double=Math.sqrt(Math.pow(t1.u,2.0)+Math.pow(t2.u,2.0))
        val u4:Double=Math.sqrt(Math.pow(u2/(M-M2),2.0)+Math.pow(u3/(t2-t1),2.0))
        val u5:Double=Math.sqrt(Math.pow(u1/(M2-M1),2.0)+Math.pow(u4,2.0))*(M2-M1)/(M-M2)/(t2-t1)
        output.text="Um:$M.u U:$u5"
    }
}

