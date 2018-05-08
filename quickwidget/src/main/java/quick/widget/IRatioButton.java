package quick.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;

import net.soulwolf.widget.ratiolayout.widget.RatioTextView;

import quick.widget.help.IButtonHelper;
import quick.widget.help.ITextColorHelper;import quick.widget.utils.ViewHelp;

/**
 * Created by hoang8f on 5/5/14.
 */

public class IRatioButton extends RatioTextView
{



    public IRatioButton(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setGravity(Gravity.CENTER);
        final Drawable stateListDrawable = IButtonHelper.parseAttrs(context, attrs);
        ViewHelp.setBackground(this, stateListDrawable);

        final ColorStateList colorStateList = ITextColorHelper.parseTextColor(context, attrs);
        if (colorStateList != null)
            setTextColor(colorStateList);
    }





}