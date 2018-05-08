package quick.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import quick.widget.help.IButtonHelper;import quick.widget.utils.ViewHelp;

/**
 * Created by admin on 2015/10/21.
 */
public class ILinearLayout extends LinearLayout
{
    public ILinearLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        final Drawable stateListDrawable = IButtonHelper.parseAttrs(context, attrs);
        ViewHelp.setBackground(this, stateListDrawable);
    }
}
