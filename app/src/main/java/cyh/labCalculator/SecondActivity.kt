package cyh.labCalculator

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : Activity() , View.OnClickListener{
    private val output by lazy{findViewById(R.id.et_output) as TextView}
    private val inputD by lazy { findViewById(R.id.D_input) as EditText }
    private val inputR by lazy { findViewById(R.id.R_input) as EditText }
    private val inputL by lazy { findViewById(R.id.L_input) as EditText }
    private val inputY1 by lazy { findViewById(R.id.y1_input) as EditText }
    private val inputY2 by lazy { findViewById(R.id.y2_input) as EditText }
    private val inputX1 by lazy { findViewById(R.id.x1_input) as EditText }
    private val inputX2 by lazy { findViewById(R.id.x2_input) as EditText }
    private val inputδx by lazy { findViewById(R.id.δx_input) as EditText}
    private val inputδy by lazy { findViewById(R.id.δy_input) as EditText }
    private val btnOK by lazy { findViewById(R.id.ok) as Button }
    private val inputδD by lazy { findViewById(R.id.δD_input) as EditText }
    private val inputδR by lazy { findViewById(R.id.δR_input) as EditText }
    private val inputδL by lazy { findViewById(R.id.δL_input) as EditText }

    private var α:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var D:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var valueR:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var L:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var k:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var ListD:ArrayList<Double> = ArrayList()
    private var ListR:ArrayList<Double> = ArrayList()
    private var ListL:ArrayList<Double> = ArrayList()
    private var y1:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var y2:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var x1:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var x2:LabVariable= LabVariable(0.0,0.0,0.0,0.0)
    private var δx:Double=0.0
    private var δy:Double=0.0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        output.text = "请输入各参数值:"
        btnOK.setOnClickListener(this)
    }

    override fun onClick(view:View){
        when(view.id){
            R.id.ok->calculate()
        }
    }
    fun calculate(){
        val listStringD= inputD.text.toString().split(" ")
        for(i in 0 until listStringD.size){
            ListD.add(listStringD[i].toDouble())
        }
        val sum1:Double= (0 until ListD.size).sumByDouble { ListD[it] }
        D.value=sum1/ListD.size
        D.ua=calculateUa(ListD)
        D.ub=inputδD.text.toString().toDouble()/Math.sqrt(3.0)
        D.u=Math.sqrt(Math.pow(D.ua,2.0)+Math.pow(D.ub,2.0))

        val listStringR= inputR.text.toString().split(" ")
        for(i in 0 until listStringR.size){
            ListR.add(listStringR[i].toDouble())
        }
        val sum2:Double= (0 until ListR.size).sumByDouble { ListR[it] }
        valueR.value=sum2/ListR.size
        valueR.ua=calculateUa(ListR)
        valueR.ub=inputδR.text.toString().toDouble()/Math.sqrt(3.0)
        valueR.u=Math.sqrt(Math.pow(valueR.ua,2.0)+Math.pow(valueR.ub,2.0))

        val listStringL= inputL.text.toString().split(" ")
        for(i in 0 until listStringL.size){
            ListL.add(listStringL[i].toDouble())
        }
        val sum3:Double= (0 until ListL.size).sumByDouble { ListL[it] }
        L.value=sum3/ListL.size
        L.ua=calculateUa(ListL)
        L.ub=inputδL.text.toString().toDouble()/Math.sqrt(3.0)
        L.u=Math.sqrt(Math.pow(L.ua,2.0)+Math.pow(L.ub,2.0))

        x1.value=inputX1.text.toString().toDouble()
        x2.value=inputX2.text.toString().toDouble()
        y1.value=inputY1.text.toString().toDouble()
        y2.value=inputY2.text.toString().toDouble()
        δx=inputδx.text.toString().toDouble()
        δy=inputδy.text.toString().toDouble()
        k.value=(y2.value-y1.value)/(x2.value-x1.value)
        y1.u=δy/Math.sqrt(3.0)
        y2.u=δy/Math.sqrt(3.0)
        x1.u=δx/Math.sqrt(3.0)
        x2.u=δx/Math.sqrt(3.0)
        k.u=Math.sqrt(Math.pow(y2.u/(y2.value-y1.value),2.0)+Math.pow(y1.u/(y2.value-y1.value),2.0)+
                2*Math.pow(x2.u/(x2.value-x1.value),2.0))*k.value

        α.value=D.value*k.value/(2* valueR.value*L.value)
        α.u=Math.sqrt(Math.pow(D.u/D.value,2.0)+Math.pow(valueR.u/ valueR.value,2.0)+Math.pow(L.u/L.value,2.0)+Math.pow(k.u/k.value,2.0))*α.value

        output.text = "uα:${α.u} uD:${D.u} uR:${valueR.u} uL:${L.u} uk:${k.u}"

    }
    fun calculateUa(arrayList:ArrayList<Double>):Double{
        val sum:Double= (0..arrayList.size-1).sumByDouble { arrayList[it] }
        val average=sum/arrayList.size
        val squareSum:Double= (0..arrayList.size-1).sumByDouble { Math.pow(arrayList[it]-average,2.0) }
        val ua:Double=Math.sqrt(squareSum/arrayList.size/(arrayList.size-1))
        return ua
    }
}



class LabVariable(var value:Double=0.0,var ua:Double=0.0,var ub:Double=0.0,var u:Double=0.0){
    operator fun plus(other:LabVariable): Double {
        return this.value+other.value
    }
    operator fun minus(other: LabVariable):Double{
        return this.value-other.value
    }
}