package cyh.labCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {
	private EditText output;
	private EditText input;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	private Button btnf;
	private Button btnm0;
	private Button btnl0;
	private Button btnDm;
	private Button btnDl0;
	private Button btnDx;
	private Button btnDy;
	
	private String str = "";
	private double f;
	private double p;
	private double m0;
	private double l0;
	private double Dm;
	private double Dl0;
	private double Dx;
	private double Dy;
	private double Uf;
	private double Up;
	private double Um0;
	private double Ul0;
	private double Ub;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		output = (EditText) findViewById(R.id.output);
		output.setText("请输入f,m0,l0,Dm,Dl0,Dx,Dy的值");
		
		input = (EditText) findViewById(R.id.input);
		input.setText(str);







































































































































































































		Button btn0 = (Button) findViewById(R.id.zero);
		btn1 = (Button) findViewById(R.id.one);
		btn2 = (Button) findViewById(R.id.two);
		btn3 = (Button) findViewById(R.id.three);
		btn4 = (Button) findViewById(R.id.four);
		btn5 = (Button) findViewById(R.id.five);
		btn6 = (Button) findViewById(R.id.six);
		btn7 = (Button) findViewById(R.id.seven);
		btn8 = (Button) findViewById(R.id.eight);
		btn9 = (Button) findViewById(R.id.nine);
		
		btnf = (Button) findViewById(R.id.f);
		btnm0 = (Button) findViewById(R.id.m0);
		btnl0 = (Button) findViewById(R.id.l0);
		btnDm = (Button) findViewById(R.id.Dm);
		btnDl0 = (Button) findViewById(R.id.Dl0);
		btnDx = (Button) findViewById(R.id.Dx);
		btnDy = (Button) findViewById(R.id.Dy);
		
		btn0.setOnClickListener(this);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);
		btn3.setOnClickListener(this);
		btn4.setOnClickListener(this);
		btn5.setOnClickListener(this);
		btn6.setOnClickListener(this);
		btn7.setOnClickListener(this);
		btn8.setOnClickListener(this);
		btn9.setOnClickListener(this);
		btnf.setOnClickListener(this);
		btnm0.setOnClickListener(this);
		btnl0.setOnClickListener(this);
		btnDm.setOnClickListener(this);
		btnDl0.setOnClickListener(this);
		btnDx.setOnClickListener(this);
		btnDy.setOnClickListener(this);
	}
	
	public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zero:
                num(0);
                break;
            case R.id.one:
                num(1);
                break;
            case R.id.two:
                num(2);
                break;
            case R.id.three:
                num(3);
                break;
            case R.id.four:
                num(4);
                break;
            case R.id.five:
                num(5);
                break;
            case R.id.six:
                num(6);
                break;
            case R.id.seven:
                num(7);
                break;
            case R.id.eight:
                num(8);
                break;
            case R.id.nine:
                num(9);
                break;
            case R.id.point:
                addPoint();
                break;
            case R.id.f:
                f = Double.parseDouble(str);
                str = "";
                break;
            case R.id.m0:
                m0 = Double.parseDouble(str);
                str = "";
                break;
            case R.id.l0:
                l0 = Double.parseDouble(str);
                str = "";
                break;
            case R.id.Dm:
                Dm = Double.parseDouble(str);
                str = "";
                break;
            case R.id.Dl0:
                Dl0 = Double.parseDouble(str);
                str = "";
                break;
            case R.id.Dx:
                Dx = Double.parseDouble(str);
                str = "";
                break;
            case R.id.Dy:
                Dy = Double.parseDouble(str);
                str = "";
                break;
        }
        if (f * m0 * l0 * Dm * Dl0 * Dx * Dy != 0) {
            uncertaintyCount();
            output.setText("Uf:" + Uf + " " + "Up:" + Up + " " + "Ub:" + Ub + " ");
        }
    }
	
	
	public void uncertaintyCount() {
		Ub = Math.sqrt(Math.pow(Dx, 2) / 12 + Math.pow(Dy, 2) / 3);
		p = m0 / l0;
		Um0 = Dm / Math.sqrt(3);
		Ul0 = Dl0 / Math.sqrt(3);
		Up = Math.sqrt(Math.pow(Um0 / m0, 2) + Math.pow(Ul0 / l0, 2)) * p;
		Uf = Math.sqrt(Math.pow(Ub, 2) + Math.pow(Up / p, 2) / 4) * f;
	}
	
	public void num(int n) {
		str = str + String.valueOf(n);
		input.setText(str);
	}
	
	public void addPoint() {
		str = str + ".";
		input.setText(str);
	}
}
