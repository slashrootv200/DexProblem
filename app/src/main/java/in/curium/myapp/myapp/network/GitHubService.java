package in.curium.myapp.myapp.network;

import in.curium.myapp.myapp.models.Repo;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
  @GET("users/{user}/repos")
  Call<List<Repo>> listRepos(
      @Path("user")
      String user);
}
