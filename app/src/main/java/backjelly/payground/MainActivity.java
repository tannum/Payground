package backjelly.payground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView)findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(new View.OnTouchListener() {

            int action = event.getAction();

            if(action == MotionEvent.ACTION_DOWN) {
                startY = event.getY();
            } else if(action == MotionEvent.ACTION_MOVE) {
                dist = event.getY() - startY;

                if((pxToDp((int)dist) <= -DISTANCE) && !isMenuHide) {
                    isMenuHide = true;
                    hideMenuBar();
                } else if((pxToDp((int)dist) > DISTANCE) && isMenuHide) {
                    isMenuHide = false;
                    showMenuBar();
                }

                if((isMenuHide && (pxToDp((int)dist) <= -DISTANCE))
                        || (!isMenuHide && (pxToDp((int)dist) > 0))) {
                    startY = event.getY();
                }
            } else if(action == MotionEvent.ACTION_UP) {
                startY = 0;
            }

            return false;
        });

    }
}
