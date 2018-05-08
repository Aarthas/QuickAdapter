package quick.widget;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import quick.widget.help.IImageViewHelp;

/**
 * Created by hoang8f on 5/5/14.
 */

public class IImageView extends ImageView
{
    public IImageView(Context context)
    {
        super(context);
    }

    public IImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }


    public IImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs)
    {
        final StateListDrawable img = IImageViewHelp.parseAttrs(context, attrs);
        if (img != null)
        {
            setImageDrawable(img);
        }

    }

}