package quick.adapter.helper;
import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/2/4.
 */
public class ImageHandler
{
    static ImageHandle imageHandle;
    public static void display(Context context, ImageView view, String imageUrl){
        imageHandle.display(context,view,imageUrl);
    }

    public static void setImageHandle(ImageHandle imageHandle)
    {
        ImageHandler.imageHandle = imageHandle;
    }
}
