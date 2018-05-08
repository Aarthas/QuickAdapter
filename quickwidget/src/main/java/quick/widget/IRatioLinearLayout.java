package quick.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import net.soulwolf.widget.ratiolayout.widget.RatioLinearLayout;

import quick.widget.help.IButtonHelper;
import quick.widget.utils.ViewHelp;

/**
 * Created by hoang8f on 5/5/14.
 */

public class IRatioLinearLayout extends RatioLinearLayout
{


    public IRatioLinearLayout(Context context)
    {
        super(context);
    }

    public IRatioLinearLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        final Drawable stateListDrawable = IButtonHelper.parseAttrs(context, attrs);

        ViewHelp.setBackground(this, stateListDrawable);
    }



}