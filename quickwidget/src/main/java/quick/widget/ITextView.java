package quick.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

import quick.widget.help.ITextColorHelper;
import quick.widget.help.ITextViewHelper;

/**
 * Created by hoang8f on 5/5/14.
 */

public class ITextView extends TextView
{
    public ITextView(Context context)
    {
        super(context);
    }

    public ITextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        ITextViewHelper.parseBackground(context, attrs, this);
        ColorStateList colorStateList = ITextColorHelper.parseTextColor(context, attrs);
        if (colorStateList != null)
            setTextColor(colorStateList);
    }


    public void setSolidColor(int solidColor)
    {
        final GradientDrawable background = (GradientDrawable) getBackground();
        background.setColor(solidColor);
    }
}