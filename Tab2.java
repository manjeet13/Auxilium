package com.example.tarun.auxilium;
import android.net.Uri;
import android.os.Bundle;

/*package net.simplifiedcoding.androidtablayout;
*/
import android.os.Bundle;
import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.MediaController;
        import android.widget.Toast;
        import android.widget.VideoView;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class Tab2 extends Fragment {

    private static String[] names=new String[]{"HEART ATTACK","FRACTURE","FIRE BURN","SEIZURE"};

    //Overriden method onCreateView

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        final View v = inflater.inflate(R.layout.tab2, container, false);


        final ListView lv = (ListView) v.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, names);
        lv.setAdapter(adapter);




        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String val=(String)lv.getItemAtPosition(position);
                VideoView videoView5=(VideoView)v.findViewById(R.id.videoView);
                videoView5.stopPlayback();
                switch(val)
                {
                    case "HEART ATTACK":
                        VideoView videoView =(VideoView)v.findViewById(R.id.videoView);
                        MediaController mediaController= new MediaController(getActivity());
                        mediaController.setAnchorView(videoView);
                        Uri uri=Uri.parse("rtsp://r2---sn-a5meknes.googlevideo.com/Cj0LENy73wIaNAmIeYLaLXQ4WBMYDSANFC0DP39XMOCoAUIASARgi--PsdGehqxWigELbHRKMkRsaG1HODQM/47696F682816F434F3C4F75E3E05E62703C89942.B37E0DFB9C638A8F3699A1FBB3D313DE40737F16/yt6/1/video.3gp");
                        videoView.setMediaController(mediaController);
                        videoView.setVideoURI(uri);
                        videoView.requestFocus();
                        videoView.start();
                        Toast.makeText(getActivity(),"heart attack",Toast.LENGTH_SHORT).show();
                        break;
                    case "FRACTURE":

                        VideoView videoView2 =(VideoView)v.findViewById(R.id.videoView);
                        // videoView2.stopPlayback();
                        MediaController mediaController2= new MediaController(getActivity());
                        mediaController2.setAnchorView(videoView2);

                        Uri uri2=Uri.parse("rtsp://r18---sn-a5m7znel.googlevideo.com/Cj0LENy73wIaNAm7fQV0VR1zWBMYDSANFC0fv35XMOCoAUIASARgi--PsdGehqxWigELbHRKMkRsaG1HODQM/410BE3310DC0DAC0A27ABF61C7B90A9717A2C468.79E9E61CA1516629D597599EE8DE60A4F20E4348/yt6/1/video.3gp");
                        videoView2.setMediaController(mediaController2);
                        videoView2.setVideoURI(uri2);
                        videoView2.requestFocus();
                        videoView2.start();
                        Toast.makeText(getActivity(),"fracture",Toast.LENGTH_SHORT).show();
                        break;
                    case "FIRE BURN":
                        VideoView videoView3 =(VideoView)v.findViewById(R.id.videoView);
                        //videoView3.stopPlayback();
                        MediaController mediaController3= new MediaController(getActivity());
                        mediaController3.setAnchorView(videoView3);
                        Uri uri3=Uri.parse("rtsp://r18---sn-a5m7znel.googlevideo.com/Cj0LENy73wIaNAm7fQV0VR1zWBMYDSANFC0fv35XMOCoAUIASARgi--PsdGehqxWigELbHRKMkRsaG1HODQM/410BE3310DC0DAC0A27ABF61C7B90A9717A2C468.79E9E61CA1516629D597599EE8DE60A4F20E4348/yt6/1/video.3gp");
                        videoView3.setMediaController(mediaController3);
                        videoView3.setVideoURI(uri3);
                        videoView3.requestFocus();
                        videoView3.start();
                        Toast.makeText(getActivity(),"fire burn",Toast.LENGTH_SHORT).show();
                        break;
                    case "SEIZURE":
                        VideoView videoView4 =(VideoView)v.findViewById(R.id.videoView);
                        //videoView4.stopPlayback();
                        MediaController mediaController4= new MediaController(getActivity());
                        mediaController4.setAnchorView(videoView4);
                        Uri uri4=Uri.parse("rtsp://r18---sn-a5m7znel.googlevideo.com/Cj0LENy73wIaNAm7fQV0VR1zWBMYDSANFC0fv35XMOCoAUIASARgi--PsdGehqxWigELbHRKMkRsaG1HODQM/410BE3310DC0DAC0A27ABF61C7B90A9717A2C468.79E9E61CA1516629D597599EE8DE60A4F20E4348/yt6/1/video.3gp");
                        videoView4.setMediaController(mediaController4);
                        videoView4.setVideoURI(uri4);
                        videoView4.requestFocus();
                        videoView4.start();
                        Toast.makeText(getActivity(),"seizure",Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        return v;
    }
}