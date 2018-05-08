package quick.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import quick.widget.help.IButtonHelper;
import quick.widget.utils.ViewHelp;

/**
 * Created by hoang8f on 5/5/14.
 */

public class IBackgroundImageView extends ImageView
{
    public IBackgroundImageView(Context context)
    {
        super(context);
    }

    public IBackgroundImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        final Drawable stateListDrawable = IButtonHelper.parseAttrs(context, attrs);
        ViewHelp.setBackground(this, stateListDrawable);
    }

    public IBackgroundImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        final Drawable stateListDrawable = IButtonHelper.parseAttrs(context, attrs);
        ViewHelp.setBackground(this, stateListDrawable);
    }



}