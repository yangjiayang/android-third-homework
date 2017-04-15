package andy.ham;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;

public class DialogAlert extends Activity {

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Builder dialog = new AlertDialog.Builder(DialogAlert.this);
		dialog.setIcon(android.R.drawable.btn_star_big_on);
		//设置图标
		dialog.setTitle("welcome");// 标题可写在strings里面
		dialog.setMessage("欢迎使用本程序");//对话框显示的内容
		dialog.setPositiveButton("确定", new OnClickListener() {
			public void onClick(DialogInterface a0, int a1) {
				// 确定完成的事情
			}
		});
		dialog.setNegativeButton("取消", new OnClickListener() {
			public void onClick(DialogInterface a0, int a1) {
				// 确定否定的事情，DialogInterface a0,是设置这个dialog的id为a0。
				TextView tv =(TextView) findViewById(R.id.textview);
				tv.setText("已取消：cancel！");
			}
		});
		dialog.create();
		dialog.show();
	}
}
