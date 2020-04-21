package cn.org.bjca.convertiblebond;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText guJia, peiShouE, shiZhi, dieFu, dieLiang, gushu;
    private RadioButton rb_huShi, rb_shenShi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guJia = findViewById(R.id.et_gujia);
        peiShouE = findViewById(R.id.et_peishoue);
        shiZhi = findViewById(R.id.et_shizhi);
        dieFu = findViewById(R.id.et_diefu);
        dieLiang = findViewById(R.id.et_dieliang);
        rb_huShi = findViewById(R.id.rb_hu);
        rb_shenShi = findViewById(R.id.rb_shen);
        gushu = findViewById(R.id.et_gushu);
    }

    public void calculator(View view) {
        double mPeiShouE;
        double mGuJia;
        double mShiZhi;
        double mDieFu;
        double mDieLiang;

        if (!TextUtils.isEmpty(peiShouE.getText()) && !TextUtils.isEmpty(guJia.getText())) {
            mPeiShouE = Double.parseDouble(peiShouE.getText().toString().trim());
            mGuJia = Double.parseDouble(guJia.getText().toString().trim());
            double aboutGuNumber = 0;
            if (rb_huShi.isChecked()) {
                aboutGuNumber = 500.00 / mPeiShouE;
            } else if (rb_shenShi.isChecked()) {
                aboutGuNumber = 1000.00 / mPeiShouE;
            } else {
                Toast.makeText(this, "请选择股票市场", Toast.LENGTH_SHORT).show();
            }

            double guNumber = Math.ceil(aboutGuNumber / 100) * 100;
            mShiZhi = guNumber * mGuJia;
            gushu.setText(String.format("%.0f", guNumber));
            shiZhi.setText(String.format("%.2f", mShiZhi));
            if (!TextUtils.isEmpty(dieFu.getText())) {
                mDieFu = Double.parseDouble(dieFu.getText().toString().trim()) / 100;
                mDieLiang = mShiZhi * mDieFu;
                dieLiang.setText(String.format("%.2f", mDieLiang));
            }

        } else {
            Toast.makeText(this, "请输入股价和每股配售额", Toast.LENGTH_SHORT).show();
        }
    }

    public void clear(View view) {
        guJia.setText("");
        peiShouE.setText("");
        shiZhi.setText("");
        dieFu.setText("");
        gushu.setText("");
        dieLiang.setText("");
    }
}
