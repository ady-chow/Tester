package com.ady.tester;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/** Created by ady on 2018/5/3. */
public class MainAct extends Activity {
  private static final String TAG = "et";

  @BindView(R.id.edit_text)
  EditText editText;

  @BindView(R.id.text_view)
  TextView textView;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.act_main);
    ButterKnife.bind(this);
    testEditText();
  }

  private void testEditText() {
    String testSpaceString = "得的我一直以为明明的                     紧急";
    textView.setText(testSpaceString);
    editText.setHint(testSpaceString);
    editText.addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            Log.d(
                TAG,
                "beforeTextChanged: s = "
                    + s
                    + ", start = "
                    + start
                    + ", count = "
                    + count
                    + ", after = "
                    + after);
          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d(
                TAG,
                "onTextChanged: s = "
                    + s
                    + ", start = "
                    + start
                    + ", before = "
                    + before
                    + ", count = "
                    + count);
          }

          @Override
          public void afterTextChanged(Editable s) {
            Log.d(TAG, "afterTextChanged: s = " + s);
          }
        });
  }
}
