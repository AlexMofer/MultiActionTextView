package am.example.multiactiontextview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import am.widget.multiactiontextview.MultiActionClickableSpan;
import am.widget.multiactiontextview.MultiActionTextView;

public class MultiActionTextViewActivity extends AppCompatActivity implements View.OnClickListener,
        MultiActionClickableSpan.OnTextClickedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiactiontextview);
        Toolbar mToolbar = findViewById(R.id.mat_toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }
        MultiActionTextView textView = findViewById(R.id.mat_tv_content);
        final int colorPrimary = ContextCompat.getColor(this, R.color.colorPrimary);
        final int colorAccent = ContextCompat.getColor(this, R.color.colorAccent);
        final int colorRipple = ContextCompat.getColor(this, R.color.colorRipple);
        MultiActionClickableSpan action1 = new MultiActionClickableSpan(
                0, 7, colorPrimary, true, false, this);
        MultiActionClickableSpan action2 = new MultiActionClickableSpan(
                10, 15, colorAccent, false, true, this);
        MultiActionClickableSpan action3 = new MultiActionClickableSpan(
                134, 140, colorRipple, false, true, this);
        MultiActionClickableSpan action4 = new MultiActionClickableSpan(
                181, 189, colorRipple, false, true, this);
        MultiActionClickableSpan action5 = new MultiActionClickableSpan(
                214, 230, colorRipple, false, true, this);
        MultiActionClickableSpan action6 = new MultiActionClickableSpan(
                346, 356, colorRipple, false, true, this);
        MultiActionClickableSpan action7 = new MultiActionClickableSpan(
                382, 392, colorRipple, false, true, this);
        textView.setText(R.string.multiactiontextview_content,
                action1, action2, action3, action4, action5, action6, action7);
        textView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, R.string.multiactiontextview_toast, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTextClicked(View view, MultiActionClickableSpan span) {
        String text = ((TextView) view).getText().toString();
        Toast.makeText(this, text.substring(span.getStart(), span.getEnd()),
                Toast.LENGTH_SHORT).show();
    }
}
