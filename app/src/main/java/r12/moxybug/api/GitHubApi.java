package r12.moxybug.api;

import java.util.List;

import io.reactivex.Observable;
import r12.moxybug.models.GitHubUser;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by R12 on 05.11.2017.
 */

public interface GitHubApi {

    @GET("/users/{username}/followers")
    Observable<List<GitHubUser>> getUser(@Path("username") String username);


}
