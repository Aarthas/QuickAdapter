package quick.widget;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;

import net.soulwolf.widget.ratiolayout.widget.RatioImageView;

import quick.widget.help.IImageViewHelp;

/**
 * Created by hoang8f on 5/5/14.
 */

public class IRatioImageView extends RatioImageView
{


    public IRatioImageView(Context context)
    {
        super(context);
    }

    public IRatioImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        final StateListDrawable stateListDrawable = IImageViewHelp.parseAttrs(context, attrs);
        setImageDrawable(stateListDrawable);
    }

    public IRatioImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        final StateListDrawable stateListDrawable = IImageViewHelp.parseAttrs(context, attrs);
        setImageDrawable(stateListDrawable);
    }




}