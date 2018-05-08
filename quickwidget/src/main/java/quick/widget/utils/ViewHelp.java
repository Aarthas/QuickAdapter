package quick.widget.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ViewHelp
{

    public static void gone(View view)
    {
        view.setVisibility(View.GONE);
    }

    public static void visible(View view)
    {
        view.setVisibility(View.VISIBLE);
    }

    public static void invisible(ImageView view)
    {
        view.setVisibility(View.INVISIBLE);
    }

    public static void from(View view, int from, int to, int duration)
    {
        TransitionDrawable transitionDrawable = null;
        transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(from), new
                ColorDrawable(to)});

        view.setBackgroundDrawable(transitionDrawable);
        transitionDrawable.startTransition(duration);
    }


    public static <E extends View> E findViewById(View view, int id)
    {
        return (E) view.findViewById(id);
    }


    public static void clearEditText(EditText editText)
    {
        editText.setText("");
    }

    public static String getEditResult(EditText edit)
    {
        return edit.getText().toString().trim();
    }

    public static String getEditHint(EditText edit)
    {
        return edit.getHint().toString().trim();
    }

    public static void setBackground(View view, Drawable drawable)
    {
        if (drawable != null)
        {
            if (Build.VERSION.SDK_INT >= 16)
            {
                view.setBackground(drawable);
            } else
            {
                view.setBackgroundDrawable(drawable);
            }

        }
    }

    public static void bindEditAndClearBtn(final EditText edtPwd, View btn_clear_pwd, final View
            pwdEye)
    {
        ViewHelp.bindEditAndClearBtn(edtPwd, btn_clear_pwd);

        pwdEye.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean isSeen = pwdEye.isSelected();
                boolean newisSeen = !isSeen;
                pwdEye.setSelected(newisSeen);
                if (newisSeen)
                {
                    edtPwd.setTransformationMethod(null);
                    edtPwd.setSelection(edtPwd.getText().length());

                } else
                {
                    edtPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edtPwd.setSelection(edtPwd.getText().length());
                }


            }
        });
    }

    public static void bindEditAndClearBtn(final EditText edittext, final View clear)
    {
        ViewHelp.gone(clear);
        clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ViewHelp.clearEditText(edittext);
                edittext.requestFocus();
            }
        });
        edittext.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (hasFocus)
                {
                    if (edittext.getText().length() > 0)
                    {
                        ViewHelp.visible(clear);
                    }
                } else
                {
                    ViewHelp.gone(clear);
                }
            }
        });
        edittext.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {

                if (s.toString().trim().length() > 0)
                    if (clear.isFocused())
                        ViewHelp.visible(clear);
                    else
                        ViewHelp.gone(clear);

            }
        });
    }


}
