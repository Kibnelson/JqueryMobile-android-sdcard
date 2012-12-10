package com.example.jsonformsample;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import org.json.JSONObject;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

public class JavaScriptInterface {
    Context mContext;
	private JSONObject jObject;

    /** Instantiate the interface and set the context */
    JavaScriptInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    
    public String showJson() {
    	
    	return getJsonFile();
    }
    
    
    public String getJsonFile(){
    	
    	 String jString = null;
    	
    	try {

            File dir = Environment.getExternalStorageDirectory();
            File yourFile = new File(dir, "form.json");
            FileInputStream stream = new FileInputStream(yourFile);
           
            try {
                FileChannel fc = stream.getChannel();
                MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
                /* Instead of using default, pass in a decoder. */
                jString = Charset.defaultCharset().decode(bb).toString();
              }
              finally {
                stream.close();
              }


                     jObject = new JSONObject(jString); 

                   

        } catch (Exception e) {e.printStackTrace();}
    	
    	return  jObject.toString();
    }
}