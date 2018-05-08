package quick.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import quick.widget.help.IButtonHelper;
import quick.widget.utils.ViewHelp;

/**
 * Created by hoang8f on 5/5/14.
 */

public class IRelativeLayout extends RelativeLayout
{


    public IRelativeLayout(Context context)
    {
        super(context);
    }

    public IRelativeLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        final Drawable stateListDrawable = IButtonHelper.parseAttrs(context, attrs);
        ViewHelp.setBackground(this, stateListDrawable);
    }

    public IRelativeLayout(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        final Drawable stateListDrawable = IButtonHelper.parseAttrs(context, attrs);
        ViewHelp.setBackground(this, stateListDrawable);
    }


}