package com.example.com.myapplication.talkdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.com.myapplication.R;

import org.w3c.dom.Text;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

public class TalkActivity extends ActionBarActivity {

    private List<Message> messageList = new ArrayList<Message>();

    private MessageAdapter adapter;

    EditText inputText;
    ListView msgListView;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk);

        initMsg();

        adapter = new MessageAdapter(TalkActivity.this, R.layout.msg_item, messageList);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Message msg = new Message(content, Message.TYPE_SENT);
                    messageList.add(msg);
                    adapter.notifyDataSetChanged(); // 当有新消息时，刷新ListView中的显示
                    msgListView.setSelection(messageList.size()); // 将ListView定位到最后一行
                    inputText.setText(""); // 清空输入框中的内容
                }
            }
        });

    }

    private void initMsg() {
        Message msg1 = new Message("Hello", Message.TYPE_RECEIVED);
        messageList.add(msg1);
        Message msg2 = new Message("World", Message.TYPE_SENT);
        messageList.add(msg2);
        Message msg3 = new Message("This is genvay, hahahahahhahaha", Message.TYPE_RECEIVED);
        messageList.add(msg3);
        Message msg4 = new Message("hahahahhahahahhahahhahhhahaah", Message.TYPE_SENT);
        messageList.add(msg4);
    }

}
