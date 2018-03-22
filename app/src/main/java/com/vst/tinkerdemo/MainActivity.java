package com.vst.tinkerdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.tinker.lib.library.TinkerLoadLibrary;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.vst.jnitest.JniTest;

/**
 * 深度学习
 * https://github.com/mari-linhares/mnist-android-tensorflow
 * <p>
 * https://bugly.qq.com/docs/
 * https://github.com/GitLqr/HotFixDemo
 * https://juejin.im/post/5a27bdaf6fb9a044fa19bcfc
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_show;
    private Button btn_fix;
    private Button btn_show2;
    private Button btn_unfix;
    private Button btn_hack;
    private Button btn_nohack;
    private Button btn_kill;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_show = (Button) findViewById(R.id.btn_show);
        btn_fix = (Button) findViewById(R.id.btn_fix);

        btn_show.setOnClickListener(this);
        btn_fix.setOnClickListener(this);
        btn_show2 = (Button) findViewById(R.id.btn_show2);
        btn_show2.setOnClickListener(this);
        btn_unfix = (Button) findViewById(R.id.btn_unfix);
        btn_unfix.setOnClickListener(this);
        btn_hack = (Button) findViewById(R.id.btn_hack);
        btn_hack.setOnClickListener(this);
        btn_nohack = (Button) findViewById(R.id.btn_nohack);
        btn_nohack.setOnClickListener(this);

        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/fix.apk";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                Person user = new Person(10,"tommmm",36);
                Toast.makeText(this, "name:" + user.getName() + " age:" + user.getAge(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_fix:

                TinkerInstaller.onReceiveUpgradePatch(this, path);
                break;
            case R.id.btn_show2:
                Toast.makeText(this, JniTest.sayHello(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_unfix:
                break;
            case R.id.btn_hack:
                String CPU_ABI = android.os.Build.CPU_ABI;
                // 将tinker library中的 CPU_ABI架构的so 注册到系统的library path中。
                TinkerLoadLibrary.installNavitveLibraryABI(this, CPU_ABI);
                break;
            case R.id.btn_nohack:
                String CPU_ABI2 = android.os.Build.CPU_ABI;
                TinkerLoadLibrary.loadLibraryFromTinker(getApplicationContext(), "lib/" + CPU_ABI2, "native-lib");
                break;
        }
    }
}
