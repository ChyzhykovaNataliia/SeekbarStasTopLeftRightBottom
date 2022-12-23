package com.alperez.seekbarstastopleftrightbottom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    Button btnLeft;
    Button btnRight;
    Button btnTop;
    Button btnBottom;
    View vChanged;
    SeekBar sbWeight;

    private int sideGravity;
    private int viewGravity;
    private int viewMargin;

    private void updateView() {
        int size = getResources().getDimensionPixelSize(R.dimen.test_view_size);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(size, size);

        lp.gravity = viewGravity;

        switch (sideGravity) {
            case Gravity.LEFT:
                lp.leftMargin = viewMargin;
                break;
            case Gravity.TOP:
                lp.leftMargin = viewMargin;
                break;
            case Gravity.RIGHT:
                lp.rightMargin = viewMargin;
                break;
            case Gravity.BOTTOM:
                lp.bottomMargin = viewMargin;
                break;
        }
        vChanged.setLayoutParams(lp);
    }


    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_left:
                    viewGravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;
                    sideGravity = Gravity.LEFT;
                    break;
                case R.id.btn_top:
                    viewGravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
                    sideGravity = Gravity.TOP;
                    break;
                case R.id.btn_right:
                    viewGravity = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
                    sideGravity = Gravity.RIGHT;
                    break;
                case R.id.btn_bottom:
                    viewGravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                    sideGravity = Gravity.BOTTOM;
                    break;
            }
            updateView();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = (Button) findViewById(R.id.btn_left);
        btnRight = (Button) findViewById(R.id.btn_right);
        btnTop = (Button) findViewById(R.id.btn_top);
        btnBottom = (Button) findViewById(R.id.btn_bottom);
        vChanged = (View) findViewById(R.id.view_changed);
        sbWeight = (SeekBar) findViewById(R.id.sb_weight);

        btnLeft.setOnClickListener(clickListener);
        btnRight.setOnClickListener(clickListener);
        btnBottom.setOnClickListener(clickListener);
        btnTop.setOnClickListener(clickListener);

        sbWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewMargin = progress;
                updateView();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}