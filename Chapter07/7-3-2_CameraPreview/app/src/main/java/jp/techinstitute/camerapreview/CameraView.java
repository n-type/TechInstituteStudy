package jp.techinstitute.camerapreview;

import android.content.Context;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by n_type on 2015/11/26.
 */
public class CameraView extends SurfaceView implements SurfaceHolder.Callback, Camera.PictureCallback {

    private SurfaceHolder holder;
    private Camera camera;
    private MainActivity activity;

    public CameraView(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        activity = (MainActivity) context;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            // カメラをオープン
            camera = Camera.open();
            // プレビューディスプレイ(表示先)を設定
            camera.setPreviewDisplay(holder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // 画面に変更があったときはstartPreview
        camera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // プレビュー停止
        camera.stopPreview();
        // カメラをリリース
        camera.release();
        camera = null;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        // タッチダウンイベントで
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            camera.takePicture(null,null,null,this);
        }
        return true;
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        try{
            activity.insertPhoto(data);
        } catch (Exception e){
            e.printStackTrace();
        }
        // プレビュー再開
        camera.startPreview();
    }

}
