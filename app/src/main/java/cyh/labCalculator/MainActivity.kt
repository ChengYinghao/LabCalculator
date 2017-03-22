package cyh.labCalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val btnLab1 by lazy { findViewById(R.id.lab1) as Button }
    private val btnLab2 by lazy { findViewById(R.id.lab2) as Button }
    private val btnlab3 by lazy { findViewById(R.id.lab3) as Button }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLab1.setOnClickListener(this)
        btnLab2.setOnClickListener(this)
        btnlab3.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.lab1-> {
                val intent1: Intent = Intent(this, FirstActivity::class.java)
                startActivity(intent1)
            }
            R.id.lab2->{
                val intent2:Intent=Intent(this,SecondActivity::class.java)
                startActivity(intent2)
            }
            R.id.lab3->{
                val intent3:Intent=Intent(this,ThirdActivity::class.java)
                startActivity(intent3)
            }
        }
    }
}
