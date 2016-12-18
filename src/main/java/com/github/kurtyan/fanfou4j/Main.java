package com.github.kurtyan.fanfou4j;

import com.github.kurtyan.fanfou4j.core.FanfouClient;
import com.github.kurtyan.fanfou4j.core.FanfouProfile;
import com.github.kurtyan.fanfou4j.core.UsernamePasswordAuthenticator;
import com.github.kurtyan.fanfou4j.entity.Status;
import com.github.kurtyan.fanfou4j.http.Authenticator;
import com.github.kurtyan.fanfou4j.request.status.ListPublicTimelineRequest;

/**
 * Created by yanke on 2016/12/6.
 */
public class Main {

    public static void main(String[] args) {
        String username = System.getenv("username");
        String password = System.getenv("password");

        Authenticator authenticator = new UsernamePasswordAuthenticator(username, password);
        FanfouProfile profile = new FanfouProfile(authenticator);
        FanfouClient client = new FanfouClient(profile);


        ListPublicTimelineRequest request = new ListPublicTimelineRequest();
        request.setCount(10L);

        Status[] list = client.execute(request);

        int i = 0;

    }

}
