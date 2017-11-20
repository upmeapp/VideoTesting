package assaf.zfani.videotesting;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    File saveFile;
    Uri saveFileUri;
    private static int Take_PIC = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                saveFile = new File(Environment.getExternalStorageDirectory(),"test.mp4");
                saveFileUri = Uri.fromFile(saveFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,saveFileUri);
                startActivityForResult(intent,Take_PIC);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==Take_PIC)
        {
            VideoView videoView = (VideoView)findViewById(R.id.videoView);
            videoView.setVideoURI(saveFileUri);
            videoView.start();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
