package com.poojab26.firebasedatabasecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.poojab26.firebasedatabasecrud.Model.Topic;

public class MainActivity extends AppCompatActivity {

    EditText etUserTopic;
    Spinner spBranch;
    RadioGroup rgDifficulty;
    Button btnAddTopic;
    RadioButton checkedRadio;

    String mTopicName, mTopicDifficulty, mTopicBranch;
    int mTopicRevisionCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference topicsRef = database.getReference("topics");
        btnAddTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveNewTopic();
                sendToDatabase(topicsRef);

            }
        });
    }

    private void sendToDatabase(DatabaseReference topicsRef) {
        String topicId = topicsRef.push().getKey();
        Topic topic = new Topic(mTopicName, mTopicBranch, mTopicDifficulty, mTopicRevisionCount);
        topicsRef.child(topicId).setValue(topic);

    }

    private void setUpUI() {
        spBranch = findViewById(R.id.spBranch);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.branches, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBranch.setAdapter(adapter);

        rgDifficulty = findViewById(R.id.rgDifficulty);
        etUserTopic = findViewById(R.id.etUserTopic);
        btnAddTopic = findViewById(R.id.btnAddTopic);
    }

    public void retrieveNewTopic() {
        mTopicName = etUserTopic.getText().toString();
        int selectedId = rgDifficulty.getCheckedRadioButtonId();
        checkedRadio = findViewById(selectedId);
        mTopicDifficulty = checkedRadio.getText().toString();
        mTopicBranch = spBranch.getSelectedItem().toString();

    }
}
