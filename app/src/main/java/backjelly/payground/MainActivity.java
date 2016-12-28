package backjelly.payground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    RelativeLayout layoutMenu,layoutActionBar, layoutHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().hide();
        layoutMenu = (RelativeLayout)findViewById(R.id.layoutMenu);
        layoutActionBar = (RelativeLayout)findViewById(R.id.layoutActionBar);
        layoutHeader = (RelativeLayout)findViewById(R.id.layoutHeader);

        scrollView = (ScrollView)findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(new View.OnTouchListener() {

            final int DISTANCE = 3;
            float startY = 0;
            float dist = 0;
            boolean isMenuHide = false;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                if(action == MotionEvent.ACTION_DOWN){
                    startY = motionEvent.getY(); //get initial y value
                }
                else if(action == MotionEvent.ACTION_MOVE){
                    dist = motionEvent.getY() - startY;
                    if(pxToDp((int)dist))
                }








                return false;
            }
        });





    }

    public int pxToDp(int px) {
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        int dp = Math.round(px / (dm.densityDpi
                / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }
}
