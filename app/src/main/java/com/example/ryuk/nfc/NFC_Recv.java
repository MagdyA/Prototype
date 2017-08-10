package com.example.ryuk.nfc;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NFC_Recv extends AppCompatActivity {
    
    TextView textView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcdisplay);
        textView = (TextView) findViewById(R.id.textview);
    }
    
    @Override
    protected void onResume(){
        super.onResume();
        Intent intent = getIntent();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(intent.getAction())) {
            Parcelable[] rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            
            NdefMessage message = (NdefMessage) rawMessages[0];
            textView.setText(new String(message.getRecords()[0].getPayload()));
            
        } else
            textView.setText("Waiting for Message");
        
    }
}
