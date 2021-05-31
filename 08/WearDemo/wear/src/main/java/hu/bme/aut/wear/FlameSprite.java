package hu.bme.aut.wear;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public class FlameSprite {
    private static final int BMP_ROWS = 4;
    private static final int BMP_COLUMNS = 4;
    private int x = 0;
    private int y = 0;
    private FlameView flameView;
    private Bitmap bmp;
    private int currentFrame = 0;
    private int width;
    private int height;

    public FlameSprite(FlameView flameView, Bitmap bmp) {
        this.flameView = flameView;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;
    }

    private void update() {
        currentFrame = ++currentFrame;
    }

    public void onDraw(Canvas canvas) {
        update();
        int srcX = currentFrame % BMP_COLUMNS * width;
        int srcY = (currentFrame / BMP_COLUMNS) % BMP_ROWS * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, flameView.getWidth(), flameView.getHeight());
        canvas.drawBitmap(bmp, src, dst, null);
    }
}