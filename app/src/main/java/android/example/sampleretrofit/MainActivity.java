package android.example.sampleretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.example.sampleretrofit.api.APIInterface;
import android.example.sampleretrofit.api.ApiClient;
import android.example.sampleretrofit.api.TodosListResponse;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTodosList();
    }

    private void getTodosList() {
        try {
            APIInterface call1 = ApiClient.getClient().create(APIInterface.class);
            call1.doGetTodosList().enqueue(new Callback<List<TodosListResponse>>() {
                @Override
                public void onResponse(Call<List<TodosListResponse>> call, Response<List<TodosListResponse>> response) {
                    ((TextView) findViewById(R.id.txt_msg)).setText(response.body().get(0).getTitle());
                    for (int i=0;i<response.body().size();i++) {
                        Log.e("Response", response.body().get(i).getTitle());
                    }
                }

                @Override
                public void onFailure(Call<List<TodosListResponse>> call, Throwable t) {
                    Log.e("Response", t.getMessage());
                }
            });
        } catch (Exception ex) {
            Log.e("Response", ex.getMessage());

        }

    }
}