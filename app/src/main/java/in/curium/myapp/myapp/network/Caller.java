package in.curium.myapp.myapp.network;

import com.google.gson.Gson;
import in.curium.myapp.myapp.models.Repo;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Caller {

  private GitHubService service;

  public Caller(Gson gson) {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    service = retrofit.create(GitHubService.class);
  }

  public void getListOfRepos(Callback<List<Repo>> reposCallback) {
    Call<List<Repo>> call = service.listRepos("google");
    call.enqueue(reposCallback);
  }
}
