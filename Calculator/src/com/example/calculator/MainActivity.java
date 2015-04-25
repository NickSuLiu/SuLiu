package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private double num = -1;
	private EditText edit;
	private String flag = "";
	boolean grow = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edit = (EditText) findViewById(R.id.edit);
	}

	public void clickHandler(View source) {
		switch (source.getId()) {
		case R.id.zero:
			changeText("0");
			grow = true;
			break;
		case R.id.one:
			changeText("1");
			grow = true;
			break;
		case R.id.two:
			changeText("2");
			grow = true;
			break;
		case R.id.three:
			changeText("3");
			grow = true;
			break;
		case R.id.four:
			changeText("4");
			grow = true;
			break;
		case R.id.five:
			changeText("5");
			grow = true;
			break;
		case R.id.six:
			changeText("6");
			grow = true;
			break;
		case R.id.seven:
			changeText("7");
			grow = true;
			break;
		case R.id.eight:
			changeText("8");
			grow = true;
			break;
		case R.id.nine:
			changeText("9");
			grow = true;
			break;
		case R.id.plot:
			changeText(".");
			grow = true;
			break;
		case R.id.multiply:
			grow = false;
			num = Double.parseDouble(edit.getText().toString());
			flag = "multiply";
			break;
		case R.id.divide:
			grow = false;
			num = Double.parseDouble(edit.getText().toString());
			flag = "divide";
			break;
		case R.id.plus:
			num = Double.parseDouble(edit.getText().toString());
			grow = false;
			flag = "plus";
			break;
		case R.id.minus:
			num = Double.parseDouble(edit.getText().toString());
			grow = false;
			flag = "minus";
			break;
		case R.id.equal:
			edit.setText(CalculatorBrain(num,
					Double.parseDouble(edit.getText().toString()), flag));
			grow = false;
			break;
		case R.id.clear:
			grow = false;
			edit.setText("0");
			num = -1;
			break;
		default:
			break;
		}
	}

	public void changeText(String m) {
		String current = edit.getText().toString();
		if (!grow)
			edit.setText(m);
		else
			edit.setText(current + m);
	}

	public String CalculatorBrain(double m, double n, String flag) {
		String ret = "";
		if (flag.equals("multiply")) {
			ret = Double.toString(m * n);
		} else if (flag.equals("divide")) {
			if (n == 0)
				return "error";
			ret = Double.toString(m / n);
		} else if (flag.equals("plus")) {
			ret = Double.toString(m + n);
		} else if (flag.equals("minus")) {
			ret = Double.toString(m - n);
		}
		return ret;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
