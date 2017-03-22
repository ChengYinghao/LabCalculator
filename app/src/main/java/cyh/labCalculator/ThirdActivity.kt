package cyh.labCalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ThirdActivity : AppCompatActivity() ,View.OnClickListener{
    private val output by lazy{findViewById(R.id.et_output) as TextView }
    private val inputM by lazy { findViewById(R.id.M_input) as EditText }
    private val inputt2 by lazy { findViewById(R.id.t2_input) as EditText }
    private val inputt1 by lazy { findViewById(R.id.t1_input) as EditText }
    private val inputδt by lazy { findViewById(R.id.δt_input) as EditText }
    private val inputδM by lazy { findViewById(R.id.δM_input) as EditText }
    private val inputM1 by lazy { findViewById(R.id.M1_input) as EditText }
    private val inputM2 by lazy { findViewById(R.id.M2_input) as EditText }
    private val btnOK by lazy { findViewById(R.id.ok) as Button }

    private var M:LabVariable= LabVariable()
    private var t2:LabVariable= LabVariable()
    private var t1:LabVariable= LabVariable()
    private var M1:LabVariable= LabVariable()
    private var M2:LabVariable= LabVariable()
    private var ListM:ArrayList<Double> = ArrayList()
    private var δt:Double=0.0
    private var δM:Double=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        output.text="请输入各参数值"
        btnOK.setOnClickListener(this)
    }
    override fun onClick(view:View){
        when(view.id){
            R.id.ok->calculate()
        }
    }
    fun calculateUa(arrayList:ArrayList<Double>):Double{
        var average:Double=0.0
        val sum:Double= (0..arrayList.size-1).sumByDouble { arrayList[it] }
        average=sum/arrayList.size
        val squareSum:Double= (0..arrayList.size-1).sumByDouble { Math.pow(arrayList[it]-average,2.0) }
        val ua:Double=Math.sqrt(squareSum/arrayList.size/(arrayList.size-1))
        return ua
    }
    fun calculate(){
        val listStringM= inputM.text.toString().split(" ")
        for(i in 0 until listStringM.size){
            ListM.add(listStringM[i].toDouble())
        }
        val sum1:Double= (0 until ListM.size).sumByDouble { ListM[it] }
        M.value=sum1/ListM.size
        M.ua=calculateUa(ListM)
    }
}

