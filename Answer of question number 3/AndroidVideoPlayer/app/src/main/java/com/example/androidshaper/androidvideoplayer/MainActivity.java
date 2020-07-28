package com.example.androidshaper.androidvideoplayer;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.khizar1556.mkvideoplayer.IjkVideoView;
import com.khizar1556.mkvideoplayer.MKPlayer;
import com.khizar1556.mkvideoplayer.MKPlayerActivity;
import net.alhazmy13.mediapicker.Video.VideoPicker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    RecyclerView recyclerViewVideo;
    IjkVideoView ijkVideoView;
    MyAdapter myAdapter;
    File fileDirectory;
    String TAG="MainActivity";
    public static ArrayList<File> fileArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewVideo=findViewById(R.id.recyclerViewVideo);
        Toolbar toolbar=findViewById(R.id.toolobar);
        ijkVideoView=findViewById(R.id.mk_player);
        setSupportActionBar(toolbar);

        recyclerViewVideo.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        if (savedInstanceState==null)
        {

            loadVideo();
        }
        else
        {
            fileArrayList.clear();
            loadVideo();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.addVideeo)
        {

            loadGallery();
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadGallery() {
        new VideoPicker.Builder(MainActivity.this)
                .mode(VideoPicker.Mode.CAMERA_AND_GALLERY)
                .directory(VideoPicker.Directory.DEFAULT)
                .extension(VideoPicker.Extension.MP4)
                .enableDebuggingMode(true)
                .build();

    }

    private void loadVideo() {
        String[] perms={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        if(EasyPermissions.hasPermissions(this,perms))
        {

            getDirectory();


        }
        else{
            EasyPermissions.requestPermissions(this,"Please Allow Permission  Storage",1,perms);
        }
    }

    private void getDirectory() {


        String  rootPath=String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));


//      fileDirectory=new File("/storage/emulated/0/DCIM/");
        fileDirectory=new File("/mnt/");


        fileArrayList= getFile(fileDirectory);
        Log.e(TAG, "ArrayListSize: "+String.valueOf(fileArrayList.size()));


        if (fileArrayList.size()>0)
        {
            myAdapter=new MyAdapter(getApplicationContext(),fileArrayList);
            recyclerViewVideo.setAdapter(myAdapter);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Arraylist is Faka",Toast.LENGTH_SHORT).show();
        }
    }

    @NonNull
    public ArrayList<File> getFile(@NonNull File fileDirectory) {
        if (fileDirectory.isDirectory())
        {
            final File[] files;
            files=fileDirectory.listFiles();



            if(files!=null&&files.length>0)
            {

//                Log.e(TAG, "getFile: "+String.valueOf(files.length));
                for (int i=0; i<files.length; i++)
                {

                    if (files[i].isDirectory())
                    {
                        getFile(files[i]);
                    }
                     else if (files[i].isFile())
                    {
//                        Log.e(TAG, "getFile: "+files[i].getName().toString());
                        if (files[i].getName().endsWith(".mp4"))
                        {
                            fileArrayList.add(files[i]);
                            for (int j=0;j<fileArrayList.size();j++)
                            {

                                if (fileArrayList.get(j).getName().equals(files[i].getName()))
                                {


                                    Log.e(TAG, "getFile: "+"Same name file");

                                }
                                else
                                {
                                    fileArrayList.remove(files[i]);

                                    fileArrayList.add(files[i]);
                                }
                            }
                        }



                    }


                }


            }


        }
        else
        {
            Toast.makeText(getApplicationContext(),"Video not available",Toast.LENGTH_SHORT).show();

        }






        return fileArrayList;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            final List<String> mPaths =  data.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH);

//            Your Code
//            MKPlayerActivity.configPlayer(this).play(mPaths.get(0));

//            final MKPlayer mkplayer = new  MKPlayer(this);
//            mkplayer.play(mPaths.get(0));
//            mkplayer.getCurrentPosition();
//
//            mkplayer.setPlayerCallbacks(new MKPlayer.playerCallbacks() {
//                @Override
//                public void onNextClick() {
//
////                    mkplayer.play(mPaths.get(0+1));
//                    MKPlayerActivity.configPlayer(MainActivity.this).play(mPaths.get(mkplayer.getCurrentPosition()+1));
//                }
//                @Override
//                public void onPreviousClick() {
//
//                    mkplayer.play(mPaths.get(0));
//                }
//            });



        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this,"Camera Works",Toast.LENGTH_SHORT).show();

       getDirectory();

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms))
        {
            new AppSettingsDialog.Builder(this).build().show();;
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        fileArrayList.clear();
        loadVideo();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fileArrayList.clear();
        loadVideo();
    }
}